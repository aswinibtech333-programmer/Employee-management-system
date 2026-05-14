package com.org.employee_management_system.controller;

import java.io.IOException;
import java.util.List;

import com.org.employee_management_system.dao.DaoLayer;
import com.org.employee_management_system.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/display")
public class PrintingAllThedata extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	DaoLayer dao=new DaoLayer();
	List<Employee> emp=dao.getAllemployee();
	for (Employee employee : emp) {
		System.out.println(employee.getName());
		System.out.println(employee.getPhone());
		System.out.println("----------------");
	}
	
  
  }
}
