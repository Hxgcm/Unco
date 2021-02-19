package com.unco.client.web;

import com.unco.client.pojo.User;
import com.unco.client.service.UserService;
import com.unco.client.service.serviceImpl.UserServiceImpl;
import com.unco.client.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HeXianGang
 * @create 2020-06-11 20:54
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得用户请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 查询用户
        User login = userService.login(username, password);
        // 将用户信息保存到Session域中
        req.getSession().setAttribute("user", login);
        // 页面跳转
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");
        //获取Session的验证码
        String codeSession = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        // 获取用户信息
        User registUser = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        //2、判断验证码是否正确
        if (codeSession.equalsIgnoreCase(code)) {
            //正确
            //3、判断用户名是否重复
            if (userService.exitUserName(registUser.getUsername())) {

                //用户名已经存在，往request域中存入错误信息以及用户信息，以回显
                req.setAttribute("msg", "用户名已经存在了！！");
                req.setAttribute("username", registUser.getUsername());
                req.setAttribute("name", registUser.getName());
                //继续跳转至该页面重新输入
                req.getRequestDispatcher("/indexServlet?action=indexPage").forward(req, resp);
            } else {
                //用户名不存在，可以注册，提交给持久层进行注册操作
                userService.addUser(registUser);
                User login = userService.login(registUser.getUsername(), registUser.getPassword());
                req.getSession().setAttribute("user", login);
                req.getRequestDispatcher("/indexServlet?action=indexPage").forward(req, resp);
            }
        } else {
            //验证码错误，往request域中存入错误信息以及用户信息，以回显
            req.setAttribute("msg", "验证码输入有误！！");
            req.setAttribute("username", registUser.getUsername());
            req.setAttribute("name", registUser.getName());
            req.getRequestDispatcher("/indexServlet?action=indexPage").forward(req, resp);
        }
    }

    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、销毁Session中的（用户Session的信息）。
        req.getSession().invalidate();
        // 2、重定向到首页（或登录页面）
        resp.sendRedirect(req.getContextPath());
    }

}
