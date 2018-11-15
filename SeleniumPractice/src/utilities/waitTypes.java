package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitTypes {
	WebDriver driver;
	
	public waitTypes(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement waitUntilElementIsVisible(By locator, int timeout)
	{
		WebElement element = null; 
		try {
			System.out.println("Waiting for max "+timeout+" for the element to be visible");
			WebDriverWait wt = new WebDriverWait(driver, timeout);
			element = wt.until(
					ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element is visible in the webpage");
			
		}catch (Exception e) {
			System.out.println("Element is not visible in the webpage");
		}
		return element;
	}
	
	
	public void waitUntilElementIsReadyToBeClicked(By locator, int timeout)
	{
		WebElement element = null;
		try {
			System.out.println("Waiting for max "+timeout+" for the element to be clickable");
			WebDriverWait wt =new WebDriverWait(driver, timeout);
			element = wt.until(ExpectedConditions.elementToBeClickable(locator));
			System.out.println("Element is clickable");
			element.click();
		}catch (Exception e) {
			System.out.println("Element is not clickable");
		}
	}
}
