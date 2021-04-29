package com.shangpin.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.shangpin.common.Result;
import com.shangpin.dao.CheckRecordDao;
import com.shangpin.dao.EnterpriseReportDao;
import com.shangpin.dao.IndividualReportDao;
import com.shangpin.entity.*;
import com.shangpin.mapper.PlatformUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/check")
public class CheckController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EnterpriseReportDao enterpriseReportDao;
    @Autowired
    private IndividualReportDao individualReportDao;
    @Autowired
    private PlatformUserMapper platformUserMapper;
    @Autowired
    private CheckRecordDao checkRecordDao;

    @Value("${token}")
    private String token;
    @Value("${AppCode}")
    private String appCode;

    /**
     * 企业查验
     *
     * @param checkParam 参数
     * @return
     */
    @PostMapping("/rule")
    public Result rule(@RequestBody CheckParam checkParam,HttpServletRequest request) {
        //请求接口
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        //验证三要素
        JSONObject params = new JSONObject();
        params.put("name", checkParam.getName());
        params.put("code", checkParam.getCode());
        params.put("legalPersonName", checkParam.getLegalPersonName());
        HttpEntity httpEntity = new HttpEntity(params.toString(), headers);
        //开始请求  填入url,头,参数拿到数据
        ResponseEntity<JSONObject> exchange = restTemplate.exchange("https://open.api.tianyancha.com/services/open/ic/verify?name=" + checkParam.getName() + "&code=" + checkParam.getCode() + "&legalPersonName=" + checkParam.getLegalPersonName(), HttpMethod.GET, httpEntity, JSONObject.class);
        JSONObject body = exchange.getBody();
        //得到json数据 解析  reason是数据,reason有写哪些是成功,就可以跟具他提供的值判断的了
//        System.out.println(body.get("result"));
        if (!body.get("result").equals(true)) {
            return Result.error("三要素未找到");
        }
        //body,可以通过JSON操作取到他的值,判断
        //获取基本的信息
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", checkParam.getName());
        HttpEntity entity = new HttpEntity(jsonObject.toString(), headers);
        ResponseEntity<BusinessResultVo> responseEntity = restTemplate.exchange("http://open.api.tianyancha.com/services/open/ic/baseinfoV3/2.0?name=" + checkParam.getName(), HttpMethod.GET, entity, BusinessResultVo.class);
        BusinessResultVo businessResultVo = responseEntity.getBody();
        //取国民经济行业分类
        ResponseEntity<IndustryAllBeanResult> jsonObjectResponseEntity = restTemplate.exchange("http://open.api.tianyancha.com/services/open/ic/baseinfo/2.0?name=" + checkParam.getName(), HttpMethod.GET, entity, IndustryAllBeanResult.class);
        IndustryAllBeanResult.ResultBean.IndustryAllBean industryAllBean = jsonObjectResponseEntity.getBody().getResult().getIndustryAll();
        //行政处罚数目
        ResponseEntity<JSONObject> administrativePenaltiesResponseEntity = restTemplate.exchange("http://open.api.tianyancha.com/services/open/mr/creditChina/2.0?name=" + checkParam.getName(), HttpMethod.GET, entity, JSONObject.class);
        int administrativePenaltiesCount = getCount(administrativePenaltiesResponseEntity.getBody());
        //历史经营异常数目
        ResponseEntity<JSONObject> businessException = restTemplate.exchange("http://open.api.tianyancha.com/services/open/hi/abnormal/2.0?name=" + checkParam.getName(), HttpMethod.GET, entity, JSONObject.class);
        int BusinessExceptionCount = getCount(businessException.getBody());
        //历史法律诉讼数目
        ResponseEntity<JSONObject> legalProceedings = restTemplate.exchange("http://open.api.tianyancha.com/services/open/hi/lawsuit/2.0?name=" + checkParam.getName(), HttpMethod.GET, entity, JSONObject.class);
        int legalProceedingsCount = getCount(legalProceedings.getBody());
        //失信人数目
        ResponseEntity<JSONObject> dishonestPerson = restTemplate.exchange("http://open.api.tianyancha.com/services/open/hi/dishonest/2.0?name=" + checkParam.getName(), HttpMethod.GET, entity, JSONObject.class);
        int dishonestPersonCount = getCount(dishonestPerson.getBody());
        //资产负债
        ResponseEntity<JSONObject> totalAssets = restTemplate.exchange("http://open.api.tianyancha.com/services/open/stock/balanceSheet/2.0?year=" + Calendar.getInstance().get(Calendar.YEAR) + "name=" + checkParam.getName(), HttpMethod.GET, entity, JSONObject.class);
        AtomicInteger totalAssetsCount = new AtomicInteger(0);
        JSONObject body1 = totalAssets.getBody().getJSONObject("result");
        if (body1 != null) {
            JSONObject corpBalanceSheet = body1.getJSONObject("corpBalanceSheet");
            if (corpBalanceSheet != null) {
                totalAssetsCount.addAndGet((int) corpBalanceSheet.get("total_assets"));
            }
        }
        //下面这个代码是过滤前端提交过来的数据,就是把没选中的过滤掉
        List<RuleParam> ruleParams = checkParam.getRuleList().stream().filter(RuleParam::getSelected).collect(Collectors.toList());
        //下面就是去挨个判断是否符合这个条件
        ruleParams.forEach(info -> {
            if (info.getText().equals("公司所在省市区")) {
                //isContains方法用来判断是否符合
                setValue(info, businessResultVo.getResult().getRegLocation(), isContains(businessResultVo.getResult().getRegLocation(), info.getContent()));
            }
            if (info.getText().equals("企业状态")) {
                //isContains方法用来判断是否符合
                setValue(info, businessResultVo.getResult().getRegLocation(), isContains(businessResultVo.getResult().getRegStatus(), info.getContent()));
            }
            if (info.getText().equals("注册资本")) {
                String regCapital = businessResultVo.getResult().getRegCapital();
                //先把字符串中能转为数字的都转 比如注册资金100万就得把100取出来然后去对比
                long i = parseInt(regCapital);
                if (info.getContent().equals("0-100万")) {
                    setValue(info, i, i <= 100 && i >= 0);
                }
                if (info.getContent().equals("100万及以上")) {
                    setValue(info, i, i >= 100);
                }
                if (info.getContent().equals("200万及以上")) {
                    setValue(info, i, i >= 200);
                }
                if (info.getContent().equals("500万及以上")) {
                    setValue(info, i, i >= 500);
                }
                if (info.getContent().equals("1000及以上")) {
                    setValue(info, i, i >= 1000);
                }
                setValue(info, i, false);
            }
            if (info.getText().equals("行业分类")) {
                setValue(info, businessResultVo.getResult().getIndustry(), isContains(businessResultVo.getResult().getIndustry(), info.getContent()));
                //isContains(businessResultVo.getResult().getBusinessScope(), info.getContent())
            }
            if (info.getText().equals("成立时间")) {
                long estiblishTime = businessResultVo.getResult().getEstiblishTime();
                Date date = new Date(estiblishTime);
                int beginYear = DateUtil.year(date);
                int endYear = DateUtil.year(new Date());
                int i = endYear - beginYear;
                if (info.getContent().equals("1年内")) {
                    setValue(info, i, i <= 1);
                }
                if (info.getContent().equals("1年及以上")) {
                    setValue(info, i, i >= 1);
                }
                if (info.getContent().equals("5年及以上")) {
                    setValue(info, i, i >= 5);
                }
                if (info.getContent().equals("10年及以上")) {
                    setValue(info, i, i >= 10);
                }
                if (info.getContent().equals("15年及以上")) {
                    setValue(info, i, i >= 15);
                }
            }
            if (info.getText().equals("纳税人信用级别")) {
                setValue(info, businessResultVo.getResult().getRegLocation(), isContains(businessResultVo.getResult().getRegLocation(), info.getContent()));
            }
            if (info.getText().equals("企业类型")) {
                setValue(info, businessResultVo.getResult().getCompanyOrgType(), isContains(businessResultVo.getResult().getCompanyOrgType(), info.getContent()));
            }
            if (info.getText().equals("是否微小企业")) {
                if (info.getContent().equals("是")) {
                    setValue(info, "是", businessResultVo.getResult().getIsMicroEnt() == 1);
                } else {
                    setValue(info, "不是", businessResultVo.getResult().getIsMicroEnt() == 0);
                }
            }
            if (info.getText().equals("法人类型")) {
//                if (info.getContent().equals("个人")) {
                if (info.getContent().equals("个人")) {
                    System.out.println(info.getContent());
                    System.out.println(businessResultVo.getResult().getType());
                    setValue(info, "个人", businessResultVo.getResult().getType() == 1);
                } else {
                    System.out.println(info.getContent());
                    System.out.println(businessResultVo.getResult().getType());
                    setValue(info, "企业", businessResultVo.getResult().getType() == 1);
                }
            }
//            System.out.println(ruleParams);
        });
        //是用来过滤需要显示的数据,同样将不需要显示的先过滤了然后peek修改
        List<InformationParam> informationParams = checkParam.getInformation().stream().filter(InformationParam::isSelected).peek(info -> {
            //开始挨个比对找到一样的就去上面那些接口中取出数据,然后赋值
            if (info.getText().equals("负债与资产总额")) {
                info.setValue(String.valueOf(totalAssetsCount));
            } else if (info.getText().equals("历史法律诉讼(数目)")) {
                info.setValue(String.valueOf(legalProceedingsCount));
            } else if (info.getText().equals("失信人(数目)")) {
                info.setValue(String.valueOf(dishonestPersonCount));
            } else if (info.getText().equals("历史行政处罚(数目)")) {
                info.setValue(String.valueOf(administrativePenaltiesCount));
            } else if (info.getText().equals("经营异常(数目)")) {
                info.setValue(String.valueOf(BusinessExceptionCount));
            } else if (info.getText().equals("人员规模")) {
                info.setValue(businessResultVo.getResult().getStaffNumRange());
            } else if (info.getText().equals("经营开始时间--经营结束时间")) {
                long fromTime = businessResultVo.getResult().getFromTime();
                long toTime = businessResultVo.getResult().getToTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                info.setValue(simpleDateFormat.format(new Date(fromTime)) + "----" + simpleDateFormat.format(new Date(toTime)));
            } else if (info.getText().equals("成立日期")) {
                long estiblishTime = businessResultVo.getResult().getEstiblishTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                info.setValue(simpleDateFormat.format(new Date(estiblishTime)));
            } else if (info.getText().equals("联系方式")) {
                info.setValue(businessResultVo.getResult().getPhoneNumber());
            } else if (info.getText().equals("邮箱")) {
                info.setValue(businessResultVo.getResult().getEmail());
            } else if (info.getText().equals("网址")) {
                info.setValue(businessResultVo.getResult().getWebsiteList());
            } else if (info.getText().equals("吊销日期")) {
                Date revokeDate = (Date) businessResultVo.getResult().getRevokeDate();
                if (revokeDate != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    info.setValue(simpleDateFormat.format(revokeDate));
                }
            } else if (info.getText().equals("吊销原因")) {
                info.setValue(String.valueOf(businessResultVo.getResult().getRevokeReason()));
            } else if (info.getText().equals("注销日期")) {
                Date cancelDate = (Date) businessResultVo.getResult().getCancelDate();
                if (cancelDate != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    info.setValue(simpleDateFormat.format(cancelDate));
                }
            } else if (info.getText().equals("注销原因")) {
                info.setValue(String.valueOf(businessResultVo.getResult().getCancelReason()));
            } else if (info.getText().equals("国民经济行业分类(门类、大类、中类、小类)")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(industryAllBean.getCategory()).append("      ")
                        .append(industryAllBean.getCategoryBig()).append("      ")
                        .append(industryAllBean.getCategoryMiddle()).append("      ")
                        .append(industryAllBean.getCategorySmall()).append("      ");
                info.setValue(stringBuilder.toString());
            } else if (info.getText().equals("主要人员列表")) {
                BusinessResultVo.ResultBeanX.StaffListBean staffList = businessResultVo.getResult().getStaffList();
                StringBuilder mainStaffNames = new StringBuilder();
                for (BusinessResultVo.ResultBeanX.StaffListBean.ResultBean resultBean : staffList.getResult()) {
                    mainStaffNames.append(resultBean.getName() + "    ");
                }
                info.setValue(mainStaffNames.toString());
            }
        }).collect(Collectors.toList());
        String userId = request.getHeader("user");
        PlatformUser user = platformUserMapper.selectPlatformUserById(Long.valueOf(userId));
        CheckRecord checkRecord = new CheckRecord();
        checkRecord.setName(checkParam.getName());
        checkRecord.setAccount(user.getEmail());
        checkRecord.setCreateTime(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        checkRecord.setFolk(checkParam.getLegalPersonName());
        checkRecord.setCode(checkParam.getCode());
        checkRecord.setHistory(1);
        checkRecord.setType("企业");
        //不为空,更新历史记录+1,否则新增
        List<CheckRecord> checkRecords = checkRecordDao.queryAll(new CheckRecord().setName(checkParam.getName()).setType("企业"));
        if (CollUtil.isNotEmpty(checkRecords)){
            CheckRecord c = checkRecords.get(0);
            checkRecord.setId(c.getId());
            checkRecord.setHistory(c.getHistory()+1);
            checkRecordDao.update(checkRecord);
        }else{
            checkRecordDao.insert(checkRecord);
        }
        //更新查验规则中查验结果id
        EnterpriseReport enterpriseReport = new EnterpriseReport();
        enterpriseReport.setId(checkParam.getReportId());
        enterpriseReport.setCheckId(checkRecord.getId());
        enterpriseReportDao.update(enterpriseReport);

        BodyInformation bodyInformation = new BodyInformation();
        bodyInformation.setBodyNum(String.valueOf(checkRecord.getId()));
        bodyInformation.setFolk(checkParam.getLegalPersonName());
        bodyInformation.setType("全国统一社会信用代码");
        bodyInformation.setName(checkParam.getName());
        bodyInformation.setPermitPublic(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM")));
        bodyInformation.setNumber(checkParam.getCode());
        bodyInformation.setTradeName(user.getName());
        bodyInformation.setTime(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        //添加到一个map返回给前端渲染
        Map<String, Object> map = new HashMap<>();
        //取必要项
        List<RuleParam> ruleList_necessary = ruleParams.stream().filter(RuleParam::getDis).collect(Collectors.toList());
        //附加项
        List<RuleParam> ruleList_add = ruleParams.stream().filter(r -> !r.getDis()).collect(Collectors.toList());
        map.put("ruleList_necessary", ruleList_necessary);
        map.put("ruleList_add", ruleList_add);
        //信息项
        map.put("infor", informationParams);
        //主体项
        map.put("body_infor", bodyInformation);
        return Result.success(map);
        //除了main  idea
    }

    /**
     * 个人查验
     *
     * @param personParam 用户
     * @return
     */
    @PostMapping("/person")
    public Result person(@RequestBody PersonParam personParam,HttpServletRequest request) throws UnsupportedEncodingException {
        int mode = 2;
        //验证姓名身份证银行卡
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "APPCODE " + appCode);
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", personParam.getName());
        params.add("bank", personParam.getIdCard());
        params.add("number", personParam.getAccountNo());
        HttpEntity httpEntity = new HttpEntity<MultiValueMap>(params, headers);
        if (personParam.getIdCard() != null && personParam.getName() != null) {
            mode = 3;
        }
        if (personParam.getBankPreMobile() != null) {
            params.add("mobile", personParam.getBankPreMobile());
            mode = 4;
        }
        try {
            ResponseEntity<String> exchange = restTemplate.exchange("http://api11.aliyun.venuscn.com/cert/bank-card/" + mode + "?name=" + personParam.getName() + "&bank=" + personParam.getAccountNo() + "&number=" + personParam.getIdCard() + "&mobile=" + personParam.getBankPreMobile(), HttpMethod.GET, httpEntity, String.class);
            JSONObject body = JSONObject.parseObject(exchange.getBody());
            if (body.getJSONObject("data").get("code").equals("0")) {
                //保存到记录表
                String userId = request.getHeader("user");
                PlatformUser user = platformUserMapper.selectPlatformUserById(Long.valueOf(userId));
                CheckRecord checkRecord = new CheckRecord();
                checkRecord.setName(personParam.getName());
                checkRecord.setAccount(user.getEmail());
                checkRecord.setCreateTime(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                checkRecord.setFolk(personParam.getBankPreMobile());//手机号
                checkRecord.setCode(personParam.getIdCard());//身份证
                checkRecord.setHistory(1);
                checkRecord.setType("个人");
                checkRecord.setAccountNo(personParam.getAccountNo());
                //不为空,更新历史记录+1,否则新增
                List<CheckRecord> checkRecords = checkRecordDao.queryAll(new CheckRecord().setName(personParam.getName()).setType("个人"));
                if (CollUtil.isNotEmpty(checkRecords)){
                    CheckRecord c = checkRecords.get(0);
                    checkRecord.setId(c.getId());
                    checkRecord.setHistory(c.getHistory()+1);
                    checkRecordDao.update(checkRecord);
                }else{
                    checkRecordDao.insert(checkRecord);
                }


                /*//更新查验规则中查验结果id
                IndividualReport individualReport = new IndividualReport();
                individualReport.setId(personParam.getReportId());
                individualReport.setCheckId(checkRecord.getId());
                individualReportDao.update(individualReport);*/

                //返回
                BodyInformation bodyInformation = new BodyInformation();
                bodyInformation.setBodyNum(String.valueOf(checkRecord.getId()));
                if (personParam.getBankPreMobile() != null) {
                    bodyInformation.setPhone(new StringBuilder(personParam.getBankPreMobile()).replace(3,7,"****").toString());//手机号
                }
                bodyInformation.setType("身份证号");
                bodyInformation.setName(personParam.getName());
                bodyInformation.setPermitPublic(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM")));
                if (personParam.getIdCard() != null) {
                    bodyInformation.setNumber(new StringBuilder(personParam.getIdCard()).replace(4,14,"*******").toString());//身份证
                }
                bodyInformation.setTradeName(user.getName());
                bodyInformation.setTime(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                return Result.success(bodyInformation);
            } else {
                return Result.error("验证失败");
            }
        } catch (HttpClientErrorException e) {
            return Result.success(e.getMessage());
        }
    }

    /**
     * 当前查验规则列表
     * @param id 查验记录id
     */
    @GetMapping("/checkRecord")
    public Result list(Integer id) {
        EnterpriseReport enterpriseReport = enterpriseReportDao.queryByCheckId(id);
        ReportBody reportBody = new ReportBody();
        reportBody.setEnRule(JSONObject.parseArray(enterpriseReport.getEnrule(),RuleParam.class));
        reportBody.setEnInfor(JSONObject.parseArray(enterpriseReport.getEninfor(),InformationParam.class));
        return Result.success(enterpriseReport);
    }

    /**
     * 当前查验规则列表
     * @param id 用户id
     */
    @GetMapping("/checkRecordByUserId")
    public Result listByUserId(Integer id) {
        PlatformUser platformUser = platformUserMapper.selectPlatformUserById(Long.valueOf(id));
        List<EnterpriseReport> enterpriseReports = enterpriseReportDao.queryByUserEmail(platformUser.getEmail());
        for (EnterpriseReport enterpriseReport : enterpriseReports) {
            ReportBody reportBody = new ReportBody();
            reportBody.setEnRule(JSONObject.parseArray(enterpriseReport.getEnrule(),RuleParam.class));
            reportBody.setEnInfor(JSONObject.parseArray(enterpriseReport.getEninfor(),InformationParam.class));
        }
        return Result.success(enterpriseReports);
    }

    /**
     * 查验详情
     * @param name 企业名
     */
    @GetMapping("/list")
    public Result list(String name,HttpServletRequest request) {
        String userId = request.getHeader("user");
        PlatformUser platformUser = platformUserMapper.selectPlatformUserById(Long.valueOf(userId));
        CheckRecord checkRecord = new CheckRecord();
        checkRecord.setName(name);
        if (!"1".equals(userId)){
            checkRecord.setAccount(platformUser.getEmail());
        }
        //排序
        List<CheckRecord> checkRecords = Optional.of(checkRecordDao.queryAll(checkRecord)).orElseGet(Lists::newArrayList).stream().sorted(Comparator.comparing(CheckRecord::getCreateTime).reversed()).collect(Collectors.toList());
        //暂时合格
        checkRecords.forEach(c->c.setQualified("合格"));
        return Result.success(checkRecords);
    }

    /**
     * 查验规则保存
     *
     * @param reportBody 参数
     * @return
     */
    @PostMapping("/report")
    public Result report(@RequestBody ReportBody reportBody, HttpServletRequest request) {
        String userId = request.getHeader("user");
        PlatformUser platformUser = platformUserMapper.selectPlatformUserById(Long.valueOf(userId));
        EnterpriseReport enterpriseReport = new EnterpriseReport();
        enterpriseReport.setEnrule(JSONObject.toJSONString(reportBody.getEnRule()));
        enterpriseReport.setEninfor(JSONObject.toJSONString(reportBody.getEnInfor()));
        enterpriseReport.setUserEmail(platformUser.getEmail());
        enterpriseReportDao.insert(enterpriseReport);
        IndividualReport individualReport = new IndividualReport();
        individualReport.setInrule(JSONObject.toJSONString(reportBody.getInRule()));
        individualReport.setIninfor(JSONObject.toJSONString(reportBody.getInInfor()));
        individualReport.setUserEmail(platformUser.getEmail());
        individualReportDao.insert(individualReport);
        return Result.success(enterpriseReport.getId());
    }

    /**
     * 判断是否包含
     */
    public boolean isContains(String before, String after) {
        if (before != null && after != null) {
            //before是否包含after来判断的
            return before.contains(after);
        }
        return false;
    }

    /**
     * 设置是否符合或不符合并设置实际值
     */
    public void setValue(RuleParam ruleParam, Object act_result, boolean b) {
        ruleParam.setAct_result(String.valueOf(act_result));
        if (b) {
            ruleParam.setResult("符合");
        } else {
            ruleParam.setResult("不符合");
        }
    }

    /**
     * json获取数目
     */
    public int getCount(JSONObject jsonObject) {
        if (jsonObject != null) {
            JSONObject result = jsonObject.getJSONObject("result");
            if (result != null) {
                return (int) result.get("total");
            }
        }
        return 0;
    }

    /**
     * 字符串转数字,能转的都转
     */
    public long parseInt(String s) {
        String[] split = s.split("");
        StringBuilder temp = new StringBuilder();
        for (String str : split) {
            try {
                int i = Integer.parseInt(str);
                temp.append(i);
            } catch (Exception e) {
            }
        }
        return Long.parseLong(temp.toString());
    }
}
