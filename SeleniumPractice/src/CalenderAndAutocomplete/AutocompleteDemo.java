package CalenderAndAutocomplete;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;

public class AutocompleteDemo {
	private	WebDriver driver;
	private	String baseUrl;
	GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl="https://www.southwest.com/";
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		gm = new GenericMethods(driver);
	}
	
	@Test
	public void test() throws InterruptedException {
		gm.GetElement("#trip-type-one-way", "CssSelector").click();
		if(!(driver.findElement(By.cssSelector("#air-date-return")).isEnabled())){
			System.out.println("Return date is disabled");
			gm.GetElement("#air-city-departure", "CssSelector").sendKeys("New");
			WebElement AutoList = gm.waitUntilElementIsVisible(By.cssSelector("#js-menu-wrapper"), 10);
			System.out.println("First List");
			List<WebElement> AutoCompleteList = AutoList.findElements(By.tagName("li"));
			System.out.println("Size of First List is :: "+AutoCompleteList.size());
			for(WebElement element : AutoCompleteList){
				if(!element.isDisplayed()) {
					driver.findElement(By.xpath("//div[@class='menu--arrow js-menu-scroll-down']/div")).click();
				}
				System.out.println(element.getText());
			}
			System.out.println();
			System.out.println("Second List");
			AutoCompleteList = driver.findElements(By.cssSelector("#js-menu-wrapper>ul>li"));
			System.out.println("Size of First List is :: "+AutoCompleteList.size());
			for(int i=0;i<AutoCompleteList.size();i++){
				if(!(AutoCompleteList.get(0).isDisplayed())) {
					driver.findElement(By.xpath("//div[@class='menu--arrow js-menu-scroll-up']/div")).click();
				}
			}
			
			Thread.sleep(2000);
			
			for(WebElement element : AutoCompleteList){
				if(element.getText().equals("New York/Newark, NJ - EWR")) {
					element.click();
					break;
				}
				
				
			}
		}
				
	}
	
	@After
	public void tearDown() throws Exception {
		//Thread.sleep(2000);
		//driver.close();
	}


}
