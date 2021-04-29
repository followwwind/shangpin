package com.shangpin.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.shangpin.common.JsonResult;
import com.shangpin.entity.ApplyCompany;
import com.shangpin.entity.Company;
import com.shangpin.entity.dto.BatchCompanyDTO;
import com.shangpin.entity.dto.CheckCompanyDTO;
import com.shangpin.entity.dto.CompanyDTO;
import com.shangpin.entity.vo.ApplyCompanyVO;
import com.shangpin.entity.vo.CompanyVO;
import com.shangpin.mapper.CompanyMapper;
import com.shangpin.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * company service
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	private Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    private CompanyMapper mapper;

    @Override
    public int save( Company r) {
    	logger.info("CompanyServiceImpl.save param: r is {}", r);
        Company entity = new Company();
        BeanUtil.copyProperties(r, entity);
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("CompanyServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public Company get(Integer id) {
    	logger.info("CompanyServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update( Company r) {
    	logger.info("CompanyServiceImpl.update param: r is {}", r);
        Company entity = new Company();
        BeanUtil.copyProperties(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<Company> list(Company r) {
    	logger.info("CompanyServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }

    @Override
    public JsonResult<Company> queryCompanyInfo(BatchCompanyDTO companyDTO) {
        List<CompanyDTO> dtoList = companyDTO.getItems();
        if(CollectionUtils.isEmpty(dtoList)){
            return JsonResult.error("社会统一信用代码列表，列表不为空");
        }
        List<String> succList = dtoList.stream().filter(d -> !StringUtils.isEmpty(d.getCert4SUCC()))
                .map(CompanyDTO::getCert4SUCC).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(succList)){
            return JsonResult.error("社会统一信用代码列表，列表不为空");
        }
        return JsonResult.success(mapper.listBySucc(succList));
    }

    @Override
    public JsonResult<CompanyVO> checkCompany(CheckCompanyDTO companyDTO) {
        List<ApplyCompanyVO> list = mapper.checkList(companyDTO);
        List<CompanyVO> voList = new ArrayList<>();
        list.forEach(v -> {
            CompanyVO companyVO = new CompanyVO();
            BeanUtil.copyProperties(v, companyVO);
            if(Integer.valueOf(1).equals(v.getStatus())){
                companyVO.setReturnCode(JsonResult.SUCCESS);
                companyVO.setReturnMsg("申请成功");
            }else if(Integer.valueOf(2).equals(v.getStatus())){
                companyVO.setReturnCode(JsonResult.FAIL);
                companyVO.setReturnMsg("申请失败");
            }else{
                companyVO.setReturnCode(JsonResult.SUCCESS);
                companyVO.setReturnMsg("申请中");
            }
            voList.add(companyVO);
        });
        return JsonResult.success(voList);
    }
}
