<%--
  Created by IntelliJ IDEA.
  User: 79367
  Date: 2020/6/10
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String servicePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/client/";
    pageContext.setAttribute("basePath", servicePath);
%>
<base href="${pageScope.basePath}">
