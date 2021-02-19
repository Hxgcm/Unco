package com.unco.client.test;

import com.unco.client.dao.UserDao;
import com.unco.client.dao.daoImpl.UserDaoImpl;
import com.unco.client.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author HeXianGang
 * @create 2020-06-11 22:50
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUsername() {
        String username = "aaa";
        User user = userDao.queryUsername(username);
        System.out.println(user);
    }

    @Test
    public void queryUsernameAndPassword() {
        String username = "aaa";
        String password = "aaa";
        User user = userDao.queryUsernameAndPassword(username, password);
        System.out.println(user);
    }

    @Test
    public void addUser() {
        User user = new User(null, "admin", "admin", null, null, null, null, null);
        userDao.addUser(user);
    }

    @Test
    public void updateUser() {
        User user = new User(12, "admin", "admin", "何贤刚", "男", null, null, null);
        userDao.updateUser(user);
    }

    @Test
    public void getCount() {
        System.out.println(userDao.getCount());
    }

    @Test
    public void getUserList() {
        System.out.println(userDao.getUserList(1,2));
    }

    @Test
    public void deleteUserById() {
        System.out.println(userDao.deleteUserById(1));
    }
}