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

public class dragNdrop_clickHoldnReleaseActions {
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		gm= new GenericMethods(driver);
		baseUrl = "http://jqueryui.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	// draggable element 
	public void test1() throws InterruptedException {
		gm.waitUntilElementIsReadyToBeClicked(By.xpath("//a[text()='Draggable']"), 10);
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
		
		//moved by click and Hold using offset
		action.clickAndHold(draggable).moveByOffset(200, 150).release().build().perform();
		
		//moved by Drag and Drop using offset
		action.dragAndDropBy(draggable, 58, 75).perform();
	}
	
	@Test
	// droppable element 
	public void test2() throws InterruptedException {
		gm.waitUntilElementIsReadyToBeClicked(By.xpath("//a[text()='Droppable']"), 10);
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Destination = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		
		//moved by click and Hold using offset
		//action.clickAndHold(Source).moveToElement(Destination).release().build().perform();
		
		//moved by Drag and Drop using offset
		action.dragAndDrop(Source, Destination).perform();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
