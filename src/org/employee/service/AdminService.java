package org.employee.service;

import java.util.List;

import org.employee.repository.EmployeeRepository;
import java.util.*;
import org.employee.model.EmployeeModel;
import org.employee.repository.AdminRepository;


public class AdminService
{
	AdminRepository aRepo=new AdminRepository();
	EmployeeRepository eRepo=new EmployeeRepository();
	Scanner sc=new Scanner(System.in);
	
	int id,salary;
	String name,email,username,password,contact,joinDate,dept;
	
	
	public List<String> getAdminDetails()
	{
		return this.aRepo.getAdminDetails();
	}	
	
	public void AddEmployee() {
		
		System.out.println("Enter name");
		name = sc.nextLine();
		System.out.println("Enter email");
		email = sc.nextLine();
		System.out.println("Enter username");
		username = sc.nextLine();
		System.out.println("Enter password");
		password = sc.nextLine();
		System.out.println("Enter contact");
		contact = sc.nextLine();
		System.out.println("Enter joinDate");
		joinDate = sc.nextLine();

		// 3/12/2024 Mar 12, 2024, 12:00:00 AM
		Date d1 = new Date(joinDate);

		System.out.println("Enter Department");
		String dept = sc.nextLine();
		
		System.out.println("Enter Salary");
		int salary = sc.nextInt();

		EmployeeModel model = new EmployeeModel(name, email, username, password,
				contact, d1, dept,salary);

		boolean result = aRepo.AddEmployee(model);

		if (result) {
			System.out.println("Employee Added Successfully.....");
		} else {
			System.out.println("Some Problem Is There.....");
		}
	}
	
	public void viewEmployee()
	{
		List<EmployeeModel> list = aRepo.viewEmployee();

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
	
	public void deleteEmployee()
	{
		System.out.println("Enter id of employee to delete record");
		int id = sc.nextInt();

		int op = aRepo.isEmployeePresent(id)?aRepo.deleteEmployee(id)?1:0:-1;

		if (op == 1) {
			System.out.println("Employee deleted successfully");
			eRepo.viewEmployee(id);
		} else if (op == -1) {
			System.out.println("Employee is not present to delete ");
		} else {
			System.out.println("Some problem is there");
		}
	}
	
	public void updateEmployee()
	{
		
		System.out.println("Enter id to update employee");
		id = sc.nextInt();

		sc.nextLine();
		System.out.println("And enter record to update");
		System.out.println("Enter name");
		name = sc.nextLine();
		System.out.println("Enter email");
		email = sc.nextLine();
		System.out.println("Enter username");
		username = sc.nextLine();
		System.out.println("Enter password");
		password = sc.nextLine();
		System.out.println("Enter contact");
		contact = sc.nextLine();
		System.out.println("Enter Department");
		dept = sc.nextLine();

		int op = aRepo.isEmployeePresent(id)?aRepo.updateEmployee(id,name,email,username,password,contact,dept)?1:0:-1;

		if (op == 1) {
			System.out.println("Employee updated successfully");
		} else if (op == -1) {
			System.out.println("Employee is not present to update");
		} else {
			System.out.println("Some problem is there");
		}
		
	}
	
	public void searchEmployee()
	{
		System.out.println("Enter id to search eployee by id");
		id = sc.nextInt();

		int op = aRepo.isEmployeePresent(id)?aRepo.searchEmployee(id)?1:0:-1;
		if (op == 1) {
			System.out.println("Employee Searched successfully");
			
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
			
			
		} else if (op == -1) {
			System.out.println("Employee is not present to search");
		} else {
			System.out.println("Some problem is there");
		}
	}
	
	public int check(int id)
	{
		List<String> str =aRepo.getAdminDetails();
		
		System.out.println("Admin login");
		System.out.println("Please enter username and password");
		String username = sc.nextLine();
		String password = sc.nextLine();
		
		for (String lst : str)
		{
		if (username.equals(str.get(0)) && password.equals(str.get(1))) 
		{
			System.out.println("Do you want to approve the leave (yes/no)");
			
			//int i=sc.nextInt();
			String op=sc.nextLine();
			
			if(op.equals("yes"))
			{
				
			 System.out.println("What kind of leave you want?");
			 System.out.println("Paid leave");
			 System.out.println("Non paid leave");
			
			 
			 System.out.println("Enter your choice as PL,UL");
			 
			 String leave=sc.nextLine();	 
			 
			 aRepo.trackLeave(leave,id);
			 return 1;
				
			}else
			{
				return 0;
			}
		}
		
		break;
		
		}
		
		return 0;
		
	}
		
		
		public int checks(int id1)
		{
			List<String> str1 =aRepo.getAdminDetails();
			
			System.out.println("Admin login");
			System.out.println("Please enter username and password");
			username = sc.nextLine();
			password = sc.nextLine();
			
			for (String lst : str1) {
			if (username.equals(str1.get(0)) && password.equals(str1.get(1))) 
			{
				System.out.println("Do you want to approve the leave (yes/no)");
				
				//int i=sc.nextInt();
				String op=sc.nextLine();
				
				if(op.equals("yes"))
				{
					return 1;	 

					
				}else
				{
					return 0; 
					
				}
			}
			break;
			}
			return 0;
			
			
		}
		
	
	
}



