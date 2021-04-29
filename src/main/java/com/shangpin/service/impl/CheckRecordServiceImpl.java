package com.shangpin.service.impl;

import com.shangpin.entity.CheckRecord;
import com.shangpin.dao.CheckRecordDao;
import com.shangpin.service.CheckRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查验记录表(CheckRecord)表服务实现类
 *
 * @author makejava
 * @since 2021-04-03 21:15:51
 */
@Service("checkRecordService")
public class CheckRecordServiceImpl implements CheckRecordService {
    @Resource
    private CheckRecordDao checkRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CheckRecord queryById(Integer id) {
        return this.checkRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CheckRecord> queryAllByLimit(int offset, int limit) {
        return this.checkRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param checkRecord 实例对象
     * @return 实例对象
     */
    @Override
    public CheckRecord insert(CheckRecord checkRecord) {
        this.checkRecordDao.insert(checkRecord);
        return checkRecord;
    }

    /**
     * 修改数据
     *
     * @param checkRecord 实例对象
     * @return 实例对象
     */
    @Override
    public CheckRecord update(CheckRecord checkRecord) {
        this.checkRecordDao.update(checkRecord);
        return this.queryById(checkRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.checkRecordDao.deleteById(id) > 0;
    }
}
