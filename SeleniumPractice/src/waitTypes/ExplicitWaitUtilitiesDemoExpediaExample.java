package waitTypes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;

class ExplicitWaitUtilitiesDemoExpediaExample {
	WebDriver driver;
	String baseUrl;
	GenericMethods gm;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.expedia.co.in/");
		driver.manage().window().maximize();
		gm= new GenericMethods(driver);
	}


	@Test
	void test() {
		gm.GetElement("//span[contains(text(),'Flights')]", "Xpath").click();
		gm.GetElement("//span[contains(text(),'One way')]/parent::label", "Xpath").click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-origin-hp-flight' or @id='flight-origin']"), 10).sendKeys("Kolkata");
		gm.waitUntilElementIsVisible(By.xpath("//a[@data-value='Kolkata, India (CCU-Netaji Subhash Chandra Bose Intl.)']"),10).click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-destination-hp-flight' or @id='flight-destination']"), 10).sendKeys("Mumbai");
		gm.waitUntilElementIsVisible(By.xpath("//a[@data-value='Mumbai, India (BOM-Chhatrapati Shivaji Intl.)']"),10).click();
		gm.GetElement("//input[@id='flight-departing-single-hp-flight' or @id='flight-departing']","xpath").sendKeys("28/04/2018");
		gm.waitUntilElementIsVisible(By.xpath("//button[@class='datepicker-close-btn close btn-text']"), 10).click();
		gm.waitUntilElementIsVisible(By.xpath("(//label[@class='col search-btn-col']/button)[1]"),10).submit();
		
		gm.waitUntilElementIsReadyToBeClicked(By.xpath("//input[@data-test-id='Direct']"), 10);
		gm.waitUntilElementIsReadyToBeClicked(By.xpath("//input[@data-test-id='IndiGo Air']"), 10);
		gm.waitUntilElementIsReadyToBeClicked(By.xpath("//span[@id='departure-times-Afternoon-flights-checkbox']"), 10);
		gm.waitUntilElementIsReadyToBeClicked(By.xpath("//span[@id='arrival-times-Morning-flights-checkbox']"), 10);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
