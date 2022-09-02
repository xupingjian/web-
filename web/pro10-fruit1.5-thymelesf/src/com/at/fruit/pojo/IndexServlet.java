package com.at.fruit.pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FruitDAOimpl fruitDAOimpl = new FruitDAOimpl();
        List<Fruit> fruitless = fruitDAOimpl.getFruitless();
        HttpSession session = req.getSession();
        session.setAttribute("fruitList",fruitless);
        //此处试图名称是index,那么thymeleaf会将这个逻辑视图名称对应到物理视图名称上去
        //逻辑视图名称：index
        //物理视图名称：view-prefix + 逻辑视图名称+view-suffix
        //所以真实的视图名称是： /       index   +   .html
        super.processTemplate("index",req,resp);
    }
}
