package SeleniumBasics_LocatorTechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByClassName {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseURL = "http://demostore.x-cart.com/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.findElement(By.className("title")).click();
		
		driver.findElement(By.className("leaf")).click();
	}
}