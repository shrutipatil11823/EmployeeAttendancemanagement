package org.employee.model;

import java.sql.Time;

public class AttendencaModel 
{
	private Time inTime;
	private Time outTime;
	private int Status;
	private int HalfDay;
	private int FullDay;
	
	AttendencaModel()
	{
		
	}
	
	public AttendencaModel(Time inTime,Time outTime)
	{
		this.inTime=inTime;
		this.outTime=outTime;
	}
	
	public Time getInTime() {
		return inTime;
	}
	public void setInTime(Time inTime) {
		this.inTime = inTime;
	}
	public Time getOutTime() {
		return outTime;
	}
	public void setOutTime(Time outTime) {
		this.outTime = outTime;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getHalfDay() {
		return HalfDay;
	}
	public void setHalfDay(int halfDay) {
		HalfDay = halfDay;
	}
	public int getFullDay() {
		return FullDay;
	}
	public void setFullDay(int fullDay) {
		FullDay = fullDay;
	}
}

