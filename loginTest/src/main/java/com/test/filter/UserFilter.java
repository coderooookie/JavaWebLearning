package com.test.filter;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements Filter {
    private FilterConfig config;
    public void init(FilterConfig config) throws ServletException{
        this.config = config;
    }
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //System.out.println("过滤器开始工作！");
        boolean isLogined = false;
        Cookie[] cks = null;
        HttpServletRequest httpReq = (HttpServletRequest)req;
        HttpServletResponse httpRes = (HttpServletResponse)res;
        cks = httpReq.getCookies();
        for (Cookie ck : cks){
            if (ck.getName().equals("sid") && ck.getValue().equals("abb")){isLogined = true;}
        }
        if (isLogined){
            chain.doFilter(req, res);
        }else{
            httpRes.sendRedirect("/login");
        }

    }

    public void destroy(){

    }
}
