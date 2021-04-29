package com.shangpin.controller;

import com.shangpin.common.Result;
import com.shangpin.entity.PlatformUser;
import com.shangpin.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     *
     * @param email    用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestParam(value = "email") String email,
                        @RequestParam(value = "password") String password) {
        return userService.login(email, password);
    }

    /**
     * 用户注册接口
     *
     * @param platformUser
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody PlatformUser platformUser) {
        return userService.register(platformUser);
    }

    /**
     * 用户获取接口
     *
     * @return
     */
    @GetMapping("/info")
    public Result info() {
        return userService.info();
    }

    /**
     * 用户修改接口
     *
     * @return
     */
    @PostMapping("/edit")
    public Result editUser(@RequestBody PlatformUser platformUser) {
        return userService.editUser(platformUser);
    }
}
