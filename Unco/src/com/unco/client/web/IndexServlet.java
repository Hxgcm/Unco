package com.unco.client.web;

import com.unco.client.pojo.Category;
import com.unco.client.pojo.Works;
import com.unco.client.service.CategoryService;
import com.unco.client.service.WorksService;
import com.unco.client.service.serviceImpl.CategoryServiceImpl;
import com.unco.client.service.serviceImpl.WorksServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 */
public class IndexServlet extends BaseServlet {
    private WorksService worksService = new WorksServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    protected void indexPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Works> proImgList = worksService.getProImgList();
        List<Category> categoryList = categoryService.getCategory();
        System.out.println("是否查询到ProImgList：" + proImgList);
        // 将其放入Session中
        request.getSession().setAttribute("proImgList", proImgList);
        request.getSession().setAttribute("categoryList", categoryList);
        // 页面跳转
        System.out.println("页面已经跳转到Servlet程序，即将发送至index主页");
        request.getRequestDispatcher("/client/index.jsp").forward(request, response);
    }
}
