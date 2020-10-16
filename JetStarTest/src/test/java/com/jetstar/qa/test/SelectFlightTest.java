package com.jetstar.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jetstar.qa.base.TestBase;

import pages.SelectFlight;

public class SelectFlightTest extends TestBase {
	SelectFlight select;
	
	@BeforeMethod
	public void getUrl() {
		initialization();
		select = new SelectFlight();
	}
	
	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}
	
	@Test
	public void selectFlight() throws InterruptedException {
		select.selectTripType();
//		select.selectFrom();
//		select.selectTo();
//		select.selectDate();
//		Thread.sleep(2000);
//		select.selectFlight();
//		Thread.sleep(3000);
	}

}
