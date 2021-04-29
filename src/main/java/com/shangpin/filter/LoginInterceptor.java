package com.shangpin.filter;

import com.alibaba.fastjson.JSONObject;
import com.shangpin.common.Result;
import com.shangpin.entity.PlatformUser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String user = httpServletRequest.getHeader("user");
        if (!StringUtils.isEmpty(user) && !user.equals("underfind") && !user.equals("null")) {
            return true;
        }
        Result result = new Result<>();
        result.setCode(401);//未登录,前端去跳转
        httpServletResponse.getWriter().write(JSONObject.toJSONString(result));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
