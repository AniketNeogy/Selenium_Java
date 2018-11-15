package SeleniumBasics_LocatorTechniques;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdXPATHDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://www.google.co.in");
		driver1.findElement(By.id("lst-ib")).sendKeys("letskodeit");
		driver1.findElement(By.xpath("//input[@value='Google Search']")).click();
		driver1.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver1.close();
		
	}

}
