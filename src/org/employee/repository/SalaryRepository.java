package org.employee.repository;

import java.util.*;

import org.employee.model.EmployeeModel;

public class SalaryRepository extends DBConfig 
{
	public List<EmployeeModel> showSalary()
	{
		List<EmployeeModel> lst=new ArrayList<EmployeeModel>();
		
		try
		{
			p=c.prepareStatement("select Eid,Ename,Salary from employee");
			rs=p.executeQuery();
			
			while(rs.next())
			{
				EmployeeModel em=new EmployeeModel();
				
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setSalary(rs.getInt(3));
				
				lst.add(em);
			}
			
			return lst.size()>0?lst:null;
			
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return null;
		}
		
	}
	
	
	
}
