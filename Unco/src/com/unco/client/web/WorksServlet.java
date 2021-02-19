package com.unco.client.web;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.unco.client.pojo.PageVo;
import com.unco.client.pojo.User;
import com.unco.client.pojo.Works;
import com.unco.client.service.UserService;
import com.unco.client.service.WorksService;
import com.unco.client.service.serviceImpl.UserServiceImpl;
import com.unco.client.service.serviceImpl.WorksServiceImpl;
import com.unco.client.util.WebUtils;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import sun.awt.image.OffScreenImage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author HeXianGang
 * @create 2020-06-13 16:03
 */
public class WorksServlet extends BaseServlet{
    private static final long serialVersionUID = 1L;

    private WorksService worksService =  new WorksServiceImpl();
    private UserService userService = new UserServiceImpl();

    /**
     * 查看该作者的全部作品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void autlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 从页面Session中获得用户信息
        User user = (User) request.getSession().getAttribute("user");

        // 获取图片作品的作者名称
        String author = request.getParameter("author");
        // 获取该姓名的用户列表
        User authorInfo = userService.getUserByName(author);
        request.setAttribute("author", authorInfo);
        // 页面跳转
        request.getRequestDispatcher("/client/pages/personalCenter/userworks.jsp").forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    protected void uploadWork(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("/client/pages/uploadWork/uploadWork.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        // 获取用户请求数据====要删除的id
        int id = WebUtils.paratInt(request.getParameter("id"), 0);

        boolean result = worksService.delete(id);

        if (result) {
            response.sendRedirect("ImgServlet?method=list");
        } else {
            request.setAttribute("message", "删除失败");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }

    }

//    protected void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        List<Img> proImgList = imgService.getProImgList();
//        request.setAttribute("proImgList", proImgList);
//        request.getRequestDispatcher("/add.jsp").forward(request, response);
//
//    }

    /**
     * 文件上传方法
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    protected void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        // 设置请求头
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        // 获取用户id 做每个用户的上传路径
        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user+"==");
        Map<String, String> map = new HashMap<>();
        List<Works> worksList = new ArrayList<>();
        int i = 1;
        // 获取作者上传作品信息
/*        String id = request.getParameter("id");
        System.out.println("是否获取到ID：" + id);
        String title = request.getParameter("title");
        System.out.println("是否获取到title:" + title);*/
//        System.out.println("获取请求时的：" + works);
        // 创建用户上传路径
        String path = this.getServletContext().getRealPath("/upload/") + user.getId() + File.separator +"";
        System.out.println(path+"==");
        File file = new File(path);
        // 判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
            System.out.println(path + "目录不存在，需要创建！！");
        }

        // 1、先判断上传的数据是否多段数据（只有是多段的数据， 才是文件上传的）
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类ServletFileUpload类；
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                // 解析上传的数据，得到每一个表单项
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem:list) {
                    if (fileItem.isFormField()) {
                        // 将获取到的参数放入Map集合中
                        map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
                        System.out.println("获取请求时的Map对象：" + map);
                    } else {
                        Works works = new Works();
                        // 文件表项
                        if (FilenameUtils.getExtension(fileItem.getName()).equals("")) {
                            continue;
                        }
                        i=i+1;
                        String fileName = System.currentTimeMillis() + i + "-" + user.getId() + "." + FilenameUtils.getExtension(fileItem.getName());
                        // 如果上传文件路径为空，则重新上传
                        //去掉获取到文件名中的路径名，保留单纯的文件名
//                        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);

                        // 获取item中的上传文件的输入流
                        InputStream in = fileItem.getInputStream();
                        // 创建一个文件输出流
                        FileOutputStream out = new FileOutputStream(path + fileName);
                        // 创建缓冲区
                        byte[] buffer = new byte[1024];
                        // 判断输入流中的数据是或否已经读取完毕的标志位
                        int len = 0;
                        // 循环将输入流中读入到缓冲区当中， (len = in.read(buffer)> 0)就表示in 里面还有数据存在
                        while ( (len = in.read(buffer)) > 0) {
                            // 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录
                            out.write(buffer, 0, len);
                        }
                        in.close();
                        out.close();
                        // 删除处理文件上传生成的临时文件
                        fileItem.delete();
                        // 将上传路径和上传日期保存到works的imgURL路径中去
                        works.setImgurl("" + path + fileName);
                        works.setUpload_time(new Date());
                        // 将该对象保存到List集合中去
                        worksList.add(works);
                    }
                }
            } catch (Exception ec) {
                System.out.println(ec);
            }
            // 遍历上传的List集合
            for (Works temp : worksList) {
                // 解析信息到单个works对象中
                temp = WebUtils.copyParamToBean(map, temp);
                System.out.println("每个works对象的值是：" + temp);
                // 将信息保存到数据库中
                worksService.add(temp);
            }

        }
//        System.out.println("提交时的Works:" + works);
        // 页面跳转
        System.out.println(user.getName());
        String name = user.getName();
        response.sendRedirect(request.getContextPath() + "/client/worksServlet?action=showPersonalPage&author="+ URLEncoder.encode(name, "UTF-8"));
    }

    /**
     * 显示图片
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    protected void showWorks(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("image/jpeg");
        // 1、获取用户请求
        int id = WebUtils.paratInt(request.getParameter("id"), -1);
//        System.out.println(id);
        Works works = worksService.getWorks(id);
        File filePath = new File(works.getImgurl());
        response.addHeader("Content-Length", "" + filePath.length());
//        System.out.println(filePath);
        OutputStream os = response.getOutputStream();
        InputStream fis = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int len = 0;

        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        fis.close();
        os.close();

    }

    /**
     * 根据类型查询作品表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getCategoryWorksList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 获取请求参数
        String categroy = request.getParameter("categroys");
        // 根据请求参数查询数据库
        List<Works> works = worksService.getWorksByCategroy(categroy);
        // 保存请求参数
        request.getSession().setAttribute("categoryWorks", works);
        // 页面重定向
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 显示个人作品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showPersonalWorks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 获取用户请求
        String author = request.getParameter("author");
        worksService.getAutList(author);
        // 获得该作者的所有作品
        List<Works> allWorksByAuthor = worksService.getAllWorksByAuthor(author);
        System.out.println(allWorksByAuthor);
        request.setAttribute("worksList", allWorksByAuthor);
        // 页面跳转
        request.getRequestDispatcher("/client/pages/showWorks/showWorks.jsp").forward(request, response);
    }

    /**
     * 显示个人主页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showPersonalPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 获取用户请求
        String author = request.getParameter("author");
        worksService.getAutList(author);
        // 获得该作者的所有作品
        List<Works> allWorksByAuthor = worksService.getAllWorksByAuthor(author);
        System.out.println(allWorksByAuthor);
        request.setAttribute("authorName", author);
        request.setAttribute("worksList", allWorksByAuthor);
        // 页面跳转
        request.getRequestDispatcher("/client/pages/personalCenter/authorindex.jsp").forward(request, response);
    }

//    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        // TODO Auto-generated method stub
//    String pageNoStr = request.getParameter("pageNo");
//    int pageNo = 1;
//        if (StringUtils.isNotEmpty(pageNoStr)) {
//        pageNo = Integer.parseInt(pageNoStr);
//    }
//
//    PageVo pageVo = imgService.getImgList(pageNo);
//
//        pageVo.setUrl(request.getRequestURI() + "?method=list");
//
//        request.setAttribute("pageVo", pageVo);
//
//        request.getRequestDispatcher("/Backstage/imglist.jsp").forward(request, response);
//
//}

}
