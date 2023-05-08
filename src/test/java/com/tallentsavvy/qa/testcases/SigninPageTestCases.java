package com.tallentsavvy.qa.testcases;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.tallentsavvy.qa.base.Base;
import com.tallentsavvy.qa.pages.TalentsavvySignInPage;
import com.tallentsavvy.qa.utils.Utilities;

public class SigninPageTestCases extends Base{
	
	public SigninPageTestCases () {
		super();
	}
public static	 WebDriver driver;
TalentsavvySignInPage page;
	
	@BeforeMethod
	public void setup()  {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test(priority=1, enabled =true)
	public void verifyLoginFunctionality() throws InterruptedException, IOException  {
		
		adminLogin();


		
		 page= new TalentsavvySignInPage(driver);
		 page.clickOnProfile();
		
		
	}
	
	
	public void adminLogin() throws InterruptedException {
		TalentsavvySignInPage page= new TalentsavvySignInPage(driver);
		  Thread.sleep(3000);
		  String parent_Window = driver.getWindowHandle();
		  page.ClickOnSignInPop();
			// Get all the window handles
			Set<String> windowIterator = driver.getWindowHandles();
			// Create Child window variable
			String Child_Window = null;
			for (String Window : windowIterator) {
				// If check to verify currently taken window is not a parent window
				if (!parent_Window.equals(Window)) {
					// Get the Child window id
					Child_Window = Window;
				}
			}

			// Switch to Child window
			if (Child_Window != null) {
				driver.switchTo().window(Child_Window);
			}
			 page.enterEmailId(prop.getProperty("emailid"));
			 page.clickOnNextButton();
			 page.enterPassword(prop.getProperty("password"));
			 Thread.sleep(3000);
			 page.clickOnSigninButton();
			 page.clickOnYesButton();
			 driver.manage().window().maximize();
	}
	}
