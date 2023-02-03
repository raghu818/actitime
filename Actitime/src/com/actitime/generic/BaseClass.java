package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	@BeforeClass 
	public void openBrowser1()
	{
		Reporter.log("openbrowser", true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("closebrowser", true);
		driver.close();
	}
	@BeforeMethod
	public void logoin()
	{
		Reporter.log("login", true);
		driver.get("https://demo.actitime.com/");
		LoginPage l= new LoginPage(driver);
		l.setLogin("admin", "manager");
		}
	
	@AfterMethod
	public void logout(){
		Reporter.log("logout", true);
		HomePage h= new HomePage(driver);
		h.setLogOut();
		
	}
	}
