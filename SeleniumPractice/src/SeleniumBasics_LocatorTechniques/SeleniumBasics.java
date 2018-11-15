package SeleniumBasics_LocatorTechniques;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//ID and Xpath
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("lst-ib")).sendKeys("Mancherster United");
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("\n");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		driver.close();
		
		//BY Name
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Mancherster United");
		driver.findElement(By.name("btnK")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();
		
		//link Text
		driver.get("https://letskodeit.teachable.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.partialLinkText("Prac")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();
		
		
		
		
		
		
	}

}
