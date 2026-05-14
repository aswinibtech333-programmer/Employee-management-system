package com.org.employee_management_system.controller;

import java.io.IOException;

import com.org.employee_management_system.dao.DaoLayer;
import com.org.employee_management_system.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/validate")
public class ValidatrionServletController extends HttpServlet {
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String currentEmail=req.getParameter("empEmail");
    	String currentPassword=req.getParameter("empPassword");
    	
    	DaoLayer dao=new DaoLayer();
    	Employee emp=dao.getEmployeeByEmailandPassword(currentEmail, currentPassword);
    	if(emp!=null) {
    		HttpSession session=req.getSession();
    		session.setAttribute("empName",emp.getName());
    		resp.sendRedirect("home.jsp");
    		
    	}
    	else {
    		resp.sendRedirect("Registration-form.html");
    	}
    }
}
