package com.unco.client.test;

import com.unco.client.dao.WorksDao;
import com.unco.client.dao.daoImpl.WorksDaoImpl;
import com.unco.client.pojo.Works;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author HeXianGang
 * @create 2020-06-11 16:24
 */
public class WorksDaoTest {
    WorksDao worksDao = new WorksDaoImpl();
    @Test
    public void getCount() {
        System.out.println( "总数为 ：" + worksDao.getCount());
    }

    @Test
    public void getImgList() {
        System.out.println("获得图片列表：" + worksDao.getImgList(1, 5));
    }

    @Test
    public void getCategoryList() {
        System.out.println(worksDao.getCategoryList());
    }

    @Test
    public void getProImgtList() {
        System.out.println("获得图片列表：" + worksDao.getProImgtList());
    }

    @Test
    public void save() {
        Works works = new Works(0, "李四", "人像", "upload\\20180712\\02e270a7-5ab2-40bc-ac95-7d9a2d3af8cb.jpg", "陈美", "人像图片", new Date());
        int save = worksDao.save(works);
        System.out.println(save);
    }

    @Test
    public void update() {
        Works works = new Works(25, "zhangsan", "人像", "upload\\20180712\\02e270a7-5ab2-40bc-ac95-7d9a2d3af8cb.jpg", "何贤刚", "人像图片", new Date());
        System.out.println(worksDao.update(works));

    }

    @Test
    public void delete() {
        System.out.println(worksDao.delete(2));
    }
}