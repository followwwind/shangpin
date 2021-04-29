package com.shangpin.service.impl;

import com.shangpin.entity.IndividualReport;
import com.shangpin.dao.IndividualReportDao;
import com.shangpin.service.IndividualReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (IndividualReport)表服务实现类
 *
 * @author makejava
 * @since 2021-04-03 19:30:48
 */
@Service("individualReportService")
public class IndividualReportServiceImpl implements IndividualReportService {
    @Resource
    private IndividualReportDao individualReportDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public IndividualReport queryById(Integer id) {
        return this.individualReportDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<IndividualReport> queryAllByLimit(int offset, int limit) {
        return this.individualReportDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param individualReport 实例对象
     * @return 实例对象
     */
    @Override
    public IndividualReport insert(IndividualReport individualReport) {
        this.individualReportDao.insert(individualReport);
        return individualReport;
    }

    /**
     * 修改数据
     *
     * @param individualReport 实例对象
     * @return 实例对象
     */
    @Override
    public IndividualReport update(IndividualReport individualReport) {
        this.individualReportDao.update(individualReport);
        return this.queryById(individualReport.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.individualReportDao.deleteById(id) > 0;
    }
}
