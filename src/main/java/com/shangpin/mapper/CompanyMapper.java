package com.shangpin.mapper;

import java.util.List;

import com.shangpin.entity.ApplyCompany;
import com.shangpin.entity.Company;
import com.shangpin.entity.ReportDetail;
import com.shangpin.entity.dto.CheckCompanyDTO;
import com.shangpin.entity.dto.ReportDTO;
import com.shangpin.entity.vo.ApplyCompanyVO;
import com.shangpin.entity.vo.ApplyVO;
import com.shangpin.entity.vo.ReportDetailVO;
import com.shangpin.entity.vo.ReportVO;
import org.apache.ibatis.annotations.Param;

/**
 * company dao
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public interface CompanyMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Company r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    Company findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Company r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Company r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<Company> list(Company r);

    /**
     * 列表查询
     * @param list
     * @return
     */
    List<Company> listBySucc(@Param("list") List<String> list);

    /**
     * 检测申请列表
     * @param companyDTO
     * @return
     */
    List<ApplyCompanyVO> checkList(CheckCompanyDTO companyDTO);


    /**
     * 检测申请列表
     * @param reportDTO
     * @return
     */
    List<ApplyVO> applyList(ReportDTO reportDTO);

    /**
     * 检测申请列表
     * @param reportDTO
     * @return
     */
    List<ReportVO> reportList(ReportDTO reportDTO);

    /**
     * 报告详情
     * @param reportId
     * @return
     */
    List<ReportDetailVO> reportDetailList(@Param("reportId") Integer reportId);
}