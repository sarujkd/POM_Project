package OOPs_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPwdPage extends BasePage{

	public ForgotPwdPage(WebDriver driver) {
		super(driver);
	}

	private By emailField = By.id("UserName");
	private By ContinueBtn = By.xpath("//span[contains(text(),'Send link')]");
	private By ForgotPageMessage= By.xpath("//h2[contains(text(),'Forgotten your password?')]//following::p[1]");
	// public method to access private field

	public WebElement getEmailElement() {
		return getElement(emailField);
	}

	public WebElement getContinueElement() {
		return getElement(ContinueBtn);
	}

	public WebElement getForgotPageMessageElement() {
		return getElement(ForgotPageMessage);
	}

	// ForgotPage Actions

	public String getForgotPwdPageTitle() {
		return getPageTitle();
	}
	
	public void ForgotPwd(String email) throws InterruptedException {
		getEmailElement().sendKeys(email); 
	    Thread.sleep(2000);
		getContinueElement().click();
	}

	public String getForgotPwdPageMsg() {
		return  getForgotPageMessageElement().getText();
	}
	
}
