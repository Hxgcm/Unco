package com.unco.client.test;

import com.unco.client.service.CategoryService;
import com.unco.client.service.serviceImpl.CategoryServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author HeXianGang
 * @create 2020-06-11 19:27
 */
public class CategoryServiceTest {
    CategoryService categoryService = new CategoryServiceImpl();
    @Test
    public void getCategoryList() {
        System.out.println(categoryService.getCategoryList(1));
    }

    @Test
    public void getCategory() {
        System.out.println(categoryService.getCategory());
    }
}