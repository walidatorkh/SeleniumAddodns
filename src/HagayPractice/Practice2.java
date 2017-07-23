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

public class Practice2 {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", "O:\\QA Courses\\54919.1\\Igor\\SeleniumAddons\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//FireFox
//		System.setProperty("webdriver.firefox.marionette","D:\\data\\JB\\Selenium\\download\\geckodriver.exe");
//    	driver = new FirefoxDriver();
		
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://letskodeit.teachable.com/p/practice");
		
	}

	@Test
	public void test() throws InterruptedException {
		System.out.println(driver.getTitle());

		WebElement weCar = driver.findElement((By.xpath(".//*[@id='bmwradio']")));
		weCar.click();
		System.out.println(weCar);		
		WebElement weCar2 = driver.findElement((By.xpath(".//*[@id='multiple-select-example']/option[2]")));
		weCar2.click();
		weCar2.getText();
		Thread.sleep(5000);
		WebElement weCar3 = driver.findElement((By.xpath("//*[@id='opentab']")));
		weCar3.click();
		System.out.println(weCar3);		
		//Select sCar = new Select(weCarSelect);
		//sCar.selectByVisibleText("Honda");
		
		
		
		
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		Thread.sleep(3000);
		driver.quit();

	}
}
