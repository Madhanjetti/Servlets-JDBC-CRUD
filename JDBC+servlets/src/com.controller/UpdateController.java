package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.Samplejdbc;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String eid=request.getParameter("empId");
		String esalary=request.getParameter("empSalary");
		int eid1=Integer.parseInt(eid);
		float esalary1=Float.parseFloat(esalary);
		Samplejdbc.createConnectionTest();
		Samplejdbc.updateValues(eid1,esalary1);
		out.println("Updated....");
		
	}

}
