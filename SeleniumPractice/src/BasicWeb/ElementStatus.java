package BasicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ElementStatus {
	WebDriver driver;
	String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		baseUrl="https://www.google.co.in" ;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(baseUrl);
	}

	@Test
	void test() throws InterruptedException {
		System.out.println("First input Xpath");
		Boolean ElementEnableStatus = false;
		ElementEnableStatus = driver.findElement(By.xpath("//input[@id='lst-ib']")).isEnabled();
		System.out.println(ElementEnableStatus);
		Boolean ElementVisibleStatus = false;
		ElementVisibleStatus = driver.findElement(By.xpath("//input[@id='lst-ib']")).isDisplayed();
		System.out.println(ElementVisibleStatus);
		if(ElementEnableStatus == true && ElementVisibleStatus == true)
		{
			driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("aniket");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='lst-ib']")).clear();
			Thread.sleep(2000);
		}
		
		System.out.println("Second input Xpath");
		ElementEnableStatus = true;
		ElementEnableStatus = driver.findElement(By.xpath("//input[@id='gs_taif0']")).isEnabled();
		System.out.println(ElementEnableStatus);
		ElementVisibleStatus = true;
		ElementVisibleStatus = driver.findElement(By.xpath("//input[@id='gs_taif0']")).isDisplayed();
		System.out.println(ElementVisibleStatus);
		if(ElementEnableStatus == true && ElementVisibleStatus == true)
		{	driver.findElement(By.xpath("//input[@id='gs_taif0']")).sendKeys("Rohan");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='gs_taif0']")).clear();
			Thread.sleep(2000);
		}
		
		System.out.println("Third input Xpath");
		ElementEnableStatus = true;
		ElementEnableStatus = driver.findElement(By.xpath("//input[@id='gs_htif0']")).isEnabled();
		System.out.println(ElementEnableStatus);
		ElementVisibleStatus = true;
		ElementVisibleStatus = driver.findElement(By.xpath("//input[@id='gs_htif0']")).isDisplayed();
		System.out.println(ElementVisibleStatus);
		if(ElementEnableStatus == true && ElementVisibleStatus == true)
		{	driver.findElement(By.xpath("//input[@id='gs_htif0']")).sendKeys("Sunil");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='gs_htif0']")).clear();
			Thread.sleep(2000);
		}
		
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
