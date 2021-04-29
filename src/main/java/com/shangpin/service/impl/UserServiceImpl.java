package com.shangpin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shangpin.common.Result;
import com.shangpin.common.ServletUtils;
import com.shangpin.entity.PlatformUser;
import com.shangpin.mapper.PlatformUserMapper;
import com.shangpin.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户service
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PlatformUserMapper userMapper;

    @Override
    public Result login(String email, String password) {
        PlatformUser platformUser = new PlatformUser();
        platformUser.setEmail(email);
        platformUser.setPassword(password);
        List<PlatformUser> platformUsers = userMapper.selectPlatformUserList(platformUser);
        Integer i = 3;
        if (platformUsers != null && platformUsers.size() > 0) {
            i = platformUsers.get(0).getLockedstate();
        }
        if (!ObjectUtils.isEmpty(platformUsers) && platformUsers.size() > 0 && i == 1) {
            HttpServletResponse response = ServletUtils.getResponse();
            Cookie user = new Cookie("user", platformUser.getEmail());
            response.addCookie(user);
            return Result.success(JSONObject.toJSONString(platformUsers.get(0)));
        } else if (i == 0) {
            return Result.error("待审核");
        } else if (i == 2) {
            return Result.error("被拒绝");
        }

        return Result.error("账号或密码错误");
    }

    @Override
    public Result register(PlatformUser platformUser) {
        PlatformUser p = new PlatformUser();
        p.setEmail(platformUser.getEmail());
        List<PlatformUser> platformUsers = userMapper.selectPlatformUserList(p);
        if (!ObjectUtils.isEmpty(platformUsers) && platformUsers.size() > 0) {
            return Result.error("邮箱已存在");
        }
        userMapper.insertPlatformUser(platformUser);
        return Result.success("提交成功,待管理员审核后即可登录");
    }

    @Override
    public Result info() {
        PlatformUser p = new PlatformUser();
        p.setLockedstate(0);
        return Result.success(userMapper.selectPlatformUserList(p));
    }

    @Override
    public Result editUser(PlatformUser platformUser) {
        return Result.success(userMapper.updatePlatformUser(platformUser));
    }
}
