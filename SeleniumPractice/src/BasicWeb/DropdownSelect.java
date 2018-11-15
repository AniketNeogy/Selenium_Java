package BasicWeb;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class DropdownSelect {
	WebDriver driver = new ChromeDriver();
	String baseUrl = "https://letskodeit.teachable.com";
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	void test() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/pages/practice']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement Dropdown = driver.findElement(By.id("carselect"));
		Thread.sleep(2000);
		Select select = new Select(Dropdown);

		System.out.println("Before Selection : "+select.getAllSelectedOptions().get(0).getText());
		System.out.println("Select Benz by index");
		select.selectByIndex(1);
		System.out.println("After Selection : "+select.getAllSelectedOptions().get(0).getText());
		Thread.sleep(2000);
		
		System.out.println("Before Selection : "+select.getAllSelectedOptions().get(0).getText());
		System.out.println("Select BMW by value");
		select.selectByValue("bmw");
		System.out.println("After Selection : "+select.getAllSelectedOptions().get(0).getText());
		Thread.sleep(2000);
		
		System.out.println("Before Selection : "+select.getAllSelectedOptions().get(0).getText());
		System.out.println("Select Honda by Visible Text");
		select.selectByVisibleText("Honda");
		System.out.println("After Selection : "+select.getAllSelectedOptions().get(0).getText());
		Thread.sleep(2000);
		
		//System.out.println("Before Selection : "+select.getAllSelectedOptions().get(0).getText());
		//System.out.println("Deselect All");
		//************select.deselectAll();  -- gives error as not possible for single select dropdown
		//************select.deselectByVisibleText("Honda");  -- gives error deselect only works for a multi-select
		//System.out.println("After Selection : "+select.getAllSelectedOptions().get(0).getText());
		//Thread.sleep(2000);
		
		List<WebElement> elementList = select.getOptions();
		System.out.println("\nThe Options Present in the dropdown are :");
		int ListSize= elementList.size();
		for (int i = 0; i < ListSize; i++) {
			System.out.println(elementList.get(i).getText());
			
		}
		Thread.sleep(2000);
		
		
	
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
