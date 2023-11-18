package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		
		File ssDirectory = new File(System.getProperty("user.dir") + Constants.screenshotsPath);
		
		FileUtils.cleanDirectory(ssDirectory);
		
		String browserName = props.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid Browser!!");
		}
		
		System.out.println(browserName + " browser selected");
		
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(props.getProperty("URL"));
	}
	
	/**
	 * Capture screenshot
	 * @param methodName name of method where we want to take screenshot
	 * @return path path of screenshot
	 */
	public static String takeScreenshot(String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir")+Constants.screenshotsPath;
		new File(directory).mkdir();
		String path = directory + fileName;
		
		try {
			//Capture screenshot using Selenium webDriver
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(screenshot, new File(path));
	        System.out.println("====================================");
			System.out.println("Screenshot saved at:" + path);
			System.out.println("====================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "./screenshots/" + fileName;
	}
	
	/**
	 * Provide Screenshot name on runtime
	 * @param methodName name of method screenshot taken for
	 * @return name name of screenshot
	 */
	private static String getScreenshotName(String methodName) {
		Date date = new Date();
		String name = methodName + "_"+date.toString().replace(":", "_").replace(" ", "_")+".png";
		return name;
	}
	
	public static String getReportName() {
		String date = new SimpleDateFormat("MMddyyyyhhmm").format(new Date());
		String fileName = date.toString().replace(":", "_").replace(" ", "_")+"Automation_Report.html";
		return fileName;
	}
}
