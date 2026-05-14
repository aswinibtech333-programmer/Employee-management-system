package com.org.employee_management_system.controller;

import java.io.IOException;

import com.org.employee_management_system.dao.DaoLayer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteEmployeeController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("empId");
	int empId = Integer.parseInt(id);

	DaoLayer dao=new DaoLayer();
	
	boolean b=dao.deleteById(empId);
	if(b) {
		System.out.println("Data is deleted...");
		resp.sendRedirect("display.jsp");
	}
	else {
		System.out.println("Given id is not Found");
	}
}
}
