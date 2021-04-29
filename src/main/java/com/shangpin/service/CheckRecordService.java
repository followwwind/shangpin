package com.shangpin.service;

import com.shangpin.entity.CheckRecord;

import java.util.List;

/**
 * 查验记录表(CheckRecord)表服务接口
 */
public interface CheckRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CheckRecord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CheckRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param checkRecord 实例对象
     * @return 实例对象
     */
    CheckRecord insert(CheckRecord checkRecord);

    /**
     * 修改数据
     *
     * @param checkRecord 实例对象
     * @return 实例对象
     */
    CheckRecord update(CheckRecord checkRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
