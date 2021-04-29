package com.shangpin.mapper;

import com.shangpin.entity.PlatformUser;

import java.util.List;

/**
 * 平台用户Mapper接口
 *
 * @author 墨洛
 * @date 2020-11-26
 */
public interface PlatformUserMapper {
    /**
     * 查询平台用户
     *
     * @param id 平台用户ID
     * @return 平台用户
     */
    public PlatformUser selectPlatformUserById(Long id);

    /**
     * 查询平台用户列表
     *
     * @param platformUser 平台用户
     * @return 平台用户集合
     */
    public List<PlatformUser> selectPlatformUserList(PlatformUser platformUser);

    /**
     * 新增平台用户
     *
     * @param platformUser 平台用户
     * @return 结果
     */
    public int insertPlatformUser(PlatformUser platformUser);

    /**
     * 修改平台用户
     *
     * @param platformUser 平台用户
     * @return 结果
     */
    public int updatePlatformUser(PlatformUser platformUser);

    /**
     * 删除平台用户
     *
     * @param id 平台用户ID
     * @return 结果
     */
    public int deletePlatformUserById(Long id);

    /**
     * 批量删除平台用户
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlatformUserByIds(Long[] ids);

    /**
     * 通过用户email查用户
     * @param userEmail
     * @return
     */
    PlatformUser selectPlatformUserByEmail(String userEmail);
}
