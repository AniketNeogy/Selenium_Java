package CalenderAndAutocomplete;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;

class DemoExpediaCalender {
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
	void test1() throws InterruptedException {
		gm.GetElement("//span[contains(text(),'Flights')]", "Xpath").click();
		gm.GetElement("//span[contains(text(),'One way')]/parent::label", "Xpath").click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-origin-hp-flight' or @id='flight-origin']"), 10).sendKeys("Kolkata");
		gm.waitUntilElementIsVisible(By.xpath("//a[@data-value='Kolkata, India (CCU-Netaji Subhash Chandra Bose Intl.)']"),10).click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-destination-hp-flight' or @id='flight-destination']"), 10).sendKeys("Mumbai");
		gm.waitUntilElementIsVisible(By.xpath("//a[@data-value='Mumbai, India (BOM-Chhatrapati Shivaji Intl.)']"),10).click();
		gm.GetElement("//input[@id='flight-departing-single-hp-flight' or @id='flight-departing']","xpath").sendKeys("27/11/2018");
		gm.waitUntilElementIsVisible(By.xpath("(//label[@class='col search-btn-col']/button)[1]"),10).submit();
	}
	
	@Test
	void test2() throws InterruptedException {
		gm.GetElement("//span[contains(text(),'Flights')]", "Xpath").click();
		gm.GetElement("//span[contains(text(),'One way')]/parent::label", "Xpath").click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-origin-hp-flight' or @id='flight-origin']"), 10).sendKeys("Kolkata");
		gm.waitUntilElementIsVisible(By.xpath("//a[@data-value='Kolkata, India (CCU-Netaji Subhash Chandra Bose Intl.)']"),10).click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-destination-hp-flight' or @id='flight-destination']"), 10).sendKeys("Mumbai");
		gm.waitUntilElementIsVisible(By.xpath("//a[@data-value='Mumbai, India (BOM-Chhatrapati Shivaji Intl.)']"),10).click();
		gm.GetElement("//input[@id='flight-departing-single-hp-flight' or @id='flight-departing']","xpath").click();
		gm.waitUntilElementIsReadyToBeClicked(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[not(contains(@class,'disabled')) and @data-day='17']"), 5);
		gm.waitUntilElementIsVisible(By.xpath("(//label[@class='col search-btn-col']/button)[1]"),10).submit();
	}
	
	@Test
	void test3() throws InterruptedException {
		gm.GetElement("//span[contains(text(),'Flights')]", "Xpath").click();
		gm.GetElement("//span[contains(text(),'One way')]/parent::label", "Xpath").click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-origin-hp-flight' or @id='flight-origin']"), 10).click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-origin-hp-flight' or @id='flight-origin']"), 10).sendKeys("Kolkata");
		gm.waitUntilElementIsVisible(By.xpath("//a[@data-value='Kolkata, India (CCU-Netaji Subhash Chandra Bose Intl.)']"),10).click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-destination-hp-flight' or @id='flight-destination']"), 10).click();
		gm.waitUntilElementIsVisible(By.xpath("//input[@id='flight-destination-hp-flight' or @id='flight-destination']"), 10).sendKeys("Mumbai");
		gm.waitUntilElementIsVisible(By.xpath("//a[@data-value='Mumbai, India (BOM-Chhatrapati Shivaji Intl.)']"),10).click();
		
		
		gm.GetElement("//input[@id='flight-departing-single-hp-flight' or @id='flight-departing']","xpath").click();
		WebElement calMonth = gm.waitUntilElementIsVisible(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"), 5);
		
		List<WebElement> validDates = calMonth.findElements(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[not(contains(@class,'disabled'))]"));
		System.out.println(validDates);
		for(WebElement date : validDates)
		{
			if(date.getAttribute("data-day").equals("28"))
			{
				date.click();
				break;
			}
		}
		gm.waitUntilElementIsVisible(By.xpath("(//label[@class='col search-btn-col']/button)[1]"),10).submit();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
