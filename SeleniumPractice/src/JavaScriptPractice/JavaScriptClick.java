package JavaScriptPractice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptClick {
	private WebDriver driver;
	private JavascriptExecutor js;
	String baseUrl;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		js=(JavascriptExecutor) driver;
		baseUrl="https://www.retailmenot.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Log In / Sign up']")).click();
		Thread.sleep(2000);
		//gives Element Not Visible Exception or Element Not Interactable Exception
		//driver.findElement(By.cssSelector("#subscribe")).click();
		WebElement checkbox = driver.findElement(By.cssSelector("#subscribe"));
		System.out.println("Is Checkbox Displayed : "+checkbox.isDisplayed());
		System.out.println("Is Checkbox Enabled :"+checkbox.isEnabled());
		System.out.println("Is Checkbox Selected :"+checkbox.isSelected());
		//java script performs forceful click
		js.executeScript("arguments[0].click();", checkbox);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	

}
