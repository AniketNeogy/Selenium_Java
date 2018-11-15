package BasicWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTestDemo {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void test() {
		String radioButtonHeader = driver.findElement(By.cssSelector("#radio-btn-example>fieldset>legend")).getText();
		System.out.println("The name of radio button Header is : "+radioButtonHeader);
		
		String radioButtonName = driver.findElement(By.xpath("//input[@id='bmwradio']/parent::label")).getText();
		System.out.println("The name of radio button is : "+radioButtonName);
		
		String SelectDropdownHeader = driver.findElement(By.xpath("//select[@id='carselect']/preceding-sibling::legend")).getText();
		System.out.println("The name of Dropdown Header is : "+SelectDropdownHeader);
		
		String SelectDropdown = driver.findElement(By.xpath("//select[@id='carselect']")).getText();
		System.out.println("The dropdown list is : "+SelectDropdown);
		
		String checkBoxHeader = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/legend")).getText();
		System.out.println("The name of checkbox Header  is : "+checkBoxHeader);
		
		String checkBox = driver.findElement(By.cssSelector("#checkbox-example>fieldset>label[for='bmw']")).getText();
		System.out.println("The name of checkbox is : "+checkBox);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("fuyfyufyu");
		String TextBox = driver.findElement(By.xpath("//input[@id='name']")).getText();
		System.out.println("The name of Textbox is : "+TextBox);
		
		TextBox = driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value");
		System.out.println("The name of Textbox is : "+TextBox);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
