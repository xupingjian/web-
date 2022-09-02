package com.at.fruit.pojo;
//演示request保存作用域（demo01,demo02）
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/demo01")
public class demo01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.向request保存作用域保存数据
        request.setAttribute("uname","lili");

//        resp.sendRedirect("demo02");//客户端重定向
        request.getRequestDispatcher("demo02").forward(request,response);//服务器端转发
    }
}
