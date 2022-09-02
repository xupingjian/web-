package com.at.fruit.pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;
import java.io.IOException;

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOimpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
//  获取参数
        String fidstr = req.getParameter("fid");
        int fid = Integer.parseInt(fidstr);
        String fname = req.getParameter("fname");
        String pricestr = req.getParameter("price");
        int price = Integer.parseInt(pricestr);
        String fcountstr = req.getParameter("fcount");
        int fcount = Integer.parseInt(fcountstr);
        String remark = req.getParameter("remark");
        //执行更新
        fruitDAO.updateFruit(new Fruit(fid,fname,price,fcount,remark));
        //资源跳转(这里的资源跳转不能用这种方式，这种方式会跳转到老的index.html页面，数据没有更新，应该用客户端重定向到index,然后找到indexServlet,在这里更新session域，再调转到index.html)
        //super.processTemplate("index",req,resp);等于服务器内部转发：req.getRequestDispatcher("index.html").forward(req,resp)
        resp.sendRedirect("index");
    }
}
