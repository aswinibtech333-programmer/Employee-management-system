package com.org.employee_management_system.controller;

import java.io.IOException;

import com.org.employee_management_system.dao.DaoLayer;
import com.org.employee_management_system.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class ReadRegiterationFormData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("empId");
		String name = req.getParameter("empName");
		String email = req.getParameter("empEmail");
		String pwd = req.getParameter("empPwd");
		String age = req.getParameter("empAge");
		String gender = req.getParameter("empGender");
		String salary = req.getParameter("empSalary");
		String role = req.getParameter("empRole");
		String address = req.getParameter("empAddress");
		String phone = req.getParameter("empPhone");
		 
		Employee emp=new Employee();
		
		emp.setEmpid(Integer.parseInt(id));
		emp.setName(name);
		emp.setEmail(email);
		emp.setPassword(phone);
		emp.setAddress(address);
		emp.setAge(Integer.parseInt(age));
		emp.setGender(gender);
		emp.setRole(role);
		emp.setSalary(Double.parseDouble(salary));
		emp.setPhone(Long.parseLong(phone));
		
		
		/*
		 * call the Method
		 */
		
		DaoLayer dao=new DaoLayer();
		boolean b=dao.saveEmployee(emp);
		if(b) {
			System.out.println("Inserted Successfully...");
			resp.sendRedirect("login.html");
		}
		else {
			System.out.println("not inserted"); 
		}
		
	}

}
