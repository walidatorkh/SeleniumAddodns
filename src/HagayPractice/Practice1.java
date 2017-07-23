package HagayPractice;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "O:\\QA Courses\\54919.1\\Igor\\SeleniumAddons\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.staronline.org.uk/demo_register.asp");
		

	}

	@Test
	public void test() {
		System.out.println();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
