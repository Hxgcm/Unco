package com.unco.client.dao;

import com.unco.client.pojo.Category;
import com.unco.client.pojo.Works;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-11 15:38
 */
public interface WorksDao {
    /**
     * 获取作品表中检索的数目
     * @return 所有数目
     */
    public int getCount();

    /**
     * 分页查询作品表
     * @param startIndex 开始索引
     * @param pageSize   页面大小
     * @return
     */
    public List<Works> getImgList(Integer startIndex, Integer pageSize);

    /**
     * 分栏查询
     * @return
     */
    public List<Category> getCategoryList();

    /**
     * 查询人像所有作品
     * @return
     */
    public List<Works> getProImgtList();

    /**
     * 保存作品信息
     * @param works
     * @return
     */
    public int save(Works works);

    /**
     * 更新作品信息
     * @param works
     * @return
     */
    public int update(Works works);

    /**
     * 删除作品信息
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 根据作者查找作品列表
     * @param author
     * @return
     */
    public List<Works> queryWorksByAuthor(String author);

    /**
     * 根据作品ID获取作品
     * @param id
     * @return
     */
    Works queryWorksById(Integer id);

    /**
     * 根据category查询数据库
     * @param categroy
     * @return
     */
    List<Works> queryWorksByCategroy(String categroy);

}
