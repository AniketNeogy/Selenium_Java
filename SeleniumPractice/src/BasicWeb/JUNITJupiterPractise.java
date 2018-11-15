package BasicWeb;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class JUNITJupiterPractise {
	WebDriver driver;
	String baseurl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Suite Setup");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Test Setup");
		driver=new ChromeDriver();
		baseurl="https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
	}

	@Test
	void test1() {
		System.out.println("Test1");
		driver.get(baseurl);
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("user_email")).sendKeys("aniket.neogy@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("Biswa1992");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_password")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("user_email")).sendKeys("ajoy.neogy@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("Anik1992");
	}
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("End Test");
		driver.close();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Teardown");
	}
}
