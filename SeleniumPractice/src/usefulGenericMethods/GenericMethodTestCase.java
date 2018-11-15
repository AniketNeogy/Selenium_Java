package usefulGenericMethods;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class GenericMethodTestCase {
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		baseUrl="https://letskodeit.teachable.com/p/practice";
		driver = new ChromeDriver();
		gm= new GenericMethods(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	void test() throws InterruptedException {
		
		//Find Element
		gm.GetElement("bmwradio", "id").click();
		Thread.sleep(1000);
		gm.GetElement("//input[@value='benz' and @type='checkbox']", "Xpath").click();
		Thread.sleep(1000);
		gm.GetElement("enter-name", "naMe").sendKeys("Aniket");
		Thread.sleep(1000);
		Select sel = new Select(gm.GetElement("carselect", "ID"));
		Thread.sleep(1000);
		sel.selectByVisibleText("BMW");
		Thread.sleep(1000);
		sel.selectByValue("benz");
		Thread.sleep(1000);
		sel.selectByIndex(2);
		Thread.sleep(1000);
		
		Select Mulsel = new Select(gm.GetElement("multiple-select-example", "name"));
		Thread.sleep(1000);
		Mulsel.selectByIndex(0);
		Thread.sleep(1000);
		Mulsel.selectByValue("peach");
		Thread.sleep(1000);
		Mulsel.selectByVisibleText("Orange");
		Thread.sleep(1000);
		Mulsel.deselectByIndex(1);
		Thread.sleep(1000);
		Mulsel.deselectAll();
		Thread.sleep(1000);
		Mulsel.selectByIndex(2);
		Thread.sleep(1000);
		
		
		//Find Element list
		List<WebElement> elementList= gm.GetElementList("cars", "name");
		for(WebElement e : elementList)
		{
			e.click();
			Thread.sleep(1000);
		}
		
		elementList= gm.GetElementList("//input[@type='checkbox']", "Xpath");
		for(WebElement e : elementList)
		{
			e.click();
			Thread.sleep(1000);
		}
		
		boolean existanceStatus = gm.isElementPresent("//input[@type='checkbox']", "Xpath");
		if(existanceStatus == true) {
			System.out.println("WebElement is present in the webpage");
		}
		else {
			System.out.println("WebElement is not present in the webpage");
		}
		
		
		existanceStatus = gm.isElementPresent("//input[@id='names']", "Xpath");
		if(existanceStatus == true) {
			System.out.println("WebElement is present in the webpage");
		}
		else {
			System.out.println("WebElement is not present in the webpage");
		}
		
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
		Thread.sleep(2000);
	}
}
