package com.unco.client.dao.daoImpl;


import com.unco.client.dao.UserDao;
import com.unco.client.pojo.PageVo;
import com.unco.client.pojo.User;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-10 15:56
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByName(String name) {
        String sql ="select `id`,`username`,`password`, `name`, `sex`, `works`, `identity`, `head_images` from user where name = ?";
        return queryForOne(User.class, sql, name);
    }

    @Override
    public User queryUsername(String username) {
        String sql ="select `id`,`username`,`password`, `name`, `sex`, `works`, `identity`, `head_images` from user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`, `name`, `sex`, `works`, `identity`, `head_images` from user where username = ? and password =?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user(`username`,`password`, `name`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getName());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set `name`=?, `sex`=?, `works`=?, `head_images`=? where id=?";
        return update(sql, user.getName(), user.getSex(), user.getWorks(), user.getHead_images(), user.getId());
    }

    @Override
    public int getCount() {
        String sql = "select count(*) from user";
        Number number = (Number) queryForSingleCValue(sql);
        return number.intValue();
    }

    @Override
    public PageVo<User> getUserList(int startIndex, int pageSize) {
//        String sql = "select `id`,`username`,`password`, `name`, `sex`, `works`, `identity`, `head_images` from user limit ?,?";
////        return queryForList(PageVo<User>.class, sql, startIndex, pageSize);
        return null;
    }

    @Override
    public int deleteUserById(Integer id) {
        String sql = "delete from user where id = ?";
        return update(sql, id);
    }
}
