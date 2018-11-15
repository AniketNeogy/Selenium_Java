package SwitchTo;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;

class switchToFrame {
	private WebDriver driver;
	String baseUrl;
	private GenericMethods gm;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		gm = new GenericMethods(driver);
		baseUrl="https://learn.letskodeit.com/p/practice/";
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	void test() throws InterruptedException {
		Thread.sleep(2000);
		//switch To Frame By Index
		//driver.switchTo().frame(0);
		
		//switch To Frame By Id
		//driver.switchTo().frame("courses-iframe");
		
		//switch To Frame By name
		driver.switchTo().frame("iframe-name");
		
		
		WebElement TextBoxframe = gm.GetElement("search-courses", "Id");
		gm.highLighterMethod(driver, TextBoxframe);
		Thread.sleep(2000);
		TextBoxframe.sendKeys("Java");
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement InputTextBox = gm.GetElement("name", "Id");
		gm.ScrollElementIntoView(driver, InputTextBox);
		gm.highLighterMethod(driver, InputTextBox);
		InputTextBox.sendKeys("Test Successful");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
