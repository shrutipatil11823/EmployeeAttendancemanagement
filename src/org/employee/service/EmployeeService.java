package org.employee.service;
import java.sql.Time;
import java.util.*;

import org.employee.model.EmployeeModel;
import org.employee.repository.EmployeeRepository;

public class EmployeeService {

	EmployeeRepository eRepo=new EmployeeRepository();
	Scanner sc=new Scanner(System.in);
	int id;
	
	public List<String> validEmployee(int id)
	{
		return eRepo.validEmployee(id);
	}
	
	public void viewEmployee()
	{
		System.out.println("Enter id to view your record ");
		id = sc.nextInt();
		List<EmployeeModel> list = eRepo.viewEmployee(id);

		System.out.println("Eid\tName\tEmail\t\t\tUsername\tPassword\tContact\t\t\tJoindate\t\tDepartment\t\tSalary");
		for (EmployeeModel lst1 : list) 
		{	
			System.out.println(lst1.getId() + "\t" + lst1.getName()
					+ "\t" + lst1.getEmail() + "\t\t" 
					+ lst1.getUsername() + "\t\t" + lst1.getPassword()
					+ "\t\t" + lst1.getContact() + "\t\t" 
					+ lst1.getjoinDate() + "\t\t" + lst1.getDept()
					+ "\t\t"+lst1.getSalary());
		}
		
	}
	
	
	
}
