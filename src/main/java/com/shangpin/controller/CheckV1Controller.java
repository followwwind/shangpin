package com.shangpin.controller;

import com.shangpin.common.JsonResult;
import com.shangpin.entity.Company;
import com.shangpin.entity.dto.*;
import com.shangpin.entity.vo.*;
import com.shangpin.service.ApplyService;
import com.shangpin.service.CompanyService;
import com.shangpin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @package com.shangpin.controller
 * @className CheckV1Controller
 * @note /aiCheckService/api/v1/
 * @author wind
 * @date 2021/4/29 22:35
 */
@RestController
@RequestMapping("/aiCheckService/api/v1/")
public class CheckV1Controller {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ApplyService applyService;

    /**
     * 综合服务平台一次查询一个或多个公司的信息
     * @param companyDTO
     * @return
     */
    @PostMapping("/queryCompanyInfo")
    public JsonResult<Company> queryCompanyInfo(@RequestBody BatchCompanyDTO companyDTO){
        return companyService.queryCompanyInfo(companyDTO);
    }

    /**
     * 综合服务平台发起查询个人或企业用户的信息查验结果，按照查验申请批次号查询对应批次申请的所有查验结果，
     * 也可以查询本批次查验申请的部分交易申请的信息查验结果。
     * @param reportDTO
     * @return
     */
    @PostMapping("/queryResult")
    public JsonResult<ApplyVO> queryResult(@RequestBody ReportDTO reportDTO){
        return applyService.queryResult(reportDTO);
    }

    /**
     * 综合服务平台发起查询个人或企业用户的信息查验报告，可以按照查验申请批次号查询本批次的所有申请的查验报告，
     * 也可以查询本批次的部分查验申请的查验报告。
     * @param reportDTO
     * @return
     */
    @PostMapping("/queryReport")
    public JsonResult<ReportVO> queryReport(@RequestBody ReportDTO reportDTO){
        return applyService.queryReport(reportDTO);
    }

    /**
     * 请求参数中的生效起始时间参数不传递则返回所有已生效的准入配置；生效起始时间不为空时，
     * 返回该时间段之后被设置为生效的准入配置。
     * @param configDTO
     * @return
     */
    @RequestMapping(value = "/queryConfig", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult<ConfigVO> queryConfig(@RequestBody ConfigDTO configDTO){
        return applyService.queryConfig(configDTO);
    }

    /**
     * 综合服务平台发起企业类型的交易主体信息查验。
     * @param companyDTO
     * @return
     */
    @PostMapping("/check/company")
    public JsonResult<CompanyVO> checkCompany(@RequestBody CheckCompanyDTO companyDTO){
        return companyService.checkCompany(companyDTO);
    }

    /**
     * 综合服务平台发起个人类型的交易主体信息查验
     * @param personDTO
     * @return
     */
    @PostMapping("/check/person")
    public JsonResult<PersonVO> checkCompany(@RequestBody CheckPersonDTO personDTO){
        return personService.checkPerson(personDTO);
    }
}
