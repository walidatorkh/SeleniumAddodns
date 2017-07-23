package HagayPractice;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice3 {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", "D:\\data\\JB\\Selenium\\download\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//FireFox
//		System.setProperty("webdriver.firefox.marionette","D:\\data\\JB\\Selenium\\download\\geckodriver.exe");
//    	driver = new FirefoxDriver();
		String baseUrl = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}

	@Test
	public void test() throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("html/body/button")).click();
		//driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		
		
		
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		Thread.sleep(3000);
		//driver.quit();

	}
}
