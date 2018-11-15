package BasicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class NavigationBetweenPages {
	WebDriver driver;
	String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
	baseUrl="https://letskodeit.teachable.com/";
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		String PageTitle = driver.getTitle();
		System.out.println("The Title of the Page is: "+PageTitle);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The Current Url is : "+currentUrl);
		
		System.out.println("Navigate to the Login Page");
		driver.navigate().to("https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1");
		Thread.sleep(2000);
		currentUrl = driver.getCurrentUrl();
		System.out.println("The Current Url is : "+currentUrl);
		
		System.out.println("Navigate Back to Home Page");
		driver.navigate().back();
		Thread.sleep(2000);
		currentUrl = driver.getCurrentUrl();
		System.out.println("The Current Url is : "+currentUrl);
		
		System.out.println("Navigate Forward to Login Page");
		driver.navigate().forward();
		Thread.sleep(2000);
		currentUrl = driver.getCurrentUrl();
		System.out.println("The Current Url is : "+currentUrl);
		
		System.out.println("Navigate Back to Home Page");
		driver.navigate().back();
		Thread.sleep(2000);
		currentUrl = driver.getCurrentUrl();
		System.out.println("The Current Url is : "+currentUrl);
		
		System.out.println("Refresh Page");
		driver.navigate().refresh();
		currentUrl = driver.getCurrentUrl();
		System.out.println("The Current Url is : "+currentUrl);
		Thread.sleep(2000);
		driver.get(currentUrl);
		currentUrl = driver.getCurrentUrl();
		System.out.println("The Current Url is : "+currentUrl);
		
		
		System.out.println(driver.getPageSource());
		Thread.sleep(2000);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
}
