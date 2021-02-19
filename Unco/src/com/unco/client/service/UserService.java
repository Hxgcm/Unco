package com.unco.client.service;

import com.unco.client.pojo.PageVo;
import com.unco.client.pojo.User;
import com.unco.client.pojo.Works;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-10 16:45
 */
public interface UserService {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    public User login(String username, String password);

    /**
     * 检查 用户名是否可用
     * @param username 要查询的用户信息
     * @return  返回true 则说明用户名已经存在，返回false则说明用户名可用
     */
    public boolean exitUserName(String username);
    /**
     * 添加用户
     * @param user 用户信息
     * @return 布尔值
     */
    public boolean addUser(User user);

    /**
     * 根据用户姓名，获得用户列表；
     * @param name 姓名
     * @return 用户列表
     */
    public List<User> getAutUserList(String name);

    /**
     * 获取用户列表
     * @param pageNo 页码
     * @return 用户列表
     */
    public PageVo<User> getUserList(int pageNo);

    /**
     * 根据ID删除用户
     * @param id 要删除的ID
     * @return 布尔
     */
    public boolean deleteUserByID(int id);

    /**
     * 获取用户信息，根据姓名
     * @param author
     * @return
     */
    User getUserByName(String author);
}
