package com.org.employee_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.employee_management_system.connection.GetConnectionObject;
import com.org.employee_management_system.entity.Employee;

public class DaoLayer {
/*
 * Design a method to save the data
 */
	Connection con=GetConnectionObject.getconnectionObject();
	public boolean saveEmployee(Employee emp) {
		String insertQuery="INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement p=con.prepareStatement(insertQuery);
			p.setInt(1, emp.getEmpid());
			p.setString(2, emp.getName());
			p.setString(3, emp.getEmail());
			p.setString(4, emp.getPassword());
		    p.setInt(5, emp.getAge());
			p.setString(6, emp.getGender());
			p.setDouble(7, emp.getSalary());
			p.setString(8, emp.getRole());
			p.setString(9, emp.getAddress());
			p.setLong(10, emp.getPhone());
			
			return p.executeUpdate()>0;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		

	}
public List<Employee> getAllemployee(){
	String selectQuery="Select * from Employee";
	List<Employee> list=new ArrayList<Employee>();
	try {
		PreparedStatement p=con.prepareStatement(selectQuery);
		ResultSet res=p.executeQuery();
		while(res.next()) {
			int empid=res.getInt("empid");
			String name=res.getString("name");
			String email=res.getString("email");
			String pwd=res.getString("password");
			int age=res.getInt("age");
			String gender=res.getString("gender");
			Double salary=res.getDouble("salary");
			String role=res.getString("role");
			String address=res.getString("address");
			Long phone=res.getLong("phone");
			
			
			//bind all the data into object
			
			
			Employee employee=new Employee();
			
		    employee.setEmpid(empid);
		    employee.setName(name);
		    employee.setEmail(email);
		    employee.setPassword(pwd);
		    employee.setAge(age);
		    employee.setGender(gender);
		    employee.setSalary(salary);
		    employee.setRole(role);
		    employee.setAddress(address);
		    employee.setPhone(phone);
		    
		    
			
			list.add(employee);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return list;
	
}

public boolean deleteById(int id) {
	String query="delete from employee where empid=?";
	
	try {
		PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, id);
		return p.executeUpdate()>0;
		
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	
	
	
	return false;
	
	
}

/*
 * 
 * Design a method to fetch the record based on the Id
 * 
 * 
 */
	

public Employee getEmployeeById(int id){
	String selectQuery="Select * from Employee where empid=?";
	
	try {
		PreparedStatement p=con.prepareStatement(selectQuery);
		p.setInt(1, id);
		ResultSet res=p.executeQuery();
		if(res.next()) {
			int empid=res.getInt("empid");
			String name=res.getString("name");
			String email=res.getString("email");
			String pwd=res.getString("password");
			int age=res.getInt("age");
			String gender=res.getString("gender");
			Double salary=res.getDouble("salary");
			String role=res.getString("role");
			String address=res.getString("address");
			Long phone=res.getLong("phone");
			
			
			//bind all the data into object
			
			
			Employee employee=new Employee();
			
		    employee.setEmpid(empid);
		    employee.setName(name);
		    employee.setEmail(email);
		    employee.setPassword(pwd);
		    employee.setAge(age);
		    employee.setGender(gender);
		    employee.setSalary(salary);
		    employee.setRole(role);
		    employee.setAddress(address);
		    employee.setPhone(phone);
		    
		    
			
			return employee;
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return null;
	
}



public boolean updateEmployee(Employee emp) {
	
	String updatequery="update employee set  name=?,email=?,password=?,age=?,gender=?,salary=?,role=?,address=?,phone=? where empid=?";
	
	try {
		PreparedStatement pstm=con.prepareStatement(updatequery);
		pstm.setString(1,emp.getName());
		pstm.setString(2, emp.getEmail());
		pstm.setString(3, emp.getPassword());
		pstm.setInt(4,emp.getAge());
		pstm.setString(5, emp.getGender());
	    pstm.setDouble(6, emp.getSalary());
		pstm.setString(7, emp.getRole());
		pstm.setString(8, emp.getAddress());
		pstm.setLong(9,emp.getPhone());
		pstm.setInt(10, emp.getEmpid());
		
		return pstm.executeUpdate()>0;
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return false;
	
}

public Employee getEmployeeByEmailandPassword(String currentEmail,String currentPassword){
	String selectQuery="Select * from Employee where email=? AND password=?";
	
	try {
		PreparedStatement p=con.prepareStatement(selectQuery);
		
		
		p.setString(1,currentEmail);
		p.setString(2,currentPassword);
		ResultSet res=p.executeQuery();
		if(res.next()) {
			int empid=res.getInt("empid");
			String name=res.getString("name");
			String email=res.getString("email");
			String pwd=res.getString("password");
			int age=res.getInt("age");
			String gender=res.getString("gender");
			Double salary=res.getDouble("salary");
			String role=res.getString("role");
			String address=res.getString("address");
			Long phone=res.getLong("phone");
			
			
			//bind all the data into object
			
			
			Employee employee=new Employee();
			
		    employee.setEmpid(empid);
		    employee.setName(name);
		    employee.setEmail(email);
		    employee.setPassword(pwd);
		    employee.setAge(age);
		    employee.setGender(gender);
		    employee.setSalary(salary);
		    employee.setRole(role);
		    employee.setAddress(address);
		    employee.setPhone(phone);
		    
		    
			
			return employee;
		} 
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return null;
	
}}