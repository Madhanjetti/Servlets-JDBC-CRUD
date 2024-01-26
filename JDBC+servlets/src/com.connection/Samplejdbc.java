package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Samplejdbc {

	public static Connection con;
	public static void createConnectionTest() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname","username","password");
			System.out.println("Connection Created");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void insertValues(int eid,String ename,float esalary) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into emp1 values (?,?,?)");
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setFloat(3, esalary);
			int x=ps.executeUpdate();
			if(x>0) {
				System.out.println("Inserted!");
			}else {
				System.out.println("Not inserted");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ResultSet selectAllRows() {
		try {
			PreparedStatement ps=con.prepareStatement("select * from emp1");
			ResultSet rs=ps.executeQuery();
			return rs;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	public static void updateValues(int eid,float esalary) {
		try {
			PreparedStatement ps=con.prepareStatement("update emp1 set esalary ="+esalary+"where eid ="+eid);
			int x=ps.executeUpdate();
			if(x>0) {
				System.out.println("Updated Succesfully");
			}else {
				System.out.println("Not Updated");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteRow(int eid) {
		try {
			PreparedStatement ps=con.prepareStatement("delete from emp1 where eid = "+eid);
			int x=ps.executeUpdate();
			if(x>0) {
				System.out.println("Deleted Sucessfully");
			}else {
				System.out.println("Not deleted");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
