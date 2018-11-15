package SeleniumBasics_LocatorTechniques;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByTagName {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseURL = "http://demostore.x-cart.com/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.findElement(By.tagName("a")).click();
		
		// id - fastest
		// name
		// classname
		// xpath
		// linktext
		// partial link text
		// tagname
		// css selector
	}
}