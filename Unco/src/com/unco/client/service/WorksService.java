package com.unco.client.service;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.unco.client.pojo.Category;
import com.unco.client.pojo.PageVo;
import com.unco.client.pojo.User;
import com.unco.client.pojo.Works;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-11 17:27
 */
public interface WorksService {
    /**
     * 分页查询
     * @param pageNo
     * @return
     */
    public PageVo<Works> getImgList(int pageNo);

    /**
     * 调用imgDao中的getCategoryList()方法查询所有分栏信息
     * @return
     */
    public List<Category> getCategoryList();

    /**
     * 调用imgDao中的getAllImgList()方法查询所有作品
     * @return
     */
    public List<Works> getProImgList();

    /**
     * 添加作品，(判断如果已经存在，更新，如果不存在，保存)
     * @param works
     * @return
     */
    public boolean add(Works works);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean delete(int id);

    /**
     * 根据作者获得作品列表
     * @param author
     * @return
     */
    public List<Works> getAutList(String author);

    /**
     * 根据作品ID获取作品
     * @param id
     * @return
     */
    Works getWorks(Integer id);

    /**
     * 根据作品分类获得请求数据
     * @param categroy
     * @return
     */
    List<Works> getWorksByCategroy(String categroy);

    /**
     * 根据作者姓名，获取该作者的所有作品
     * @param author
     * @return
     */
    List<Works> getAllWorksByAuthor(String author);
}
