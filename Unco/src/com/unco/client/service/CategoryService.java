package com.unco.client.service;

import com.unco.client.pojo.Category;
import com.unco.client.pojo.PageVo;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-11 19:19
 */
public interface CategoryService {
    /**
     * 分页查询功能
     * @param pageNo
     * @return
     */
    public PageVo<Category> getCategoryList(int pageNo);

    /**
     * 获得分类列表
    * @return
     */
    public List<Category> getCategory();
}
