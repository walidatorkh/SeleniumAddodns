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

public class Practice1a {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Chrome
		//System.setProperty("webdriver.chrome.driver", "D:\\data\\JB\\Selenium\\download\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		//FireFox
		System.setProperty("webdriver.firefox.marionette","O:\\QA Courses\\54919.1\\Igor\\SeleniumAddons\\jars\\chromedriver.exe");
    	driver = new FirefoxDriver();
		
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.staronline.org.uk/demo_register.asp");
		
	}

	@Test
	public void test() {
		System.out.println(driver.getTitle());
		
//		driver.get("http://cnn.com");
//		driver.navigate().to("http://cnn.com");
//		driver.navigate().back();
//		driver.navigate().forward();
		
		
		//driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("hagai1973@gmail.com");
		WebElement iEmail = driver.findElement(By.xpath(".//*[@id='email']"));
		iEmail.sendKeys("hagai@gmail.com");
		
//		driver.findElement(By.linkText("Home")).click();
//		driver.navigate().back();
//		//driver.findElement(By.partialLinkText("Hom")).click();
//		WebElement cb1 = driver.findElement(By.xpath(".//*[@id='orgform']/table//input[@value='794']"));
//		cb1.click();
//		String cbText =  driver.findElement(By.xpath(".//*[@id='orgform']/table//input[@value='794']//parent::td")).getText();
//		System.out.println("check box: " +  cbText + " is selcted ? :  " + cb1.isSelected());
		
		List<WebElement> cbs = driver.findElements(By.xpath(".//*[@id='orgform']/table//input"));
		
		for(WebElement we: cbs){
			we.click();
		}
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		Thread.sleep(3000);
		//driver.quit();

	}
}
