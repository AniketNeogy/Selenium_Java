package waitTypes;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import usefulGenericMethods.GenericMethods;

class ExplicitWaitDemo {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
	}


	@Test
	void test() {
		GenericMethods gm= new GenericMethods(driver);
		List<WebElement> element = gm.GetElementList("//a[@href='/sign_in']", "Xpath");
		element.get(0).click();
		WebDriverWait wait= new WebDriverWait(driver, 3);
		WebElement el = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		el.sendKeys("Aniket");

	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
