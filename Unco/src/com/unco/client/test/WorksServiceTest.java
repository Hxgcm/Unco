package com.unco.client.test;

import com.unco.client.pojo.Works;
import com.unco.client.service.WorksService;
import com.unco.client.service.serviceImpl.WorksServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author HeXianGang
 * @create 2020-06-11 17:33
 */
public class WorksServiceTest {
    WorksService worksService = new WorksServiceImpl();
    @Test
    public void getImgList() {
        System.out.println(worksService.getImgList(10));
    }

    @Test
    public void getCategoryList() {
        System.out.println(worksService.getCategoryList());
    }

    @Test
    public void getProImgList() {
        System.out.println(worksService.getProImgList());
    }

    @Test
    public void add() {
        Works works = new Works(0,"text", "人像",null,null,null,null);
        worksService.add(works);
    }

    @Test
    public void delete() {
        worksService.delete(30);
    }
}