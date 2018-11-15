import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Using chrome
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@id='contentContainer']/div/div/div/yt-icon-button/button//yt-icon[@id='guide-icon']")).click();
		Boolean MenuStatus= driver.findElement(By.xpath("//a[@title='Home']")).isEnabled();
		System.out.println(MenuStatus);
		Thread.sleep(1000);
		if (MenuStatus == true)
		{
			driver.findElement(By.xpath("//span[text()='Music']")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		driver.close();
		
		
		//Using Firefox
		/*System.setProperty("webdriver.gecko.driver","D:\\Selenium-Projects\\Selenium Version\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.youtube.com/");
		driver1.manage().window().maximize();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@id='contentContainer']/div/div/div/yt-icon-button/button//yt-icon[@id='guide-icon']")).click();
		Boolean MenuStatus= driver1.findElement(By.xpath("//a[@title='Home']")).isEnabled();
		System.out.println(MenuStatus);
		Thread.sleep(1000);
		if (MenuStatus == true)
		{
			driver1.findElement(By.xpath("//span[text()='Music']")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		driver1.close();
		*/
		
	}

}
