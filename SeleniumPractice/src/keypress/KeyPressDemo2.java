package keypress;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPressDemo2 {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testKeyPress1() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a");
	}
	
	@Test
	public void testKeyPress2() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	}
	
	@Test
	public void testKeyPress3() throws Exception {
		driver.get(baseUrl);
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		Thread.sleep(4000);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
