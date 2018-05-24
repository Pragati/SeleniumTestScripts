package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PTestCase1 {
	
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
	public void day1TestCase1() throws Exception{
		System.out.println("This is day1 test case1");
		driver.get(baseUrl);
		
		//Step 2. Verify Title of the page
		String homePage = driver.getTitle();
		System.out.println(homePage);
		try {
		      AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", homePage);
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		
		// Step 3. Click on ‘MOBILE’ menu
		driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a")).click();
		
		//Step 4. Verify current page title
		String childPage = driver.getTitle();
		System.out.println(childPage);
		try {
		      AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", homePage);
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		
		 // Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’		
		new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
		
		
		// Step 6. Verify all products are sorted by name
	
	}
	
	@AfterTest
	public void tearDown() throws Exception {
	  System.out.println("This is after test");
		driver.quit();   
	  }

}
