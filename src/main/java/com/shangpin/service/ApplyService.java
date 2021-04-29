package com.shangpin.service;

import com.shangpin.common.JsonResult;
import com.shangpin.entity.dto.ConfigDTO;
import com.shangpin.entity.dto.ReportDTO;
import com.shangpin.entity.vo.ApplyVO;
import com.shangpin.entity.vo.ConfigVO;
import com.shangpin.entity.vo.ReportVO;
import org.springframework.web.bind.annotation.RequestBody;

public interface ApplyService {

    /**
     * 综合服务平台发起查询个人或企业用户的信息查验结果，按照查验申请批次号查询对应批次申请的所有查验结果，
     * 也可以查询本批次查验申请的部分交易申请的信息查验结果。
     * @param reportDTO
     * @return
     */
    JsonResult<ApplyVO> queryResult(ReportDTO reportDTO);


    /**
     * 综合服务平台发起查询个人或企业用户的信息查验报告，可以按照查验申请批次号查询本批次的所有申请的查验报告，
     * 也可以查询本批次的部分查验申请的查验报告。
     * @param reportDTO
     * @return
     */
    JsonResult<ReportVO> queryReport(ReportDTO reportDTO);

    /**
     * 请求参数中的生效起始时间参数不传递则返回所有已生效的准入配置；生效起始时间不为空时，返回该时间段之后被设置为生效的准入配置。
     * @param configDTO
     * @return
     */
    JsonResult<ConfigVO> queryConfig(ConfigDTO configDTO);
}
