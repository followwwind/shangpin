package com.shangpin.service;

import com.shangpin.common.JsonResult;
import com.shangpin.entity.Company;
import com.shangpin.entity.dto.BatchCompanyDTO;
import com.shangpin.entity.dto.CheckCompanyDTO;
import com.shangpin.entity.vo.CompanyVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * company service
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public interface CompanyService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(Company r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    Company get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Company r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<Company> list(Company r);

    /**
     * 综合服务平台一次查询一个或多个公司的信息
     * @param companyDTO
     * @return
     */
    JsonResult<Company> queryCompanyInfo(BatchCompanyDTO companyDTO);

    /**
     * 检测公司申请状态
     * @param companyDTO
     * @return
     */
    JsonResult<CompanyVO> checkCompany(CheckCompanyDTO companyDTO);
}