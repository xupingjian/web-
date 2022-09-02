package com.at.fruit.pojo;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/demo06")
public class demo06Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取 application保存作用域保存的数据
        ServletContext application = req.getServletContext();
        Object uname = application.getAttribute("uname");
        System.out.println("Uname="+uname);
    }
}
