package BasicWeb;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUNITPractice {
	
	WebDriver driver;
	String baseurl;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println("Suite Setup");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
	}
	
	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Test Setup");
		driver=new ChromeDriver();
		baseurl="https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
	}

	@Test
	public void test() 
	{
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

	@After
	public void tearDown() throws Exception 
	{
		System.out.println("End Test");
		driver.close();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		System.out.println("Teardown");
	}

}
