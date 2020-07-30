package com.tengke.supermarket.config;

import com.tengke.supermarket.mapper.AdminMapper;
import com.tengke.supermarket.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Mr.Chen
 * @Description: 验证登录拦截器
 * @Date:Created in 12:25 2020/7/30
 */
@Service
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminMapper adminMapper;

    private static final long DAY = 86400000;

    /**
     * 请求处理之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过请求对象获取token
        String token = request.getHeader("Authorization");
        //token不为空
        if (token != null && !"".equals(token)) {
            System.out.println("token为：" + token);
            //匹配数据库，查找出符合的对应的User
            Admin dbAdmin = adminMapper.selectAdminByToken(token);
            //用户不存在
            if (null == dbAdmin) {
                System.out.println("用户不存在");
                return false;
            }
            System.out.println("用户为：" + dbAdmin);
            //计算token是否已经超时, 有效时期为1天
            if ((System.currentTimeMillis() - dbAdmin.getCreateTime()) > DAY) {
                //重新登录
                request.setAttribute("Authorization", null);
                System.out.println("token失效，请重新登录");
                return false;
            }
        }
        return true;
    }

    /**
     * Controller之后调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求结束调用
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("一次请求结束");
    }
}
