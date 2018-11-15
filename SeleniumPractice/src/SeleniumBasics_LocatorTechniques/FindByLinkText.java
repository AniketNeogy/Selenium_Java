package SeleniumBasics_LocatorTechniques;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByLinkText {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				WebDriver driver;
				System.setProperty("webdriver.chrome.driver","D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String baseURL = "https://letskodeit.teachable.com/";
				driver.get(baseURL);
				
				driver.findElement(By.linkText("Login")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.partialLinkText("Pract")).click();

			}

}
