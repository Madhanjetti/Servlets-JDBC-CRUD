package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.Samplejdbc;


@WebServlet("/SelectController")
public class SelectController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Samplejdbc.createConnectionTest();
		ResultSet rs=Samplejdbc.selectAllRows();
		try {
			
			while(rs.next()) {
				int id=rs.getInt(1);
				 String name=rs.getString(2);
				float salary=rs.getFloat(3);
				out.println(id+" "+name+" "+salary);
				out.println("==========================================");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
