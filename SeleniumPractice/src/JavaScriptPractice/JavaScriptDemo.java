package JavaScriptPractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;

class JavaScriptDemo {
	private WebDriver driver;
	private JavascriptExecutor js;
	private GenericMethods gm;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		gm = new GenericMethods(driver);
		js= (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	void test() throws InterruptedException {
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice/';");
		WebElement textbox = (WebElement) js.executeScript("return document.getElementById('name');");
		textbox.sendKeys("Aniket");
		String OriginalWindow = driver.getWindowHandle();
		
		//open a new tab and witch to that tab
		js.executeScript("window.open('https://www.expedia.co.in/','NewWindow1');");
		Thread.sleep(2000);
		//driver.switchTo().window("NewWindow1");
		Thread.sleep(5000);
		
		//Open a new browser window using java script
		js.executeScript("window.open('https://www.google.co.in/','NewWindow2','width=200','height=100');");
		Thread.sleep(1000);
		//driver.switchTo().window("NewWindow2");
		driver.manage().window().maximize();
		//driver.close();
		
		driver.switchTo().window("NewWindow1");
		
		Thread.sleep(1000);
		driver.switchTo().window("NewWindow2");
		//driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(OriginalWindow);
		Thread.sleep(1000);
		
		Set<String> WindowHandles = driver.getWindowHandles();
		for(String Windowhandle : WindowHandles )
		{
			System.out.println(Windowhandle);
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		gm.getScreenshot();
		Thread.sleep(2000);
		driver.quit();
	}

}
