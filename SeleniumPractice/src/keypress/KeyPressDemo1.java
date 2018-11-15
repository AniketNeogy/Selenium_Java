package keypress;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPressDemo1 {
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
	public void test1() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
		driver.findElement(By.id("user_email")).sendKeys("test@email.com"+ Keys.TAB + "123123" + Keys.ENTER);
	}
	
	@Test
	public void test2() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
		String allActions= Keys.chord("test@email.com"+ Keys.TAB + "123123" + Keys.ENTER);
		driver.findElement(By.id("user_email")).sendKeys(allActions);
	}
	
	@Test
	public void test3() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
		driver.findElement(By.id("user_email")).sendKeys("test@email.com");
		Thread.sleep(2000);
		driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		//driver.findElement(By.id("user_password")).sendKeys("123123");
		//Thread.sleep(2000);
		//driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
