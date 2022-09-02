package com.at.fruit.pojo;

//演示application保存作用域（demo05,demo06）
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/demo05")
public class demo05Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.向application保存作用域保存数据
//        ServletContext:Servlet上下文（tomcat的起止代表着Servlet的起止）
        ServletContext application = request.getServletContext();
        application.setAttribute("uname","lili");

        response.sendRedirect("demo06");//客户端重定向(在session作用域里只要session会话没过期，发两次请求也可以接收到保存域里的内容)
//        request.getRequestDispatcher("demo06").forward(request,response);//服务器端转发
    }
}