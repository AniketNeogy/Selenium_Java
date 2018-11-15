package cssSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssSelectorsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-Projects\\Selenium Version\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Practice')]")).click();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		//CSS Using ID
//		driver.findElement(By.cssSelector("input[id='displayed-text']")).sendKeys("Aniket");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[id='displayed-text']")).clear();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("#displayed-text")).sendKeys("Biswa");
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input[id='displayed-text']")).clear();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input#displayed-text")).sendKeys("Rana");
		
		//CSS Using Class name
//		driver.findElement(By.cssSelector("input.inputs")).sendKeys("Aniket");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input.inputs")).clear();
//		
//		driver.findElement(By.cssSelector("input[class='inputs']")).sendKeys("Neogy");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[class='inputs']")).clear();
//		
//		driver.findElement(By.cssSelector("input.inputs.displayed-class")).sendKeys("Noah");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input.inputs.displayed-class")).clear();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input.displayed-class.inputs")).sendKeys("Rohan");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input.displayed-class.inputs")).clear();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[class='inputs displayed-class']")).sendKeys("Noah");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[class='inputs displayed-class']")).clear();
//		Thread.sleep(2000);
		
		//appending classes and id
		//input.inputs  --> identifies 2 elements
		//input.inputs#name  --> identifies 1 element
//		driver.findElement(By.cssSelector("input.inputs#name")).sendKeys("Noah");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input.inputs#name")).clear();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".btn-style.class2#hide-textbox")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".btn-style.class2#show-textbox")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input.inputs#displayed-text")).sendKeys("OXYMoron");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".btn-style.class2#hide-textbox")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".btn-style.class2#show-textbox")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input.inputs#displayed-text")).clear();
//		Thread.sleep(2000);
//		

		
		//CSS selector Wildcards using class names 
		
		//  ^  --  Starts With
		//input[class='inputs'] -->identifies 1 web element
		//input[class^='inputs']  --> Identifies two web elements
		
		//  $  --  Ends With
		//input[class='displayed-class'] -->identifies No matching web element
		//input[class$='displayed-class'] -->identifies 1 web element
		
	    //  *  --  Contains
		//input[class='displayed'] -->identifies No matching web element
		//input[class*='displayed'] -->identifies 1 web element
				
		
		//Traversing through the DOM suing CSS selectors
//		1.fieldset>button
//		2.fieldset>label>input[value='bmw'] or fieldset>label>input#bmwradio
//		3.fieldset>select>option[value='bmw']
//		4.fieldset>select>option[value='orange']
//		5.fieldset>a
//		6.fieldset>input.inputs#name or fieldset>input[placeholder*='Enter Your Name']
//		7.fieldset>table#product
//		8.fieldset>table[class^='table'] or fieldset>table[class$='display']
//		9.fieldset>div>button#mousehover
//		
		driver.close();
		
	}

}
