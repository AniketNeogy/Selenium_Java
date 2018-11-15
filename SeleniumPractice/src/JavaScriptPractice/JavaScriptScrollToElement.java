package JavaScriptPractice;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class JavaScriptScrollToElement {
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver,chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		js=(JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	void test() throws InterruptedException {
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice/';");
		Thread.sleep(2000);
		
		//scroll down
		js.executeScript("window.scrollBy(0, 1900);");
		Thread.sleep(2000);
		
		//scroll up
		js.executeScript("window.scrollBy(0,-1900);");
		Thread.sleep(2000);
		
		//Scroll Element into View
		WebElement element = (WebElement) js.executeScript("return document.getElementById('mousehover');");
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(2000);
		//the mouse hover button is scrolled into view at the very top of the page(which is the default position of scrolling into view).
		//However it gets hidden by the NavBar hence the below steps
		js.executeScript("window.scrollBy(0,-200);");
		Thread.sleep(2000);
	}


	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
