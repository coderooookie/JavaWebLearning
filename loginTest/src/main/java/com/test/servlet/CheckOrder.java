/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: CheckOrder.java project: loginTest
 * @creator: hongshubin
 * @date: 2017/7/12
 */

package com.test.servlet;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-12 17:13
 * @lastdate:
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hongshubin on 2017/7/12.
 */
@WebServlet("/order")
public class CheckOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");
        //PrintWriter out = res.getWriter();
        req.getRequestDispatcher("/order.jsp").forward(req,res);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doGet(req, res);
    }
}