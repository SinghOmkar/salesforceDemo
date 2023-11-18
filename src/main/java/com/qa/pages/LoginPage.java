package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class LoginPage {
	
	@FindBy(id = "logo") WebElement sfLogo; 
	
	@FindBy(id = "username") WebElement inputUsername; 
	 
	@FindBy(id = "password") WebElement inputPassword;
	 
	@FindBy(id = "Login") WebElement LoginBtn;

	public LoginPage() {
		super();
		PageFactory.initElements(TestBase.driver, this);
	}
	
	public String getPageTitle() {
		return TestBase.driver.getTitle();
	}
	
	public void doLogin() {
		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(inputUsername));
	    
	    String username = (String) TestBase.props.get("username");
	    String password = (String) TestBase.props.get("password");
	    
	    inputUsername.sendKeys(username);
	    inputPassword.sendKeys(password);
	    
	    LoginBtn.click();
	    
	    wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains("Home | Salesforce"));
	}
}
