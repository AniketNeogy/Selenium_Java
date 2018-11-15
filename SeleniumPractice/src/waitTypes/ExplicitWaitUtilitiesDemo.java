package waitTypes;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import usefulGenericMethods.GenericMethods;
import utilities.waitTypes;

class ExplicitWaitUtilitiesDemo {
	WebDriver driver;
	String baseUrl;
	waitTypes wt;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		wt = new waitTypes(driver);
	}


	@Test
	void test() {
		GenericMethods gm= new GenericMethods(driver);
		List<WebElement> element = gm.GetElementList("//a[@href='/sign_in']", "Xpath");
		element.get(0).click();
		WebElement el = wt.waitUntilElementIsVisible(By.id("user_email"), 3);
		el.sendKeys("Aniket");
		

	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
