package com.jetstar.qa.test;

import org.testng.annotations.Test;

import com.jetstar.qa.base.TestBase;

import pages.SelectFlight;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class LoginTest extends TestBase{
	SelectFlight select;
	
  @Test
  public void f() throws InterruptedException {
	  select.signUpCheck();
	  Thread.sleep(3000);
  }
  @BeforeMethod
  public void beforeMethod() {
		initialization();
		select = new SelectFlight();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
