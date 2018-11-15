package JavaScriptPractice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;

public class JavaScriptExecution {
	private WebDriver driver;
	String baseUrl;
	private JavascriptExecutor js;
	GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		js = (JavascriptExecutor) driver;
		gm= new GenericMethods(driver);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testJavaScriptExecution() throws Exception {
		// Navigation
		// driver.get(baseUrl);
		js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice';");
		
		// driver.get() method waits for the page to load completely before going to the next statement
		// Adding Thread.sleep() because we are opening URL using js.executeScript() and it does not wait for the page to load completely
		// If we do not add wait, then Selenium WebDriver will immediately try to find the element and it might have issues with just a little slow connection
		Thread.sleep(3000);
		// Finding element
		// WebElement textBox = driver.findElement(By.id("name"));
		WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
		gm.ScrollElementIntoView(driver, textBox);
		gm.highLighterMethod(driver, textBox);
		textBox.sendKeys("test");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}