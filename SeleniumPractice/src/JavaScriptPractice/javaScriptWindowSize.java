package JavaScriptPractice;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class javaScriptWindowSize {
	private WebDriver driver;
	private JavascriptExecutor js;
	String	baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		js= (JavascriptExecutor) driver;
		baseUrl="https://learn.letskodeit.com/p/practice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	void test() {
		js.executeScript("window.open('https://www.google.co.in/','NewWindow2','width=200','height=100');");
		long WindowHeight = (Long) js.executeScript("return window.innerHeight;");
		long WindowWidth = (Long) js.executeScript("return window.innerWidth;");
		System.out.println("Window Height = "+WindowHeight);
		System.out.println("Window Height = "+WindowWidth);
		driver.switchTo().window("NewWindow2");
		long WindowHeight1 = (Long) js.executeScript("return window.innerHeight;");
		long WindowWidth1 = (Long) js.executeScript("return window.innerWidth;");
		System.out.println("Window Height = "+WindowHeight1);
		System.out.println("Window Height = "+WindowWidth1);
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
