package BasicWeb;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class RadioButtonsAndCheckboxes {
	WebDriver driver;
	String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/");
	}


	@Test
	void test() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/pages/practice']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean RBStatus = driver.findElement(By.xpath("//input[@id='bmwradio']")).isDisplayed();
		if(RBStatus == true)
		{
			
			//radiobutton
			System.out.println("First lets check for BMW radio Button");
			if(!driver.findElement(By.xpath("//input[@id='bmwradio']")).isSelected())
			{
				driver.findElement(By.xpath("//input[@id='bmwradio']")).click();
				System.out.println(driver.findElement(By.xpath("//input[@id='bmwradio']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='benzradio']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='hondaradio']")).isSelected());
			}
			
			System.out.println("Second lets check for BENZ radio Button");
			if(!driver.findElement(By.xpath("//input[@id='benzradio']")).isSelected())
			{
				driver.findElement(By.xpath("//input[@id='benzradio']")).click();
				System.out.println(driver.findElement(By.xpath("//input[@id='bmwradio']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='benzradio']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='hondaradio']")).isSelected());
			}
			
			System.out.println("Finally lets check for Honda radio Button");
			if(!driver.findElement(By.xpath("//input[@id='hondaradio']")).isSelected())
			{
				driver.findElement(By.xpath("//input[@id='hondaradio']")).click();
				System.out.println(driver.findElement(By.xpath("//input[@id='bmwradio']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='benzradio']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='hondaradio']")).isSelected());
			}
			
			//check boxes
			
			System.out.println("First lets check for BMW Check Box");
			if(!driver.findElement(By.xpath("//input[@id='bmwcheck']")).isSelected())
			{
				driver.findElement(By.xpath("//input[@id='bmwcheck']")).click();
				System.out.println(driver.findElement(By.xpath("//input[@id='bmwcheck']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='benzcheck']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='hondacheck']")).isSelected());
			}
			
			System.out.println("Second lets check for Benz Check Box");
			if(!driver.findElement(By.xpath("//input[@id='benzcheck']")).isSelected())
			{
				driver.findElement(By.xpath("//input[@id='benzcheck']")).click();
				System.out.println(driver.findElement(By.xpath("//input[@id='bmwcheck']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='benzcheck']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='hondacheck']")).isSelected());
			}
			
			System.out.println("Lastly lets check for Honda Check Box");
			if(!driver.findElement(By.xpath("//input[@id='hondacheck']")).isSelected())
			{
				driver.findElement(By.xpath("//input[@id='hondacheck']")).click();
				System.out.println(driver.findElement(By.xpath("//input[@id='bmwcheck']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='benzcheck']")).isSelected());
				System.out.println(driver.findElement(By.xpath("//input[@id='hondacheck']")).isSelected());
			}
			
			
		}
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}


}
