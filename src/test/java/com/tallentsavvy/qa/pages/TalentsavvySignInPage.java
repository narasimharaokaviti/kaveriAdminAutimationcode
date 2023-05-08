package com.tallentsavvy.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalentsavvySignInPage {
	
	WebDriver driver;
	
	public TalentsavvySignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='dropdown-toggle btn btn-secondary']")
	private WebElement signin_button;
	
	@FindBy(xpath="//span[text()='Sign in using Popup']")
	private WebElement Sign_in_using_Popup;
	
	@FindBy(xpath="//input[@id='i0116']")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	private WebElement nextbutton;
	
	@FindBy(xpath="//input[@id='i0118']")
	private WebElement Password;
	
	@FindBy(xpath="//*[@id='idSIButton9']")
	private WebElement signinbutton;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	private WebElement yesbutton;
	
	@FindBy(xpath="//li[@class='ant-menu-overflow-item ant-menu-item ant-menu-item-active ant-menu-item-only-child']")
	private WebElement profile;
	
	@FindBy(xpath="//div[text()='Ritambra Yadav']")
	private WebElement username;
	
	
	
	@FindBy(xpath="//button[text()='Sign in using Redirect']")
	private WebElement Sign_in_using_Redirect;
	
	@FindBy(xpath="//center[text()='Welcome to the TalentSavvy ']")
	private WebElement welcomeText;
	
	public void clickOnSignInButton() {
		signin_button.click();
	}
	
	public void ClickOnSignInPop() {
		Sign_in_using_Popup.click();
	}
	
	public void enterEmailId(String email) {
		emailId.sendKeys(email);
	}
	public void clickOnNextButton() {
		nextbutton.click();
	}
	public void enterPassword(String password) {
		Password.sendKeys(password);
	}
	 public void clickOnSigninButton() {
		 signinbutton.click();
	 }
	 public void clickOnYesButton() {
		 yesbutton.click();
	 }
	 public void clickOnProfile() {
		 profile.click();
	 }
	 public void isProfileNameDisplayed() {
		 username.getText();
	 }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		public void clickOnSignInUsingRedirectPop() {
		Sign_in_using_Redirect.click();
	}
	
	public String isWelcomeTextDisplayed() {
	String Welcometext=welcomeText.getText();
	return Welcometext;
	}
	


}
