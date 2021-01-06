package OOPs_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Abstract_Page {

	public BasePage(WebDriver driver) {
		super(driver);

	}

	// Implementing all unimplimented methods

	@Override
	public String getPageTitle() {

		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {

		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {

		WebElement element = null;
		try {

			waitForElementPresent(locator);
			element = driver.findElement(locator);

		} catch (Exception e) {
			System.out.println("Some error occured while creating element" + locator.toString());
			e.printStackTrace();

		}

		return element;
	}

	@Override
	public void waitForPageTitle(String title) {

		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Some exceptions occured while waiting for the title" + title);
		}
	}

	@Override
	public void waitForElementPresent(By locator) {

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Some exceptions occured while waiting for the element" + locator.toString());
		}
	}

}
