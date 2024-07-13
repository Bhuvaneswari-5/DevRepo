package com.bhuvana.service;

public class BankService 
{
	public double simpleInterest(double pstmt,double rate,double time)
	{
		if(pstmt<=0 || rate<=0 || time<=0)
		{
			throw new IllegalArgumentException("invalid vales taken");

		}
		double simpleinterest=pstmt*rate*time/100.0f;
		return simpleinterest;
	}
	
    
}
