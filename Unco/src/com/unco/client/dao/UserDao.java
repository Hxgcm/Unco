package com.unco.client.dao;

import com.unco.client.pojo.PageVo;
import com.unco.client.pojo.User;
import com.unco.client.pojo.Works;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-10 15:54
 */
public interface UserDao {
    /**
     *  根据用户名查询用户信息
     * @param username 用户名
     * @return 返回信息则正确，反之错误
     */
    public User queryUsername(String username);

    /**
     *  根据用户名和密码查询用户信息
     * @param username  用户名
     * @param password  密码
     * @return  返回信息则正确，反之错误
     */
    public User queryUsernameAndPassword(String username, String password);

    /**
     * 根据姓名查找用户
     * @param name
     * @return
     */
    public User queryUserByName(String name);

    /**
     *  保存用户信息
     * @param user 用户信息
     * @return  返回值不为0为成功，反之亦然
     */
    public int addUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 获取User表中检索的条目
     * @return
     */
    public int getCount();

    /**
     * 分页查询User表
     * @param startIndex 起始页码
     * @param pageSize 页码大小
     * @return 用户列表
     */
    public PageVo<User> getUserList(int startIndex, int pageSize);


    public int deleteUserById(Integer id);
}
