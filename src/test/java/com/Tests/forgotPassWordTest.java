package com.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OOPs_Pages.ForgotPwdPage;
import OOPs_Pages.LoginPage;

public class forgotPassWordTest extends BaseTest {

	private static Logger logger1=LogManager.getLogger();
	
	@Test(priority =1 , enabled = true)
	public void TC1_ForgotPassword_Test() throws InterruptedException  {
		
        logger1.info("TC1_ForgotPassword_Test is started");
        logger1.info("URL is launched successfully");
    
        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		
		System.out.println("LoginPage title: " + title);
		
		logger1.info("LoginPage title: \""+title+" \"is displayed");
		Assert.assertEquals(title, "Login | Xero Accounting Software");
		
		System.out.println("User is in Login Page");
		
		 ForgotPwdPage forgot = page.getInstance(LoginPage.class).ClickForgotPwd();
		String forgpotPwdTitle = forgot.getForgotPwdPageTitle();
		String forgpotPwdMessage = forgot.getForgotPwdPageMsg();
		System.out.println("ForgotPasswordPage title: " + forgpotPwdTitle);
		System.out.println("ForgotPasswordPage message: " + forgpotPwdMessage);
		
		Assert.assertEquals(forgpotPwdTitle, "Forgotten Password");
		Assert.assertEquals( forgpotPwdMessage , "To reset your password, enter the email address you use to login to Xero. A link will be emailed to this address which will let you reset your password.");
		
		System.out.println("User is in ForgotPassword page");
		logger1.info("ForgotPasswordPage title: \""+forgpotPwdTitle+"\" is displayed");
		
		//Enter email in Email field
		 forgot.ForgotPwd("sarutanush@gmail.com");
		 logger1.info("Email is sent");
		 logger1.info("Test case is passed");

	
	}


}
