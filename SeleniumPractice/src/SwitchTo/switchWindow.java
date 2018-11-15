package SwitchTo;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulGenericMethods.GenericMethods;

public class switchWindow {
	private WebDriver driver;
	private GenericMethods gm;
	private JavascriptExecutor js;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice/";
		driver.get(baseUrl);
		gm = new GenericMethods(driver);
		js= (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}

	@Test
	public void test1() throws InterruptedException, IOException {
		
		//get parent Window Handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent WindoW Handle is : "+parentHandle);
		WebElement textBox = gm.GetElement("name", "Id");
		gm.highLighterMethod(driver, textBox);
		textBox.sendKeys("Aniket");
		gm.getScreenshot();
		Thread.sleep(2000);
		textBox.clear();
		Thread.sleep(2000);
		//click on Open Window Button
		gm.waitUntilElementIsReadyToBeClicked(By.cssSelector("#openwindow"), 3);
		Thread.sleep(2000);
		
		//get All Window Handles and switch to child window
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if(!handle.equals(parentHandle)){
				System.out.println("Child Window Handle is :"+handle);
				driver.switchTo().window(handle);
				WebElement searchBox = gm.GetElement("#search-courses", "CSSSelector");
				gm.highLighterMethod(driver, searchBox);
				searchBox.sendKeys("java");
				gm.getScreenshot();
				Thread.sleep(2000);
				driver.close();
				break;
			}	
		}
		
		//Switch To Parent Window
		driver.switchTo().window(parentHandle);
		WebElement displayedTextBox = gm.GetElement("#displayed-text", "CssSelector");
		gm.highLighterMethod(driver, displayedTextBox);
		displayedTextBox.sendKeys("Aniket");
		gm.getScreenshot();
		Thread.sleep(2000);
		displayedTextBox.clear();
		Thread.sleep(2000);
	}
	
	
	@Test
	public void test2() throws InterruptedException, IOException {
		
		//get parent Window Handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent WindoW Handle is : "+parentHandle);
		WebElement textBox = gm.GetElement("name", "Id");
		gm.highLighterMethod(driver, textBox);
		textBox.sendKeys("Aniket");
		gm.getScreenshot();
		Thread.sleep(2000);
		textBox.clear();
		Thread.sleep(2000);

		//Open a new window using javascript
		js.executeScript("window.open('https://letskodeit.teachable.com/courses','Courses');");
		Thread.sleep(10000);
		
		//get All Window Handles and switch to child window
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if(!handle.equals(parentHandle)){
				System.out.println("Child Window Handle is :"+handle);
				driver.switchTo().window(handle);
				WebElement searchBox = gm.GetElement("#search-courses", "CSSSelector");
				gm.highLighterMethod(driver, searchBox);
				searchBox.sendKeys("java");
				gm.getScreenshot();
				Thread.sleep(2000);
				driver.close();
				break;
			}	
		}
		
		//Switch To Parent Window
		driver.switchTo().window(parentHandle);
		WebElement displayedTextBox = gm.GetElement("#displayed-text", "CssSelector");
		gm.highLighterMethod(driver, displayedTextBox);
		displayedTextBox.sendKeys("Aniket");
		gm.getScreenshot();
		Thread.sleep(2000);
		displayedTextBox.clear();
		Thread.sleep(2000);
	}
	
	@Test
	public void test3() throws InterruptedException, IOException {
		
		//get parent Window Handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent WindoW Handle is : "+parentHandle);
		WebElement textBox = gm.GetElement("name", "Id");
		gm.highLighterMethod(driver, textBox);
		textBox.sendKeys("Aniket");
		gm.getScreenshot();
		Thread.sleep(2000);
		textBox.clear();
		Thread.sleep(2000);

		//Open a new window using javascript
		js.executeScript("window.open('https://letskodeit.teachable.com/courses','Courses','width=200','height=200');");
		Thread.sleep(10000);
		
		//switch to child window using Title
		driver.switchTo().window("Courses");
		WebElement searchBox = gm.GetElement("#search-courses", "CSSSelector");
		gm.highLighterMethod(driver, searchBox);
		searchBox.sendKeys("java");
		gm.getScreenshot();
		Thread.sleep(2000);
		driver.close();
		
		
		//Switch To Parent Window
		driver.switchTo().window(parentHandle);
		WebElement displayedTextBox = gm.GetElement("#displayed-text", "CssSelector");
		gm.highLighterMethod(driver, displayedTextBox);
		displayedTextBox.sendKeys("Aniket");
		gm.getScreenshot();
		Thread.sleep(2000);
		displayedTextBox.clear();
		Thread.sleep(2000);
	}
	
	@Test
	public void test4() throws InterruptedException, IOException {
		
		//get parent Window Handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent WindoW Handle is : "+parentHandle);
		WebElement textBox = gm.GetElement("name", "Id");
		gm.highLighterMethod(driver, textBox);
		textBox.sendKeys("Aniket");
		gm.getScreenshot();
		Thread.sleep(2000);
		textBox.clear();
		Thread.sleep(2000);

		//Open a new window using javascript
		js.executeScript("window.open('https://letskodeit.teachable.com/courses','Courses','width=200','height=200');");
		Thread.sleep(10000);
		
		//get All Window Handles and switch to child window
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if(!handle.equals(parentHandle)){
				System.out.println("Child Window Handle is :"+handle);
				driver.switchTo().window(handle);
				WebElement searchBox = gm.GetElement("#search-courses", "CSSSelector");
				gm.highLighterMethod(driver, searchBox);
				searchBox.sendKeys("java");
				gm.getScreenshot();
				Thread.sleep(2000);
				driver.close();
				break;
			}	
		}
		
		//Switch To Parent Window
		driver.switchTo().window(parentHandle);
		WebElement displayedTextBox = gm.GetElement("#displayed-text", "CssSelector");
		gm.highLighterMethod(driver, displayedTextBox);
		displayedTextBox.sendKeys("Aniket");
		gm.getScreenshot();
		Thread.sleep(2000);
		displayedTextBox.clear();
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
