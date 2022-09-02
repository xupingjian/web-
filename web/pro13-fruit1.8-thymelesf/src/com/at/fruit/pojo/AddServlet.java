package com.at.fruit.pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet{
    private FruitDAO fruitDAO = new FruitDAOimpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //  获取参数

        String fname = req.getParameter("fname");
        String pricestr = req.getParameter("price");
        int price = Integer.parseInt(pricestr);
        String fcountstr = req.getParameter("fcount");
        int fcount = Integer.parseInt(fcountstr);
        String remark = req.getParameter("remark");
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);

        fruitDAO.addFruit(fruit);
        resp.sendRedirect("index");
    }
}
