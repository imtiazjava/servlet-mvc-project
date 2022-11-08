package com.cgi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgi.dao.StudentDAOImpl;
import com.cgi.model.Student;

public class StudentController extends HttpServlet {

	
	public StudentController() {
		System.out.println("student controller object is created..");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //here we have to write the code to capture the
		// information from the form
		  String sid = req.getParameter("sid");
		  int id  = Integer.parseInt(sid);
		   
		  String sname=req.getParameter("sname");
		  String smarks=req.getParameter("smarks");
		  int marks = Integer.parseInt(smarks);
		  
		  
		  //create object for model
		  Student student=new Student();
		  //set the data into the student object
		  student.setSid(id);
		  student.setSname(sname);
		  student.setSmarks(marks);
		  
		  //create object for StudentDAOImpl
		  
		  StudentDAOImpl sdo=new StudentDAOImpl();
		  
		  boolean status = sdo.addStudent(student);
		  
		  if(status==true) {
			  //dispatch the request to jsp
			  RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
			  rd.forward(req, resp);
		  }
		  			   
		  
		  
	}
	
}
