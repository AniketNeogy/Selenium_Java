package waitTypes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;
public class ImplicitWaitDemo {
	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}


	@Test
	public void test() {
		GenericMethods gm= new GenericMethods(driver);
		List<WebElement> element = gm.GetElementList("//a[@href='/sign_in']", "Xpath");
		element.get(0).click();
		gm.GetElement("#user_email", "CssSelector").sendKeys("asdasda");
	}


	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
