package org.employee.repository;

import java.util.*;

import org.employee.model.EmployeeModel;

import java.sql.Date;
import java.sql.Time;

public class EmployeeRepository extends DBConfig
{
	List<String> lst=new ArrayList<String>();
	
	public List<String> validEmployee(int id)
	{
		try
		{
			p=c.prepareStatement("select username,password from employee where Eid=?");
			p.setInt(1,id);
			rs=p.executeQuery();
			
			while(rs.next())
			{
				lst.add(rs.getString("username"));
				lst.add(rs.getString("password"));
			}
			
			return lst.size()>0?lst:null;
			
		}catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return null;
		}
		
	}
	
	public List<EmployeeModel> viewEmployee(int id)
	{
		try
		{
			List<EmployeeModel> list=new ArrayList<EmployeeModel>();
			
			p=c.prepareStatement("select * from employee where Eid=?");
			p.setInt(1,id);
			
			rs=p.executeQuery();
			
			
			while(rs.next())
			{
				EmployeeModel model=new EmployeeModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setUsername(rs.getString(4));
				model.setPassword(rs.getString(5));
				model.setContact(rs.getString(6));
				model.setjoinDate(rs.getDate(7));
				model.setDept(rs.getString(8));
				model.setSalary(rs.getInt(9));
				
				list.add(model);
				
			}
			
			System.out.println(list.size());
			return list.size()>0?list:null;
			
		
		}catch(Exception ex)
		{
			System.out.println("Exception "+ex);
			return null;
		}
		
	}
	
}



