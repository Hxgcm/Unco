package com.unco.client.service.serviceImpl;

import com.unco.client.dao.WorksDao;
import com.unco.client.dao.daoImpl.WorksDaoImpl;
import com.unco.client.pojo.Category;
import com.unco.client.pojo.PageVo;
import com.unco.client.pojo.Works;
import com.unco.client.service.WorksService;

import java.util.List;

/**
 * @author HeXianGang
 * @create 2020-06-11 15:37
 */
public class WorksServiceImpl implements WorksService {

    private WorksDao worksDao = new WorksDaoImpl();

    @Override
    public List<Works> getWorksByCategroy(String categroy) {
        return worksDao.queryWorksByCategroy(categroy);
    }

    @Override
    public Works getWorks(Integer id) {
        return worksDao.queryWorksById(id);
    }

    @Override
    public PageVo<Works> getImgList(int pageNo) {
        //1.初始化pageVo
        PageVo<Works> pageVo = new PageVo<Works>();
        pageVo.setPageNo(pageNo);
        //2.查询总记录数
        int count = worksDao.getCount();
        pageVo.setTotalRecords(count);
        //3.查询当前页有哪些分类数据
        List<Works> userList = worksDao.getImgList(pageVo.getStartIndex(), pageVo.getPageSize());
        pageVo.setRecords(userList);
        return pageVo;
    }

    @Override
    public List<Category> getCategoryList() {
        return worksDao.getCategoryList();
    }

    @Override
    public List<Works> getProImgList() {
        return worksDao.getProImgtList();
    }

    @Override
    public boolean add(Works works) {
        int save = worksDao.save(works);
        return save != 1;
    }

    @Override
    public boolean delete(int id) {
        int delete = worksDao.delete(id);
        return delete != -1;
    }

    @Override
    public List<Works> getAutList(String author) {
        return worksDao.queryWorksByAuthor(author);
    }

    @Override
    public List<Works> getAllWorksByAuthor(String author) {
        return worksDao.queryWorksByAuthor(author);
    }
}
