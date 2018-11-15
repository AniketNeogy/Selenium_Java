package ScrenshotDemo;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import usefulGenericMethods.GenericMethods;

public class ScreenshotDemo {
	private	WebDriver driver;
	private	String baseUrl;
	GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl="https://www.southwest.com/";
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium-Projects\\Selenium Version\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		gm = new GenericMethods(driver);
	}
	
	@Test
	public void test1() throws InterruptedException {
		gm.GetElement("#trip-type-one-way", "CssSelector").click();
		if(!(driver.findElement(By.cssSelector("#air-date-return")).isEnabled())){
			System.out.println("Return date is disabled");
			gm.GetElement("#air-city-departure", "CssSelector").sendKeys("New");
			WebElement AutoList = gm.waitUntilElementIsVisible(By.cssSelector("#js-menu-wrapper"), 10);
			System.out.println("First List");
			List<WebElement> AutoCompleteList = AutoList.findElements(By.tagName("li"));
			System.out.println("Size of First List is :: "+AutoCompleteList.size());
			for(WebElement element : AutoCompleteList){
				System.out.println(element.getText());
			}
			Thread.sleep(2000);
			
			for(WebElement element : AutoCompleteList){
				if(element.getText().equals("New York/Newark, NJ - EWR")) {
					element.click();
					break;
				}
				
				
			}
			
		}
				
	}
	
	
	@Test
	public void test2() throws InterruptedException {
		gm.GetElement("#trip-type-one-way", "CssSelector").click();
		if(!(driver.findElement(By.cssSelector("#air-date-return")).isEnabled())){
			System.out.println("Return date is disabled");
			gm.GetElement("#air-city-departure", "CssSelector").sendKeys("New");
			WebElement AutoList = gm.waitUntilElementIsVisible(By.cssSelector("#js-menu-wrapper"), 10);
			System.out.println("First List");
			List<WebElement> AutoCompleteList = AutoList.findElements(By.tagName("li"));
			System.out.println("Size of First List is :: "+AutoCompleteList.size());
			for(WebElement element : AutoCompleteList){
				System.out.println(element.getText());
			}
			Thread.sleep(2000);
			
			for(WebElement element : AutoCompleteList){
				if(element.getText().equals("New York/Newark, NJ - EWR")) {
					element.click();
					break;
				}	
			}
			
			gm.GetElement("#air-city-arrival", "CssSelector").click();
			gm.GetElement("#air-city-arrival", "CssSelector").sendKeys("New");
			AutoList = gm.waitUntilElementIsVisible(By.cssSelector("#js-menu-wrapper"), 10);
			System.out.println("Second List");
			AutoCompleteList = AutoList.findElements(By.tagName("li"));
			System.out.println("Size of First List is :: "+AutoCompleteList.size());
			for(WebElement element : AutoCompleteList){
				System.out.println(element.getText());
			}
			Thread.sleep(2000);
			
			for(WebElement element : AutoCompleteList){
				if(element.getText().equals("New York/Newark, NJ - EWR")) {
					element.click();
					break;
				}	
			}
			gm.GetElement("#air-date-departure", "CSSSelector").click();
			gm.waitUntilElementIsReadyToBeClicked(By.xpath("//div[@class='calendar-selector-body']/div[@class='calendar-2 js-calendar-2']//td[@id='calendar-july-1']"), 5);
			
			gm.waitUntilElementIsReadyToBeClicked(By.cssSelector("#jb-booking-form-submit-button"), 5);
			WebElement element = gm.waitUntilElementIsVisible(By.xpath("//span[@class='oopsError_message']"), 10);
			if(!(element.getText().equals("Oops!")))
			{
				fail("Error Panel Not Displayed");
			}
			else
			{
				System.out.println("Error Panel Displayed with Error Massage : "+gm.GetElement("//span[@class='oopsError_message']", "xpath").getText()+" "+gm.GetElement("//span[@class='oopsError_message']/following-sibling::ul", "xpath").getText());
			}
		}
	}

	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		String FileName = gm.getRandomString(10) + ".png";
		String Directory = "D:\\Selenium-Projects\\Screenshots\\";
		TakesScreenshot scrObj = (TakesScreenshot)driver;
		File scrFile = scrObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(Directory + FileName));
		driver.close();
	}


}
