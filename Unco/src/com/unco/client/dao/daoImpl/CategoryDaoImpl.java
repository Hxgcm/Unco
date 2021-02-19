package com.unco.client.dao.daoImpl;

import com.unco.client.dao.CategoryDao;
import com.unco.client.pojo.Category;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-11 19:08
 */
public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    @Override
    public int getCount() {
        String sql = "select count(*) from category";
        Number number = (Number) queryForSingleCValue(sql);
        return number.intValue();
    }

    @Override
    public List<Category> getCateList() {
        String sql = "select `id`, `name` from category";
        return queryForList(Category.class, sql);
    }

    @Override
    public List<Category> getUserList(int startIndex, int pageSize) {
        String sql = "select `id`, `name` from category limit ?, ?";
        return queryForList(Category.class, sql, startIndex, pageSize);
    }
}
