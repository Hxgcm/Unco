package com.unco.client.test;

import com.unco.client.dao.CategoryDao;
import com.unco.client.dao.daoImpl.CategoryDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author HeXianGang
 * @create 2020-06-11 19:15
 */
public class CategoryDaoTest {
    CategoryDao categoryDao = new CategoryDaoImpl();
    @Test
    public void getCount() {
        System.out.println(categoryDao.getCount());
    }

    @Test
    public void getCateList() {
        System.out.println(categoryDao.getCateList());
    }

    @Test
    public void getUserList() {
        System.out.println(categoryDao.getUserList(1, 4));
    }
}