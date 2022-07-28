package com.example.custormertracker;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //set connectionns variables
        String user = "springstudent";
        String pass = "springstudent";

        String jbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.cj.jdbc.Driver";
        //String driver = "com.mysql.jdbc.Driver";

        // get connection to database
        try{
            PrintWriter out = response.getWriter();

            out.println("connecting to database:"+ jbcUrl);

            Class.forName(driver);


            out.println("drivers loaded..");

            Connection connection = DriverManager.getConnection(jbcUrl,user,pass);
            out.println("SUCCESS!!");

            connection.close();
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);

        }

    }


}