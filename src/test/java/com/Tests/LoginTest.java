package com.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OOPs_Pages.ForgotPwdPage;
import OOPs_Pages.HomePage;
import OOPs_Pages.LoginPage;

public class LoginTest extends BaseTest {

	private static Logger logger1 = LogManager.getLogger();

	@Test(priority = 1, enabled = true)

	public void TC1_login_With_Valid_Credentials_Test() throws InterruptedException {

		logger1.info("TC1_login_WithValid_Credentials_Test is started");
		logger1.info("URL is launched successfully");

		String title = page.getInstance(LoginPage.class).getLoginPageTitle();

		System.out.println("LoginPage title: " + title);

		logger1.info("LoginPage title: \"" + title + " \"is displayed");
		Assert.assertEquals(title, "Login | Xero Accounting Software");

		System.out.println("User is in Login Page");

		HomePage homePage = page.getInstance(LoginPage.class).doLogin("sarutanush@gmail.com", "India1234");
		String homePageTitle = homePage.getHomePageTitle();

		System.out.println("HomePage Title: " + homePageTitle);
		Assert.assertEquals(homePageTitle, "My Xero | Home");

		System.out.println("Login is successful and user is in HomePage");
		logger1.info("Homepage title: \"" + homePageTitle + "\" is displayed");
		logger1.info("Test case is passed");

	}

	@Test(priority = 2, enabled = true)

	public void TC2_login_With_InValidPassword_Test() throws InterruptedException {

		logger1.info("TC2_login_With_InValidPassword_Test is started");
		logger1.info("URL is launched successfully");

		String title = page.getInstance(LoginPage.class).getLoginPageTitle();

		System.out.println("LoginPage title: " + title);

		logger1.info("LoginPage title: \"" + title + " \" is displayed");
		Assert.assertEquals(title, "Login | Xero Accounting Software");
		logger1.info("User is in Login Page");

		System.out.println("User is in Login Page");

		// Adding invalid password
		page.getInstance(LoginPage.class).doLogin("username:sarutanush@gmail.com");

		String LoginErrorMsg = page.getInstance(LoginPage.class).getErrorMessage();
		System.out.println(LoginErrorMsg);

		Assert.assertEquals(LoginErrorMsg, "Your email or password is incorrect");
		System.out.println("Error message is displayed");
		logger1.info("Error message: \"" + LoginErrorMsg + "\" is displayed");
		logger1.info("Testcase is passed");
	}

	@Test(priority = 3, enabled = true)

	public void TC3_login_With_InValid_Username_Test() throws InterruptedException {

		logger1.info("TC3_login_With_InValid_Username_Test is started");
		logger1.info("URL is launched successfully");

		String title = page.getInstance(LoginPage.class).getLoginPageTitle();

		System.out.println("LoginPage title: " + title);
		logger1.info("LoginPage title: \"" + title + " \" is displayed");

		Assert.assertEquals(title, "Login | Xero Accounting Software");

		logger1.info("User is in login page");

		// Adding invalid username

		page.getInstance(LoginPage.class).doLogin("password:India1234");
		Thread.sleep(2000);
		String ErrorMsg = page.getInstance(LoginPage.class).getErrorMessage();
		System.out.println(ErrorMsg);

		Assert.assertEquals(ErrorMsg, "Your email or password is incorrect");
		System.out.println("Error message is displayed");

		logger1.info("Error message: \"" + ErrorMsg + " \" is displayed");
		logger1.info("Testcase is passed");

	}

}
