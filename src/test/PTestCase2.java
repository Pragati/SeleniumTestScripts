package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class PTestCase2 {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "/Users/pragati/Documents/Softwares/selenium/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "http://live.guru99.com/index.php/";
		System.out.println("This is before test and before method");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	
	@Test
	public void day2TestCase1() throws Exception{
		//Step 1. Go to baseUrl
		System.out.println("This is day2 test case1");
		driver.get(baseUrl);
		
		//Step 2. Click on "Mobile" menu
		driver.findElement(By.linkText("MOBILE")).click();
		System.out.println("Clicked on mobile");
		
		//Step 3. Read and note the "Sony xperia Mobile" price.
		String price = driver.findElement(By.xpath("//span[@id='product-price-1']")).getText();
		System.out.println(price);
		
		//Step 4. Click on sony Xperia phone
		driver.findElement(By.id("product-collection-image-1")).click();
		
		//Step 5. Read price of the phone from detail page
		String priceFromDetailPage = driver.findElement(By.cssSelector("span.price")).getText();
		System.out.println(priceFromDetailPage);
		
		//compare
		assertEquals(price, priceFromDetailPage);
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	  }
	
}
