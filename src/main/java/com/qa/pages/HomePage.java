package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class HomePage {
	@FindBy(xpath = "//*[@id=\"oneHeader\"]/runtime_learning_essentials_welcome-easy-trial-banner/div/div[1]/span")
	WebElement welcomeMsg;
	
	@FindBy(className = "branding-userProfile-button") 	WebElement profilePic;
	
	@FindBy(className = "profile-link-label") WebElement profileMenuName;
	
	@FindBy(className = "logout") WebElement logoutLink;
	
	public HomePage() {
		super();
		PageFactory.initElements(TestBase.driver, this);
	}
	
	public String getWelcomeMsg() {
		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(welcomeMsg));
		
		return welcomeMsg.getText();
	}
	
	public void openProfileMenu() {
		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(profilePic));
		
		profilePic.click();
		
		wait.until(ExpectedConditions.visibilityOf(profileMenuName));
	}
	
	public void logout() {
		openProfileMenu();
		
		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		
		logoutLink.click();
		
		wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Login | Salesforce"));
	}
}

