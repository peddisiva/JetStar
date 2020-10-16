package com.jetstar.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	
	public static void initialization() {
			System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
			driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.jetstar.com/nz/en/home");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
