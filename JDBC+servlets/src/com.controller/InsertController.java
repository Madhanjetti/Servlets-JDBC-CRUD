package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.Samplejdbc;


@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out=response.getWriter();
		String id=request.getParameter("empId");
		String name=request.getParameter("empName");
		String salary=request.getParameter("empSalary");
		
		out.println(id+" "+name+" "+salary);
		int eid=Integer.parseInt(id);
		float esalary=Float.parseFloat(salary);
		
		Samplejdbc.createConnectionTest();
		Samplejdbc.insertValues(eid, name, esalary);
		out.println("Inserted...");
		
		
	}

}
