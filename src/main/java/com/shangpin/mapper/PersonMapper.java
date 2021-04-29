package com.shangpin.mapper;

import java.util.List;

import com.shangpin.entity.Person;
import com.shangpin.entity.dto.CheckCompanyDTO;
import com.shangpin.entity.dto.CheckPersonDTO;
import com.shangpin.entity.dto.ReportDTO;
import com.shangpin.entity.vo.ApplyCompanyVO;
import com.shangpin.entity.vo.ApplyPersonVO;
import com.shangpin.entity.vo.ApplyVO;
import com.shangpin.entity.vo.ReportVO;
import org.apache.ibatis.annotations.Param;

/**
 * person dao
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public interface PersonMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Person r);

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
    Person findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Person r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Person r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<Person> list(Person r);

    /**
     * 检测申请列表
     * @param companyDTO
     * @return
     */
    List<ApplyPersonVO> checkList(CheckPersonDTO companyDTO);


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

}