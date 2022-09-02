package com.at.servlet;
/*servlet的API*/
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebServlet(urlPatterns = {"/demo01"},
initParams = {
        @WebInitParam(name="hello",value="world"),
        @WebInitParam(name="uname",value="jim")
})*/
public class Demo01Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
//         想在servlet初始化时做些准备工作，那么可以重写init方法(等同于在servlet用注解(如上)的方式来配置初始化参数)
        ServletConfig config = getServletConfig();
        String initvalue = config.getInitParameter("hello");
        System.out.println("initvalue="+initvalue);
        String uname = config.getInitParameter("uname");
        System.out.println(uname);

        ServletContext context = getServletContext();
        String contextConfiglocation = context.getInitParameter("contextConfiglocation");
        System.out.println("contextConfiglocation="+contextConfiglocation);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getSession().getServletContext();
        System.out.println("以前的那种可以在service方法通过session作用域获取key,value的值"+servletContext);
    }
}
