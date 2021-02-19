package com.unco.client.service.serviceImpl;

import com.unco.client.dao.UserDao;
import com.unco.client.dao.daoImpl.UserDaoImpl;
import com.unco.client.pojo.PageVo;
import com.unco.client.pojo.User;
import com.unco.client.pojo.Works;
import com.unco.client.service.UserService;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-10 16:45
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.queryUsernameAndPassword(username, password);

    }

    @Override
    public boolean exitUserName(String username) {
        return userDao.queryUsername(username) != null;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user) != -1;
    }


    @Override
    public List<User> getAutUserList(String name) {
        return null;
    }

    @Override
    public PageVo<User> getUserList(int pageNo) {
        return userDao.getUserList(pageNo, 7);
    }

    @Override
    public User getUserByName(String author) {
        return userDao.queryUserByName(author);
    }

    @Override
    public boolean deleteUserByID(int id) {
    return false;
    }
}
