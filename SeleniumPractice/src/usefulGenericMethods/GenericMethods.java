package usefulGenericMethods;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	WebDriver driver;
	
	//parameterized constructor -- #Constructor cannot have a return type
	public GenericMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Find Element
	public WebElement GetElement(String Locator, String Type)
	{
		WebElement element;
		String type = Type.toLowerCase();
		if(type.equals("id")){
			System.out.println("Found WebElement using id :"+Locator);
			element = driver.findElement(By.id(Locator));
			return element;
		}
		else if(type.equals("name")){
			System.out.println("Found WebElement using name :"+Locator);
			element = driver.findElement(By.name(Locator));
			return element;
		}
		else if(type.equals("xpath")){
			System.out.println("Found WebElement using Xpath :"+Locator);
			element = driver.findElement(By.xpath(Locator));
			return element;
		}
		else if(type.equals("cssselector")){
			System.out.println("Found WebElement using cssSelector :"+Locator);
			element = driver.findElement(By.cssSelector(Locator));
			return element;
		}
		else if(type.equals("linkedtest")){
			System.out.println("Found WebElement using Linked text :"+Locator);
			element = driver.findElement(By.linkText(Locator));
			return element;
		}
		else if(type.equals("partiallinkedtest")){
			System.out.println("Found WebElement using partial Linked text :"+Locator);
			element = driver.findElement(By.partialLinkText(Locator));
			return element;
		}
		else if(type.equals("tagname")){
			System.out.println("Found WebElement using Tag Name :"+Locator);
			element = driver.findElement(By.tagName(Locator));
			return element;
		}
		else if(type.equals("ClassName")){
			System.out.println("Found WebElement using Class Name :"+Locator);
			element = driver.findElement(By.className(Locator));
			return element;
		}
		else{
			System.out.println("Locator Type not supported");
			return null;
		}
	}
	
	//Find Element list
	public List<WebElement> GetElementList(String Locator, String Type)
	{
		List<WebElement> elementList;
		String type = Type.toLowerCase();
		if(type.equals("id")){
			elementList = driver.findElements(By.id(Locator));
		}
		else if(type.equals("name")){
			elementList = driver.findElements(By.name(Locator));
		}
		else if(type.equals("xpath")){
			elementList = driver.findElements(By.xpath(Locator));
		}
		else if(type.equals("cssselector")){
			elementList = driver.findElements(By.cssSelector(Locator));
		}
		else if(type.equals("linkedtest")){
			elementList = driver.findElements(By.linkText(Locator));
		}
		else if(type.equals("partiallinkedtest")){
			elementList = driver.findElements(By.partialLinkText(Locator));
		}
		else if(type.equals("tagname")){
			elementList = driver.findElements(By.tagName(Locator));
		}
		else if(type.equals("ClassName")){
			elementList = driver.findElements(By.className(Locator));
		}
		else{
			System.out.println("Locator Type not supported");
			return null;
		}
		
		if (elementList.isEmpty()){
			System.out.println("Element not found with "+type+" and locator :"+Locator);
		}
		else{
			System.out.println("Element found with "+type+" and locator :"+Locator);
		}
		return elementList;
	}
	
	public boolean isElementPresent(String Locator, String Type)
	{
		List<WebElement> elementList = GetElementList(Locator, Type);
		int listSize = elementList.size();
		if(listSize > 0)
		{
			return true;
		}
		return false;
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
	
	public String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			System.out.println(index);
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	public void getScreenshot() throws IOException
	{
		StringBuilder screenshotName= new StringBuilder();
		String Charseq="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		
		int index = (int) (Math.random() * Charseq.length());
		for (int i = 0; i < 10; i++) {
			screenshotName = screenshotName.append(Charseq.charAt(index));
		}
		
		String Directory = "D:\\Selenium-Projects\\Screenshots\\";
		String FileName = screenshotName+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(Directory + FileName));
		
	}
	
	public void highLighterMethod(WebDriver driver, WebElement element){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		 //un comment the below line to unhighlight the element once highlighted
		 //js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');",element);
	}
	
	public void ScrollElementIntoView(WebDriver driver, WebElement element){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);",element);
		 js.executeScript("window.scrollBy(0, -200);");
	}
	

}
