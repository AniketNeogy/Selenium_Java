package ActionsClassDemo;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import usefulGenericMethods.GenericMethods;

class MouseHover {
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		gm= new GenericMethods(driver);
		baseUrl = "https://learn.letskodeit.com/p/practice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	@Test
	//without Using Mouse Hover Action
	void test1() throws InterruptedException {
		WebElement mouseHoverElement = gm.GetElement("mousehover", "id");
		gm.ScrollElementIntoView(driver, mouseHoverElement);
		mouseHoverElement.click();
		Thread.sleep(2000);
		
		gm.waitUntilElementIsReadyToBeClicked(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"), 2);
		
	}
	
	@Test
	//Using Mouse Hover Action
	void test2() throws InterruptedException {
		WebElement mouseHoverElement = gm.GetElement("mousehover", "id");
		gm.ScrollElementIntoView(driver, mouseHoverElement);
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverElement).perform();
		Thread.sleep(2000);
		
		WebElement TopButton = gm.GetElement("//div[@class='mouse-hover-content']//a[text()='Top']", "xpath");
		action.moveToElement(TopButton).click().build().perform();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
