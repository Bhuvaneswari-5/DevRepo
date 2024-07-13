package com.bhuvana.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bhuvana.service.BankService;

public class AppTest 
{
	 static BankService bs;
	 
	@BeforeAll
    public static  void startup()
    {
    	System.out.println("AppTest.startup()");
    	bs=new BankService();
    }
	
	@BeforeEach
	public void before()
	{
		System.out.println("AppTest.before()");
	}
	
	@Test
	public void testwithbignumbers()
	{
		System.out.println("AppTest.testwithbignumbers()");
		double expected=2400000.00;
		double actual=bs.simpleInterest(10000000.00,2.0,12.0);
		assertEquals(expected,actual,0.1f);
	}
	@Test
	public void testwithsmallnumbers()
	{
		System.out.println("AppTest.testwithbignumbers()");
		double expected=960.00;
		double actual=bs.simpleInterest(4000.00,2.0,12.0);
		assertEquals(expected,actual,0.2f);
	}
	
	@Test
	public void testwithnegativesandzeros()
	{
		assertThrows(IllegalArgumentException.class,()->
		{
			bs.simpleInterest(0, 2.0,12.0);
		});

	}
	
	@Test
	public void testwithtime()
	{
		assertTimeout(Duration.ofMillis(4000),()->
		{
			bs.simpleInterest(10000000.00,2.0,12.0);
		});
	}
	
	@AfterEach
	public void after()
	{
		System.out.println("AppTest.after()");
	}
	@AfterAll
	public static void endup()
	{
		System.out.println("AppTest.endup()");
		bs=null;
	}
}
