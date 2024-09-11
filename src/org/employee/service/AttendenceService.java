package org.employee.service;

import java.sql.Time;
import java.util.Scanner;

import org.employee.model.AttendencaModel;
import org.employee.repository.AttendenceRepository;

public class AttendenceService 
{
	AttendenceRepository atRepo=new AttendenceRepository();
	AdminService aSer=new AdminService();
	Scanner sc=new Scanner(System.in);
	
	boolean result;
	
	public void markPresenty(int id)
	{
		if(aSer.checks(id)==1)
		{
			System.out.println("Enter in time and out time to mark attendance in format HH:mm:ss");
			
			
			String in = sc.nextLine(); // "Enter time (HH:mm:ss)
			Time time1 = Time.valueOf(in);
			System.out.println("Time entered: " + time1);

			String out = sc.nextLine(); // "Enter time (HH:mm:ss)
			Time time2 = Time.valueOf(out);
			System.out.println("Time entered: " + time2);

			AttendencaModel atModel = new AttendencaModel(time1, time2);
			result = atRepo.markPresenty(id,time1,time2);
			

			if (result) {
				System.out.println("Attendance successfuly tracked!!");
				
			} else {
				System.out.println("Attendance tracking failed!");
				
			}
		}else
		{
			System.out.println("Admin did not approved presenty!");
		}
		
		
	}
	
	public void markAbsenty(int id)
	{
		
		if(aSer.check(id)==1)
		{
			result = atRepo.markAbsenty(id);

			if (result) {
				System.out.println("Attendance successfuly tracked!!");
	
			} else {
				System.out.println("Attendance tracking failed!");
				
			}		
		}else
		{
			System.out.println("Admin did not approved Absenty!");
		}
			
				
	}
	
}

