package com.shangpin.service;

import com.shangpin.common.Result;
import com.shangpin.entity.PlatformUser;

public interface UserService {
    /**
     * 登录接口
     *
     * @param email
     * @param password
     * @return
     */
    Result login(String email, String password);

    /**
     * 用户注册接口
     *
     * @param platformUser
     * @return
     */
    Result register(PlatformUser platformUser);

    /**
     * 获取用户接口
     *
     * @return
     */
    Result info();

    /**
     * 用户修改接口
     *
     * @return
     */
    Result editUser(PlatformUser platformUser);
}
