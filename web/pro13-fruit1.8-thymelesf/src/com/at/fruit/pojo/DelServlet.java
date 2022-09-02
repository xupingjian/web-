package com.at.fruit.pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet{
    private FruitDAO fruitDAO = new FruitDAOimpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidstr = req.getParameter("fid");
        if(StringUtil.isNotEmpty(fidstr)){
            int fid = Integer.parseInt(fidstr);
            fruitDAO.delFruit(fid);
//            在这里同样不能用super.processTemplate("index",req,resp);
            resp.sendRedirect("index");
//            super.processTemplate("index",req,resp);
        }
    }
}
