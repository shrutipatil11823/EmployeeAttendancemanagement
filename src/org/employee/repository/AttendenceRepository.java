package org.employee.repository;

import java.sql.Date;
import java.sql.Time;

public class AttendenceRepository extends DBConfig
{

	private int getDid()
	{
		int did = 0;
		try
		{
			p=c.prepareStatement("select max(Did) from attendance");
			rs=p.executeQuery();
			
			if(rs.next())
			{
				did= rs.getInt(1);
			}
			
			++did;
			
		}catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return 0;
		}
		
		return did;
		
	}
	
	
	public Date fetchdates()
	{
		try
		{
			p=c.prepareStatement("SELECT CURRENT_DATE()");
			rs=p.executeQuery();
			
			
			while(rs.next())
			{
				return rs.getDate(1);
			}
			
		}catch(Exception ex)
		{
			System.out.println("Date Exception "+ex);
			
		}
		return null;
		
	}
	
	public int checkHalffullDay(Time in,Time out)
	{
		try
		{
			p=c.prepareStatement("SELECT HOUR(TIMEDIFF(?, ?)) AS hoursDifference");
			
			p.setTime(1,out);
			p.setTime(2,in);

			int hours=0;
			rs=p.executeQuery();
			
			//List<Time> lst=new ArrayList<Time>();
			while(rs.next())
			{
				hours=rs.getInt("hoursDifference");
				
				//lst.add(rs.getTime(1));
				
			}
			
			return hours;
			
		}catch(Exception ex)
		{
			System.out.println("Time Diff Exception ex"+ex);
		}
		return 0;
		
	}
	
	
	
	public boolean markPresenty(int id,Time in,Time out)
	{
		//boolean id1=this.checkEmp(id);
		int did=this.getDid();
		Date date=this.fetchdates();			
			
			try
			{
					int hours=this.checkHalffullDay(in,out);
					//List<Time> lst=this.checkHalffullDay(in,out);
					String status;
							System.out.println("hours"+hours);
					if(hours>=9 || hours>=6)
					{
						status="P";        
					}else if(hours>=1 && hours<=5)
					{
						status="H";
					}else
					{
						status="A";
					}
							
				p=c.prepareStatement("insert into attendance values(?,?,?,?,?,?)");
				p.setInt(1,id);
				p.setInt(2,did);
				p.setDate(3,date);
				p.setTime(4,in);
				p.setTime(5,out);
				p.setString(6,status);                                                          
				

				int value=p.executeUpdate();
				
				if(value>0)
				{
					return true;
				}else
				{
					return false;
				}
				
			}catch(Exception ex )
			{
				System.out.println("Insertion Exception is "+ex);		
				return false;
			}
}
	
	public boolean markAbsenty(int id1)
{
		int did=this.getDid();
		Date date=this.fetchdates();
		
		
		try
		{		
			p=c.prepareStatement("insert into attendance(Eid,Did,Date) values(?,?,?)");
			p.setInt(1,id1);
			p.setInt(2,did);
			p.setDate(3,date);
			
			int value=p.executeUpdate();
			
			if(value>0)
			{
				return true;
			}else
			{
				return false;
			}
			
		}catch(Exception ex )
		{
			System.out.println("Insertion Exception is "+ex);		
			return false;
		}
		
		
	}
	
	public int fullDayCount(int id)
	{
		try
		{		
			p=c.prepareStatement("select count(*)from attendance where eid=? and status='P'");
			p.setInt(1,id);
			
			rs=p.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
			}
			
		}catch(Exception ex )
		{
			System.out.println("Insertion Exception is "+ex);	
			return 0;
			
		}
		return 0;
		
	}
	
	public int halfDayCount(int id)
	{
		try
		{		
			p=c.prepareStatement("select count(*)from attendance where eid=? and status='H'");
			p.setInt(1,id);
			
			rs=p.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
				
			}
			
		}catch(Exception ex )
		{
			System.out.println("Insertion Exception is "+ex);	
			return 0;
			
		}
		return 0;
		
	}
	
	
	public String absentyCount1(int id)
	{
		try
		{		
			p=c.prepareStatement("select count(*)from attendance where eid=? and status='A'");
			p.setInt(1,id);
			
			rs=p.executeQuery();
			while(rs.next())
			{
				if(rs.getInt(1)!=0)
				{
					p=c.prepareStatement("select leaveType from leavetrack where eid=? and status='A'");
					p.setInt(1,id);
					
					rs=p.executeQuery();
					
					while(rs.next())
					{
						return rs.getString(1);
					}
				}
				
			}
			
		}catch(Exception ex )
		{
			System.out.println("Insertion Exception is "+ex);	
			return null;
			
		}
		return null;
	
		
	}
	
}

	

