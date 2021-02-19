package com.unco.client.dao.daoImpl;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.unco.client.dao.WorksDao;
import com.unco.client.pojo.Category;
import com.unco.client.pojo.Works;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-11 15:48
 */
public class WorksDaoImpl extends BaseDao implements WorksDao {

    @Override
    public int getCount() {
        String sql = "select count(*) from works";
        Number count = (Number) queryForSingleCValue(sql);
        return count.intValue();
    }

    @Override
    public List<Works> getImgList(Integer startIndex, Integer pageSize) {
        String sql = "select `id`, `title`, `category`, `imgurl`, `author`, `describe`, `upload_time` from works limit ?,?";
        return queryForList(Works.class, sql, startIndex, pageSize);
    }

    @Override
    public List<Category> getCategoryList() {
        String sql = "select `id`, `name` from category";
        return queryForList(Category.class, sql);
    }

    @Override
    public List<Works> getProImgtList() {
        String sql = "select `id`, `title`, `category`, `imgurl`, `author`, `describe`, `upload_time` from works ";
        return queryForList(Works.class, sql);
    }

    @Override
    public int save(Works works) {
        String sql = "insert into works(`id`, `title`, `category`, `imgurl`, `author`, `describe`, `upload_time`) values (?,?,?,?,?,?,?)";
        return update(sql,null, works.getTitle(), works.getCategory(), works.getImgurl(), works.getAuthor(), works.getDescribe(), works.getUpload_time());
    }

    @Override
    public int update(Works works) {
        String sql = "update works set `title`=?, `category`=?, `imgurl`=?, `author`=?, `describe`=?, `upload_time`=? where id=?";
        return update(sql,works.getTitle(), works.getCategory(), works.getImgurl(), works.getAuthor(), works.getDescribe(), works.getUpload_time(), works.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from works where id=?";
        return update(sql, id);
    }

    @Override
    public List<Works> queryWorksByAuthor(String author) {
        String sql = "select `id`, `title`, `category`, `imgurl`, `author`, `describe`, `upload_time` from works where author=?";
        return queryForList(Works.class, sql, author);
    }

    @Override
    public Works queryWorksById(Integer id) {
        String sql = "select `id`, `title`, `category`, `imgurl`, `author`, `describe`, `upload_time` from works where id=?";
        return queryForOne(Works.class, sql, id);
    }

    @Override
    public List<Works> queryWorksByCategroy(String categroy) {
        String sql = "select `id`, `title`, `category`, `imgurl`, `author`, `describe`, `upload_time` from works where category=?";
        return queryForList(Works.class, sql, categroy);
    }
}
