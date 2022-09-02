package com.at.fruit.pojo;

//演示session保存作用域（demo01,demo02）
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/demo03")
public class demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.向Session保存作用域保存数据
        request.getSession().setAttribute("uname","lili");

        response.sendRedirect("demo04");//客户端重定向(在session作用域里只要session会话没过期，发两次请求也可以接收到保存域里的内容)
//        request.getRequestDispatcher("demo04").forward(request,response);//服务器端转发
    }
}