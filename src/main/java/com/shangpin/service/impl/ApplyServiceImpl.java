package com.shangpin.service.impl;

import com.shangpin.common.JsonResult;
import com.shangpin.entity.dto.ApplyDTO;
import com.shangpin.entity.dto.ConfigDTO;
import com.shangpin.entity.dto.ReportDTO;
import com.shangpin.entity.vo.ApplyVO;
import com.shangpin.entity.vo.ConfigVO;
import com.shangpin.entity.vo.ReportVO;
import com.shangpin.mapper.CompanyMapper;
import com.shangpin.mapper.ConfigMapper;
import com.shangpin.mapper.PersonMapper;
import com.shangpin.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @package com.shangpin.service.impl
 * @className ApplyServiceImpl
 * @note TODO
 * @author wind
 * @date 2021/4/30 6:50
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public JsonResult<ApplyVO> queryResult(ReportDTO reportDTO) {
        List<ApplyVO> applyList = new ArrayList<>();
        List<ApplyDTO> items = reportDTO.getItem();
        List<ApplyVO> personList = personMapper.applyList(reportDTO);
        List<ApplyVO> companyList = companyMapper.applyList(reportDTO);
        applyList.addAll(personList);
        applyList.addAll(companyList);
        if(!CollectionUtils.isEmpty(items)){
            items.stream().filter(i -> !StringUtils.isEmpty(i.getApplyId())
                    && applyList.stream().noneMatch(a -> a.getApplyId().equals(i.getApplyId())))
                    .forEach(i -> {
                        ApplyVO vo = new ApplyVO();
                        vo.setApplyId(i.getApplyId());
                        vo.setReturnCode(4);
                        applyList.add(vo);
                    });
        }
        return JsonResult.success(applyList);
    }

    @Override
    public JsonResult<ReportVO> queryReport(ReportDTO reportDTO) {
        List<ReportVO> reportList = new ArrayList<>();
        List<ReportVO> personList = personMapper.reportList(reportDTO);
        List<ReportVO> companyList = companyMapper.reportList(reportDTO);
        reportList.addAll(personList);
        reportList.addAll(companyList);
        reportList.forEach(r -> {
            Integer reportId = r.getId();
            r.setReportDetails(companyMapper.reportDetailList(reportId));
        });
        return JsonResult.success(reportList);
    }


    @Override
    public JsonResult<ConfigVO> queryConfig(ConfigDTO configDTO) {
        List<ConfigVO> configVOList = configMapper.listConfigByTime(configDTO);
        configVOList.forEach(c -> {
            Integer id = c.getId();
            c.setCheckItems(configMapper.listCheckItem(id));
            c.setGroupItems(configMapper.listGroupItem(id));
        });
        return JsonResult.success(configVOList);
    }
}
