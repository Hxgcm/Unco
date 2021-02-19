package com.unco.client.dao;

import com.unco.client.pojo.Category;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-11 19:03
 */
public interface CategoryDao {
    /**
     * 获取分栏表中检索数目
     * @return
     */
    public int getCount();

    /**
     * 查询分栏表
     * @return
     */
    public List<Category> getCateList();

    /**
     * 分页查询用户列表
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<Category> getUserList(int startIndex, int pageSize);
}
