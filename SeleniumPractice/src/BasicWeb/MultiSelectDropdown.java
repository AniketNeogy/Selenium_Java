package BasicWeb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdown {
	WebDriver driver = new ChromeDriver();
	String baseUrl = "https://letskodeit.teachable.com";
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/pages/practice']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement Dropdown = driver.findElement(By.id("multiple-select-example"));
		Thread.sleep(2000);
		Select select = new Select(Dropdown);
		
		System.out.println("Select Orange by index");
		select.selectByIndex(1);
		Thread.sleep(2000);
		
		System.out.println("Select Apple by value");
		select.selectByValue("apple");
		Thread.sleep(2000);
		
		System.out.println("Select Peach by Visible Text");
		select.selectByVisibleText("Peach");
		Thread.sleep(2000);
		
		List<WebElement> elementlist = select.getAllSelectedOptions();
		int ElementListsize = elementlist.size();
		System.out.println("Get All Selected Options :");
		for (int i = 0; i < ElementListsize; i++) {
			System.out.println(elementlist.get(i).getText());
		}
		
		System.out.println("Deselect Peach By Visible text");
		select.deselectByVisibleText("Peach");
		Thread.sleep(2000);
		
		elementlist = select.getAllSelectedOptions();
		ElementListsize = elementlist.size();
		System.out.println("Get All Selected Options :");
		for (int i = 0; i < ElementListsize; i++) {
			System.out.println(elementlist.get(i).getText());
		}
		
		System.out.println("Select Peach by Index");
		select.selectByIndex(2);
		Thread.sleep(2000);
		
		elementlist = select.getAllSelectedOptions();
		ElementListsize = elementlist.size();
		System.out.println("Get All Selected Options :");
		for (int i = 0; i < ElementListsize; i++) {
			System.out.println(elementlist.get(i).getText());
		}
		
		System.out.println("Deselect By Index");
		select.deselectByIndex(0);
		Thread.sleep(2000);
		
		elementlist = select.getAllSelectedOptions();
		ElementListsize = elementlist.size();
		System.out.println("Get All Selected Options :");
		for (int i = 0; i < ElementListsize; i++) {
			System.out.println(elementlist.get(i).getText());
		}
		
		System.out.println("Select Apple by Visible Text");
		select.selectByVisibleText("Apple");
		Thread.sleep(2000);
		
		elementlist = select.getAllSelectedOptions();
		ElementListsize = elementlist.size();
		System.out.println("Get All Selected Options :");
		for (int i = 0; i < ElementListsize; i++) {
			System.out.println(elementlist.get(i).getText());
		}
		
		System.out.println("Deselect By Value");
		select.deselectByValue("orange");
		Thread.sleep(2000);
		
		elementlist = select.getAllSelectedOptions();
		ElementListsize = elementlist.size();
		System.out.println("Get All Selected Options :");
		for (int i = 0; i < ElementListsize; i++) {
			System.out.println(elementlist.get(i).getText());
		}
		
		System.out.println("Select Orange by Visible Text");
		select.selectByVisibleText("Orange");
		Thread.sleep(2000);
		
		elementlist = select.getAllSelectedOptions();
		ElementListsize = elementlist.size();
		System.out.println("Get All Selected Options :");
		for (int i = 0; i < ElementListsize; i++) {
			System.out.println(elementlist.get(i).getText());
		}
		
		System.out.println("Deselect All");
		select.deselectAll();
		Thread.sleep(2000);
		elementlist = select.getAllSelectedOptions();
		ElementListsize = elementlist.size();
		System.out.println("ElementListsize is :"+ElementListsize);
		if(ElementListsize > 0){
			System.out.println("Get All Selected Options :");
			for (int i = 0; i < ElementListsize; i++) {
				System.out.println(elementlist.get(i).getText());
			}
		}
		else{
			System.out.println("All Options are deselected !");
		}
		
		List<WebElement> elList = select.getOptions();
		System.out.println("\nThe Options Present in the dropdown are :");
		int ListSize= elList.size();
		for (int i = 0; i < ListSize; i++) {
			System.out.println(elList.get(i).getText());
		}
		
	}
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
