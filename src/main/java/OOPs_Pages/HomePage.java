package OOPs_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	// HomePage private locators

	private By home_Header = By.xpath("//span[contains(text(),'You’re on a free 30-day trial that includes all features.')]");
	private By profile=By.xpath("//img[@class='xnav-avatar']");
	private By logout=By.xpath("(//a[contains(text(),'Log out')])[1]");	
	private By logout1=By.xpath("//button[@name='button']");
	
	public HomePage(WebDriver driver) {
		super(driver);

	}

	// public method to access private field

	public WebElement getHeaderElement() {
		return getElement(home_Header);
	}

	public WebElement getLogoutElement() {
		return getElement(logout);
	}

	public WebElement getProfileElement() {
		return getElement(profile);
	}

	public WebElement getlogut1Element() {
		return getElement(logout1);
	}

	// Homepage Actions

	public String getHomePageTitle() {

		return getPageTitle();
	}

	public String getHomePageHeader() {

		return getPageHeader(home_Header);
	}
	
	public void getLogout() {		
		 getProfileElement().click();
		 getLogoutElement().click();
		 getlogut1Element().click();
		
	}

}
