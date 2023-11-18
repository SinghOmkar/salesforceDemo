package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class salesforce {

	public void login() {
		WebElement inputUsername = TestBase.driver.findElement(By.id("username"));
		inputUsername.sendKeys(TestBase.props.getProperty("username"));
	}
}
