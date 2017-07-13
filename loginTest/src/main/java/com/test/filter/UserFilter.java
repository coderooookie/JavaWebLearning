/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: UserFilter.java project: loginTest
 * @creator: hongshubin
 * @date: 2017/7/13
 */

package com.test.filter;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-13 09:37
 * @lastdate:
 */

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hongshubin on 2017/7/13.
 */
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
