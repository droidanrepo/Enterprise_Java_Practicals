/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.prac1c;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Graham
 */
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            /* TODO output your page here. You may use following sample code. */
            Connection con=null;
            PreparedStatement ps=null;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String username=request.getParameter("uname");
            String password=request.getParameter("pw");
            String emailid=request.getParameter("email");
            String country=request.getParameter("coun");
            try
            { Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/registerdb","root","");
            out.println("connection done successfully...");
            ps=con.prepareStatement("insert into user values (?,?,?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,emailid);
            ps.setString(4,country);
            ps.execute();
            out.print("Data insserted successfully!!!!");
            }
            catch(Exception e) { out.println(e); }
            out.println("<b>"+"<b>");
        }

}
