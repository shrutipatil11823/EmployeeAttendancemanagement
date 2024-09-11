package org.employee.model;

import java.util.Date;

public class EmployeeModel
{
	private int id;
	private String name;
	private String email;
	private String username;
	private String password;
	private String contact;
	private Date joinDate;
	private String dept;
	private int salary;
	
	
	public EmployeeModel()
	{
		
	}
	
	public EmployeeModel(String name,String email,String username,String password,String contact,Date joinDate,String dept,int salary)
	{
		this.name=name;
		this.email=email;
		this.username=username;
		this.password=password;
		this.contact=contact;
		this.joinDate=joinDate;
		this.dept=dept;
		this.salary=salary;
		
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setjoinDate(Date joinDate)
	{
		this.joinDate=joinDate;
	}
	
	public Date getjoinDate()
	{
		return joinDate;
	}
	
	public void setDept(String dept)
	{
		this.dept=dept;
	}
	
	public String getDept()
	{
		return dept;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

