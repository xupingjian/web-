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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void doGet(HttpServletRequest req , HttpServletResponse resp)throws IOException, ServletException {
        Integer pageNo = 1 ;
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String oper = req.getParameter("oper");
        //如果oper!=null 说明通过表单的查询点击过来的
        //如果oper=null 说明不是通过表单的查询按钮点击过来的

        String keyword = null;
        if(StringUtil.isNotEmpty(oper)&&"search".equals(oper)){
            //说明是点击表单查询过来发送过来的请求
            //此时，pageNo应该还原为1，keyworld应该从请求参数中获取
            pageNo=1;
            keyword = req.getParameter("keyword");
            //如果keyword为null，需要设置为空字符串"",否则查询结果拼接成字符串%null%
//            if(StringUtil.isNotEmpty(keyword)){
//                keyword="";
//            }
            session.setAttribute("keyword",keyword);
        }else{
            //说明是点击表单查询过来发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入网址）
            //此时keyword应该从session作用域获取
            String pageNoStr = req.getParameter("pageNo");
            if(StringUtil.isNotEmpty(pageNoStr)){
                pageNo = Integer.parseInt(pageNoStr);
            }
            //如果不是点击的查询按钮，那么查询是基于session中保存的现有keyword进行查询
            Object keywordObj = session.getAttribute("keyword");
            if(keywordObj!=null){
                keyword = (String)keywordObj ;
            }else{
                keyword = "" ;
            }
        }

//      重新更新当前页的值
        session.setAttribute("pageNo",pageNo);
        FruitDAOimpl fruitDAOimpl = new FruitDAOimpl();
        List<Fruit> fruitless = fruitDAOimpl.getFruitless(keyword,pageNo);

        session.setAttribute("fruitList",fruitless);
        //总记录条数
        int fruitCount = fruitDAOimpl.getFruitCount(keyword);
        //总页数
        int pageCount = (fruitCount+5-1)/5 ;
        /*
        总记录条数       总页数
        1               1
        5               1
        6               2
        10              2
        11              3
        fruitCount      (fruitCount+5-1)/5
         */
        session.setAttribute("pageCount",pageCount);

        //此处试图名称是index,那么thymeleaf会将这个逻辑视图名称对应到物理视图名称上去
        //逻辑视图名称：index
        //物理视图名称：view-prefix + 逻辑视图名称+view-suffix
        //所以真实的视图名称是： /       index   +   .html
        super.processTemplate("index",req,resp);
    }
}
