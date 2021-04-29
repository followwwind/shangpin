package com.shangpin.service.impl;

import com.shangpin.entity.EnterpriseReport;
import com.shangpin.dao.EnterpriseReportDao;
import com.shangpin.service.EnterpriseReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 企业和个人规则信息项(EnterpriseReport)表服务实现类
 *
 * @author makejava
 * @since 2021-04-03 19:30:58
 */
@Service("enterpriseReportService")
public class EnterpriseReportServiceImpl implements EnterpriseReportService {
    @Resource
    private EnterpriseReportDao enterpriseReportDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EnterpriseReport queryById(Integer id) {
        return this.enterpriseReportDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<EnterpriseReport> queryAllByLimit(int offset, int limit) {
        return this.enterpriseReportDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param enterpriseReport 实例对象
     * @return 实例对象
     */
    @Override
    public EnterpriseReport insert(EnterpriseReport enterpriseReport) {
        this.enterpriseReportDao.insert(enterpriseReport);
        return enterpriseReport;
    }

    /**
     * 修改数据
     *
     * @param enterpriseReport 实例对象
     * @return 实例对象
     */
    @Override
    public EnterpriseReport update(EnterpriseReport enterpriseReport) {
        this.enterpriseReportDao.update(enterpriseReport);
        return this.queryById(enterpriseReport.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.enterpriseReportDao.deleteById(id) > 0;
    }
}
