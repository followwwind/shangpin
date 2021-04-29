package com.shangpin.mapper;

import java.util.List;

import com.shangpin.entity.Config;
import com.shangpin.entity.ConfigCheckItem;
import com.shangpin.entity.ConfigGroupItem;
import com.shangpin.entity.dto.ConfigDTO;
import com.shangpin.entity.vo.ConfigCheckItemVO;
import com.shangpin.entity.vo.ConfigGroupItemVO;
import com.shangpin.entity.vo.ConfigVO;
import org.apache.ibatis.annotations.Param;

/**
 * config dao
 * @author wind
 * @date 2021/04/30 07:27:46
 * @version V1.0
 */
public interface ConfigMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Config r);

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
    Config findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Config r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Config r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<Config> list(Config r);

    /**
     * 列表查询
     * @param configDTO
     * @return
     */
    List<ConfigVO> listConfigByTime(ConfigDTO configDTO);

    /**
     * 检测列表
     * @param configId
     * @return
     */
    List<ConfigCheckItemVO> listCheckItem(@Param("configId") Integer configId);

    /**
     * 分组列表
     * @param configId
     * @return
     */
    List<ConfigGroupItemVO> listGroupItem(@Param("configId") Integer configId);
}