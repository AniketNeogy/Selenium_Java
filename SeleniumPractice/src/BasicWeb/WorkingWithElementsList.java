package BasicWeb;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class WorkingWithElementsList {
	WebDriver driver;
	String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com";
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	void test() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/pages/practice']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//For all radio buttons and check boxes
		java.util.List<WebElement> RBCB= driver.findElements(By.xpath("//input[@name='cars']"));
		int ListSize = RBCB.size();
		System.out.println(ListSize);
		for (int i = 0; i < ListSize; i++) {
			System.out.println(RBCB.get(i).isSelected());
			RBCB.get(i).click();
			System.out.println(RBCB.get(i).isSelected());
		}
		
		//For all radio buttons Only
		java.util.List<WebElement> RB= driver.findElements(By.xpath("//input[@name='cars' and @type='radio']"));
		for (WebElement e : RB) {
			System.out.println("Is the radio button selected : "+e.isSelected());
			e.click();
			System.out.println("Is the radio button selected : "+e.isSelected());
		}
		
		//For all Check Boxes Only
		java.util.List<WebElement> CB= driver.findElements(By.xpath("//input[@name='cars' and @type='checkbox']"));
		for (Iterator<WebElement> iterator = CB.iterator(); iterator.hasNext();) {
			WebElement element = iterator.next();
			System.out.println("Is the checkbox selected : "+element.isSelected());
			element.click();
			System.out.println("Is the checkbox selected : "+element.isSelected());
		}
				
				
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
