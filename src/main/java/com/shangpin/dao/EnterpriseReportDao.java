package com.shangpin.dao;

import com.shangpin.entity.EnterpriseReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业和个人规则信息项(EnterpriseReport)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-03 19:30:58
 */
public interface EnterpriseReportDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EnterpriseReport queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EnterpriseReport> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param enterpriseReport 实例对象
     * @return 对象列表
     */
    List<EnterpriseReport> queryAll(EnterpriseReport enterpriseReport);

    /**
     * 新增数据
     *
     * @param enterpriseReport 实例对象
     * @return 影响行数
     */
    int insert(EnterpriseReport enterpriseReport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EnterpriseReport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EnterpriseReport> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EnterpriseReport> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EnterpriseReport> entities);

    /**
     * 修改数据
     *
     * @param enterpriseReport 实例对象
     * @return 影响行数
     */
    int update(EnterpriseReport enterpriseReport);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过查验记录id找查验规则
     * @param id 查验记录id
     * @return
     */
    EnterpriseReport queryByCheckId(Integer id);

    /**
     * 通过用户账号查规则列表
     * @param email 用户账号
     * @return
     */
    List<EnterpriseReport> queryByUserEmail(String email);
}

