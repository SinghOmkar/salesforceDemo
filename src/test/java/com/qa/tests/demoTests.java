package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class demoTests extends TestBase {
	
	public LoginPage loginPage;
	public HomePage homePage;
	
	public demoTests () {
		super();
	}
	
	@BeforeClass
	public void setup() throws Exception {
		initialize();
		
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void Login() {
		loginPage.doLogin();
		
		Assert.assertEquals(homePage.getWelcomeMsg(), "Welcome, Jonn Smith");
	}
	
//	@Test(priority = 2)
//	public void Logout() {
//		homePage.logout();
//		
//		Assert.assertEquals(loginPage.getPageTitle(), "Login | Salesforce");
//	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
