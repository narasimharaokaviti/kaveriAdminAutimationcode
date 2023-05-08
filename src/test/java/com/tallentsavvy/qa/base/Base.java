package com.tallentsavvy.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jayway.jsonpath.JsonPath;
import com.tallentsavvy.qa.utils.Utilities;

public class Base {

	public 	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public Base() {

		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tallentsavvy\\qa\\config\\config.properties");

		try {

			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);

		}catch (Throwable e) {
			e.printStackTrace();
		}


		dataprop = new Properties();
		File datapropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tallentsavvy\\qa\\testdata\\testdata.properties");

		try {
			FileInputStream datafis = new FileInputStream(datapropfile);
			dataprop.load(datafis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String BrowserName) {



		if (BrowserName.equals("Chrome")) {

			//driver = new EdgeDriver();
			
			/*
			 * EdgeOptions option=new EdgeOptions ();
			 * option.addArguments("--remote-allow-origins=*"); driver = new
			 * EdgeDriver(option );
			 */
			 
			
			  ChromeOptions options=new ChromeOptions();
			  options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
			  driver = new ChromeDriver(options);
			 
		}else if (BrowserName.equals("Firefox")) {

			driver = new FirefoxDriver();
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));

		return driver;

	}
	

}
