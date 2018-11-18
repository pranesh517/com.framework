package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.commonutils.LaunchBrowser;
import com.contants.RegistrationPageConstants;
import com.pages.LoginPage;
import com.pages.RegistrationLoginDataProvider;
import com.pages.RegistrationPage;

public class RegistrationTest extends LaunchBrowser {
	WebDriver driver;
	
	@Test(dataProvider = "TC001", dataProviderClass = RegistrationLoginDataProvider.class)
	public void TC001(String emailID) throws IOException {
		driver = launchBrowser();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterValueInEmailIDTextField(emailID);
		RegistrationPage registrationPage = loginPage.clickOnLoginButton();
		registrationPage.enterValueInFirstNameTextField();
		registrationPage.enterValueInLastNameTextField();
	}
	
	@Test(dataProvider = "TC001", dataProviderClass = RegistrationLoginDataProvider.class)
	public void TC002(String emailID) throws IOException{
		driver = launchBrowser();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterValueInEmailIDTextField(emailID);
		RegistrationPage registrationPage = loginPage.clickOnLoginButton();
		String pageTitle = registrationPage.getRegistrationPageTitle();
		Assert.assertEquals(pageTitle, RegistrationPageConstants.REGISTRATION_PAGE_TITLE);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}

}
