package com.qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.Constants;

public class TestBase {
	public static WebDriver driver;
	public static Properties props;
	
	public TestBase() {
		
		try
		{
			FileInputStream configFileInput = new FileInputStream(System.getProperty("user.dir") + Constants.configFilePath);
			
			props = new Properties();
			props.load(configFileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() throws Exception {
		
		String browserName = props.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid Browser!!");
		}
		
		System.out.println(browserName + " browser selected");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(props.getProperty("URL"));
	}
}
