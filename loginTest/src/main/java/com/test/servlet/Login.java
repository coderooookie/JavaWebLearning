package com.test.servlet;
/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: Login.java project: loginTest
 * @creator: hongshubin
 * @date: 2017/7/12
 */

/**
 * @description: login test 
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-12 13:52
 * @lastdate:
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

/**
 * Created by hongshubin on 2017/7/12.
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html;charset=utf-8");
        //PrintWriter out = res.getWriter();
        req.getRequestDispatcher("/login.jsp").forward(req,res);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        boolean flag = false;
        String name = new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        Connection con = null;
        String url = "jdbc:mysql://192.168.172.29:3306/b2c?characterEncoding=utf8&connectTimeout=10000&autoReconnect=true";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,"root","root");
            PreparedStatement stmt = con.prepareStatement("SELECT count(out_username) as id FROM user_info WHERE out_username = ?");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                if (rs.getInt("id") > 0){
                    flag = true;
                }
            }
            if (flag) {
                Cookie cookie = new Cookie("sid","abb");
                cookie.setMaxAge(10);
                res.addCookie(cookie);
                res.sendRedirect("/order");
                //req.getRequestDispatcher("/order").forward(req, res);
            }else{
                res.sendRedirect("/order");
                //req.getRequestDispatcher("/login").forward(req,res);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
