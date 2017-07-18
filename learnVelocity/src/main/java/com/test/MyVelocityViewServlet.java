package com.test;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.http.*;

public class MyVelocityViewServlet extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        // 往Context容器存放变量
        ctx.put("fullName","lixiaolin");
        // 也可以往request域中存值
        request.setAttribute("anotherName","xlli");
        // forward到指定模板
        return getTemplate("test.vm");
    }
}