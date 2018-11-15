package ActionsClassDemo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import usefulGenericMethods.GenericMethods;

public class sliderAction {
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		gm= new GenericMethods(driver);
		baseUrl = "http://jqueryui.com/slider/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions action = new Actions(driver);
		
		//moved by click and Hold using offset
		action.clickAndHold(slider).moveByOffset(200, 0).release().build().perform();

	}
	
	@Test
	public void test2() throws InterruptedException {
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions action = new Actions(driver);
		
		//moved by Drag and Drop using offset
		action.dragAndDropBy(slider, 100, 0).perform();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
