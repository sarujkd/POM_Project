package OOPs_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	//Declaring Login page locators as private to achieve Encapsulation
	
	private By emailId=By.xpath("//*[@name='userName']"); 
	private By passWord=By.xpath("//input[@id='password']");
	private By loginBtn=By.id("submitButton");
	private By header=By.xpath("//h1[@class='login-info-title login-info-title-small title title-1']");
	private By error_msg=By.xpath("(//div//ul)[1]");
	private By forgotPassword=By.xpath("//a[@class='forgot-password-advert']");
	
	//LogiPage Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}

	
	/**
	 * @return the passWord
	 */
	public WebElement getPassWord() {
		return getElement(passWord);
	}

		/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		
		return getElement(loginBtn);
	}

		/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public WebElement getError_msg() {
		return getElement(error_msg);
	}

	public String getEmailidFromTextField() {
		return getEmailId().getText();
	}

	public String getPassWordFromTextField() {
		return getPassWord().getText();
	}

	public String getLoginPageTitle() {
		return getPageTitle();
		
	}
	
	public String getLoginPageHeader() {
		return getPageHeader(header);
		
	}

	public String getErrorMessage() {
		return  getError_msg().getText();
		
	}
	
	public WebElement getForgotPwd() {
		return getElement(forgotPassword);
	}

	public ForgotPwdPage ClickForgotPwd() {
		  getForgotPwd().click() ;
		return getInstance(ForgotPwdPage.class);
	}
	
	//Method Overloading
	
	public HomePage doLogin(String userName, String passWord)  {
		
		 getEmailId().sendKeys(userName);
		 getPassWord().sendKeys(passWord);
		 getLoginBtn().click();
		 
		 return getInstance(HomePage.class);
		 
	}
	
	public void doLogin() {
		
		 getEmailId().sendKeys("");
		 getPassWord().sendKeys("");
		 getLoginBtn().click();
		 
	
	}
	
	//username: sams@gmail.com
	public void doLogin(String userCred) {
		
		if(userCred.contains("username")) {
		 getEmailId().sendKeys(userCred.split(":")[1].trim());
		}
		else
		{
			if(userCred.contains("password")) {
				 getPassWord().sendKeys(userCred.split(":")[1].trim());
				}
				
		}
		 getLoginBtn().click();
		 
	
	}
	
	
}
