package org.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.employee.model.EmployeeModel;
import org.employee.repository.AttendenceRepository;
import org.employee.repository.SalaryRepository;

public class SalaryService {
	
	SalaryRepository sRepo=new SalaryRepository();
	AttendenceRepository atRepo=new AttendenceRepository();
	Scanner sc=new Scanner(System.in);

	public void showSalary()
	{
		
		List<EmployeeModel> list = sRepo.showSalary();

		System.out.println("Eid\t\tName\t\tSalary");
		for (EmployeeModel lst1 : list) 
		{	
			System.out.println(lst1.getId() + "\t\t"+lst1.getName()+"\t\t"+lst1.getSalary());
		}
		
	}
	
	public int calcMonthandDayWise()
	{
		System.out.println("Enter id");
		int id=sc.nextInt();
		int mSal = 0,dSal= 0;
		List<EmployeeModel> list=sRepo.showSalary();
		
		System.out.println("Get salary");
		for (EmployeeModel lst1 : list) 
		{	
			if(id==lst1.getId())
			{
				dSal=lst1.getSalary()/365;
				mSal=lst1.getSalary()/12;
			}
			
		}
		System.out.println(mSal);
		System.out.println(dSal);
		
		int p=atRepo.fullDayCount(id);
		System.out.println(p); 
		int h=atRepo.halfDayCount(id);
		System.out.println(h); 
	//	String atype=atRepo.absentyCount1(id);
		
		int totalSal;
		
		totalSal=p*dSal+h*(dSal/2);
		System.out.println("totalSal "+totalSal);
		
//		if(atype.equals("PL"))
//		{
//			totalSal+=dSal;
//		}
		
		System.out.println("totalSal "+totalSal);
		
		
		return mSal;
		
	}
	
}


