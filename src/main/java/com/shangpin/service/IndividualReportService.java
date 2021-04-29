package com.shangpin.service;

import com.shangpin.entity.IndividualReport;

import java.util.List;

/**
 * (IndividualReport)表服务接口
 */
public interface IndividualReportService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IndividualReport queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<IndividualReport> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param individualReport 实例对象
     * @return 实例对象
     */
    IndividualReport insert(IndividualReport individualReport);

    /**
     * 修改数据
     *
     * @param individualReport 实例对象
     * @return 实例对象
     */
    IndividualReport update(IndividualReport individualReport);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
