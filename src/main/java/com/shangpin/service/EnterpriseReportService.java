package com.shangpin.service;

import com.shangpin.entity.EnterpriseReport;

import java.util.List;

/**
 * 企业和个人规则信息项(EnterpriseReport)表服务接口
 */
public interface EnterpriseReportService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EnterpriseReport queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EnterpriseReport> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param enterpriseReport 实例对象
     * @return 实例对象
     */
    EnterpriseReport insert(EnterpriseReport enterpriseReport);

    /**
     * 修改数据
     *
     * @param enterpriseReport 实例对象
     * @return 实例对象
     */
    EnterpriseReport update(EnterpriseReport enterpriseReport);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
