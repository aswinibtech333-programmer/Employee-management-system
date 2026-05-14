package com.org.employee_management_system.controller;

import java.io.IOException;
import java.util.List;

import com.org.employee_management_system.dao.DaoLayer;
import com.org.employee_management_system.entity.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/displaydata")
public class DisplayAllTheEmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoLayer dao = new DaoLayer();
		List<Employee> emp = dao.getAllemployee();

		req.setAttribute("employee", emp);
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, resp);

	}
}
