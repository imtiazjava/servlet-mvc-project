package com.cgi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cgi.model.Student;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public boolean addStudent(Student student) {
		 //jdbc code to store the data into the database
		//step1:register with driver
		 try {
			//step1:register with driver
			 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//step2:get the connection
			 String url="jdbc:mysql://localhost:3306/cgi3";
			 String uname="root";
			 String pwd="root";
			 Connection con=DriverManager.getConnection(url, uname, pwd);
			 //Step3: get the Preparedstatement object by passing query
			 String query="insert into student values(?,?,?)";
			 PreparedStatement pstmt =con.prepareStatement(query);
			 //replace the positional parameters with values
			 pstmt.setInt(1, student.getSid());
			 pstmt.setString(2, student.getSname());
			 pstmt.setInt(3, student.getSmarks());
			 
			 //Stetp4: execute the query
			 int no = pstmt.executeUpdate();
			 System.out.println(no+": record is inserted in db");
			 
			 //step5: close the connection
			 con.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return true;
	}

}
