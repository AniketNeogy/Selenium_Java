package AlertPractice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;

public class alertDemo {
	private WebDriver driver;
	private GenericMethods gm;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		gm= new GenericMethods(driver);
		baseUrl = "https://learn.letskodeit.com/p/practice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws InterruptedException {
		WebElement textbox = gm.GetElement("name", "Id");
		gm.highLighterMethod(driver, textbox);
		textbox.sendKeys("Aniket");
		Thread.sleep(1000);
		gm.GetElement("alertbtn","id").click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement displayedText = gm.GetElement("displayed-text", "id");
		gm.highLighterMethod(driver, displayedText);
		displayedText.sendKeys("Test Successful");
	}
	
	@Test
	public void test2() throws InterruptedException {
		WebElement textbox = gm.GetElement("name", "Id");
		gm.highLighterMethod(driver, textbox);
		textbox.sendKeys("Aniket");
		Thread.sleep(1000);
		gm.GetElement("confirmbtn","id").click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement displayedText = gm.GetElement("displayed-text", "id");
		gm.highLighterMethod(driver, displayedText);
		displayedText.sendKeys("Test Successful");
	}
	
	@Test
	public void test3() throws InterruptedException {
		WebElement textbox = gm.GetElement("name", "Id");
		gm.highLighterMethod(driver, textbox);
		textbox.sendKeys("Aniket");
		Thread.sleep(1000);
		gm.GetElement("confirmbtn","id").click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		WebElement displayedText = gm.GetElement("displayed-text", "id");
		gm.highLighterMethod(driver, displayedText);
		displayedText.sendKeys("Test Successful");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
