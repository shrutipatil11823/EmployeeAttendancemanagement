package org.employee.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.employee.model.EmployeeModel;

public class AdminRepository extends DBConfig
{
	List<String> list=new ArrayList<String>();
	private int empId;
	
	private int getEmployeeId() {
		try {
			p = c.prepareStatement("select max(Eid) from employee");
			rs = p.executeQuery();

			if (rs.next()) 
			{
				empId = rs.getInt(1);
			}
			
			++empId;
		} catch (Exception ex) {
			System.out.println("Exception ex " + ex);
			return 0;
		}
		return empId;
	}
	
	public boolean AddEmployee(EmployeeModel model) {
		try {
			
			int eid=this.getEmployeeId();
			
			if(eid!=0)
			{
				
			String d = model.getjoinDate().toLocaleString();

				String d1[]=d.split(",");//mar 12     2024   
				String d2[]=d1[0].trim().split(" ");
//				System.out.println("Month "+d2[0]);
//				System.out.println("Date "+d2[1]);
//				System.out.println("Year "+d1[1]);
				
				int m=0;
				
				switch(d2[0].trim())
				{
				case "Jan":
					m=0;
					break;
					
				case "Feb":
					m=1;
					break;
					
				case "Mar":
					m=2;
					break;
					
				case "Apr":
					m=3;
					break;
					
				case "May":
					m=4;
					break;
					
				case "Jun":
					m=5;
					break;
					
				case "July":
					m=6;
					break;
					
				case "Aug":
					m=7;
					break;
					
				case "Sept":
					m=8;
					break;
					
				case "Oct":
					m=9;
					break;
					
				case "Nov":
					m=10;
					break;
					
				case "Dec":
					m=11;
					break;
				}
				
				String year = d1[1].trim().substring(2, d1[1].trim().length());
				Date dt = new Date(Integer.parseInt(year) + 100, m, Integer.parseInt(d2[1]));
				//public Date(int year, int month, int date) 
				
				
				p = c.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");
				p.setInt(1,eid);
				p.setString(2, model.getName());
				p.setString(3, model.getEmail());
				p.setString(4, model.getUsername());
				p.setString(5, model.getPassword());
				p.setString(6, model.getContact());
				p.setDate(7,dt);
				p.setString(8,model.getDept());
				p.setInt(9,model.getSalary());
				

				int value = p.executeUpdate();

				if (value > 0) 
				{
					return true;
					
				} else {
					
					return false;
					
				}

			
			}else
			{
				return false;
			}
			
		} catch (Exception ex)
		{
			System.out.println("Exception occured : " + ex);
			return false;
		}
			
	}
	
	public List<EmployeeModel> viewEmployee()
	{
		try
		{
			List<EmployeeModel> list=new ArrayList<EmployeeModel>();
			
			p=c.prepareStatement("select * from employee");
			
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
	
	public boolean isEmployeePresent(int id)
	{
		try
		{
			p=c.prepareStatement("select * from employee where Eid=?");
			p.setInt(1,id);
			rs=p.executeQuery();
			
			return rs.next();
			
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
		}
		return false;
	}
	
	public boolean updateEmployee(int id,String name,String email,String username,String password,String contact,String Dept)
	{
		try
		{
			p=c.prepareStatement("update employee set Ename=?,Email=?,username=?,password=?,contact=?,Department=? where Eid=?");
			
			p.setString(1,name);
			p.setString(2,email);
			p.setString(3,username);
			p.setString(4,password);
			p.setString(5,contact);
			p.setString(6,Dept);	
			p.setInt(7,id);
			
			int value=p.executeUpdate();
			
			if(value>0)
			{
				return true;
			}else
			{
				return false;
			}
			
		}catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return false;
		}
		
	}
	
	public boolean deleteEmployee(int id)
	{
		
			try
			{
				p=c.prepareStatement("delete from employee where Eid=?");
				
				p.setInt(1,id);
				int value=p.executeUpdate();
				
				if(value>0)
				{
					return true;
				}else
				{
					return false;
				}
				
				
			}catch(Exception ex)
			{
				System.out.println("Exception is "+ex);
				return false;
			}

	}
	
	
	
	public boolean searchEmployee(int id)
	{
		try
		{
			p=c.prepareStatement("select * from employee where Eid=?");
			p.setInt(1,id);
			
			rs=p.executeQuery();
			
			return rs.next();
			
		}catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return false;
		}
		
	}
	

	
	public List<String>getAdminDetails()
	{
		try
		{
			p=c.prepareStatement("select username,password from admin");	
			rs=p.executeQuery();
			
			while(rs.next())
			{
				list.add(rs.getString("username"));
				list.add(rs.getString("password"));
			}
		
			return (list.size()>0?list:null);
			
		}catch(Exception ex)
		{
			System.out.println("Exception ex "+ex);
			return null;
		}
		
	}
	
	public int getLid()
	{
		int lid = 0;
		
		try
		{
			p=c.prepareStatement("select max(lid) from leaveTrack");
			
			rs=p.executeQuery();
			
			while(rs.next())
			{
				lid=rs.getInt(1);
			}
			
			++lid;
			
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return 0;
		}
		return lid;
	}
	
	public void trackLeave(String leave,int id) {
		
		int id1=this.getLid();
		
		try
		{
			p=c.prepareStatement("insert into leaveTrack values(?,?,?)");
			p.setInt(1,id);
			p.setInt(2,id1);
			p.setString(3,leave);
			
			int value=p.executeUpdate();
			
			if(value>0)
			{
				System.out.println("data added");
			}
			else{
				System.out.println("Some problem there");
			}
			
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			
		}
		
	}

}

