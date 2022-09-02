package com.at.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("*.do")
public class demo02Fiter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("helloA");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("helloB");
    }

    @Override
    public void destroy() {

    }
}
