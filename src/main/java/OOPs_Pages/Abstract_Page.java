package OOPs_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Abstract_Page {

	WebDriver driver;

	WebDriverWait wait;

	// Create Constructor of abstract class

	public Abstract_Page(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}

	// Abstract methods

	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract void waitForPageTitle(String title);

	public abstract void waitForElementPresent(By locator);

	// Creating Object of a particular page class

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {

			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

}
