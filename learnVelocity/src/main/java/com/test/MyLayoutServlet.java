package com.test;

import org.apache.velocity.tools.view.VelocityLayoutServlet;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

public class MyLayoutServlet extends VelocityLayoutServlet {
    @Override
    protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        // 设置通用的变量
        request.setAttribute("Request", request);
        request.setAttribute("ContextPath", request.getContextPath());
        request.setAttribute("BasePath", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());
*/
        long runtime = System.currentTimeMillis();

        //super.doRequest(request, response);

        if (request.getAttribute("close_comment") == null) {
            Date cur_time = Calendar.getInstance(request.getLocale()).getTime();
            PrintWriter pw = response.getWriter();
            pw.print("\r\n<!-- Generated by VelocityApp Server(");
            pw.print(cur_time);
            pw.print(") Cost ");
            pw.print(cur_time.getTime() - runtime);
            pw.print(" ms -->");
            pw.flush();
            pw.close();
        }else{
            Date cur_time = Calendar.getInstance(request.getLocale()).getTime();
            PrintWriter pw = response.getWriter();
            pw.print("\r\n<!-- Generated by VelocityApp Server(");
            pw.print(cur_time);
            pw.print(") Cost ");
            pw.print(cur_time.getTime() - runtime);
            pw.print(" ms -->");
            pw.flush();
            pw.close();
        }

    }
}

