package Practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class second {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		System.setProperty(
                "webdriver.chrome.driver", "O:\\QA Courses\\54919.1\\Igor\\SeleniumAddons\\jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Open google.com
        driver.navigate().to("http://www.google.com");

        String html = driver.getPageSource();

        // Printing result here.
        System.out.println(html);

        driver.close();
        driver.quit();
    }
		
	

}
