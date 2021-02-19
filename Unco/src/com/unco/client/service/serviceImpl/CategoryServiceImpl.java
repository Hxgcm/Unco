package com.unco.client.service.serviceImpl;

import com.unco.client.dao.CategoryDao;
import com.unco.client.dao.daoImpl.CategoryDaoImpl;
import com.unco.client.pojo.Category;
import com.unco.client.pojo.PageVo;
import com.unco.client.service.CategoryService;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-11 19:21
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public PageVo<Category> getCategoryList(int pageNo) {
        //1.初始化pageVo
        PageVo<Category> pageVo = new PageVo<Category>();
        pageVo.setPageNo(pageNo);
        //2.查询总记录数
        int count = categoryDao.getCount();
        pageVo.setTotalRecords(count);
        //3.查询当前页有哪些分类数据
        List<Category> userList = categoryDao.getUserList(pageVo.getStartIndex(), pageVo.getPageSize());
        pageVo.setRecords(userList);
        return pageVo;
    }

    @Override
    public List<Category> getCategory() {
        return categoryDao.getCateList();
    }
}
