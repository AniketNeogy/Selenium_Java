package BasicWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {
	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");	
		baseUrl="https://letskodeit.teachable.com/p/practice";
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void test() {
		WebElement element = driver.findElement(By.xpath("//input[@id='name']"));
		
		String TextBox = element.getAttribute("id");
		System.out.println("The id of Textbox is : "+TextBox);
		
		TextBox = element.getAttribute("name");
		System.out.println("The name of Textbox is : "+TextBox);
		
		TextBox = element.getAttribute("placeholder");
		System.out.println("The placeholder of Textbox is : "+TextBox);
		
		TextBox = element.getAttribute("type");
		System.out.println("The type of Textbox is : "+TextBox);
		
		element.sendKeys("fuyfyufyu");
		TextBox = element.getAttribute("value");
		System.out.println("The value of Textbox is : "+TextBox);
	}
	

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
