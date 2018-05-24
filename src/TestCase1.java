//********************************************************************************************
//*                                                                                          *
//*    Guru99 eCommerce Live Project                                                         *
//*    Day 1 - TestCase 1                                                                    *
//*    Author: Krishna Rungta                                                                *                                                                                      *

//********************************************************************************************
/*  

Test Steps
Step 1. Goto http://live.guru99.com/
Step 2. Verify Title of the page
Step 3. Click on ‘MOBILE’ menu
Step 4. Verify Title of the page
Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
Step 6. Verify all products are sorted by name
*/



//import static org.junit.Assert.fail;

import java.io.File;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;


public class TestCase1 {
	  private WebDriver driver;
	  private String baseUrl;
	  public int scc = 0;
	  
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "/Users/pragati/Documents/Softwares/selenium/chromedriver");
			driver = new ChromeDriver();
			//driver.get("http://live.guru99.com");
			baseUrl = "http://live.guru99.com/";
			 System.out.println("This is before test and before method");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  @Test
	  public void testDay1TestCase1() throws Exception {
		  System.out.println("This is testday1");
	    driver.get(baseUrl); 
		//Step 2. Verify Title of the page
	    String demoSite  = driver.findElement(By.cssSelector("h2")).getText();
	    System.out.println(demoSite);
	    try {
	      AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", demoSite);
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }	    
	    

	    // Step 3. Click on ‘MOBILE’ menu
	    driver.findElement(By.linkText("MOBILE")).click();	
        // Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’		
	    new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
	    
	    // Step 6. Verify all products are sorted by name
		// this will take a screen shot of the manager's page after a successful login
	    scc = (scc+1);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String png = ("C:\\Guru99 eCommerce Live Project\\Day01_TestCase1\\Mobile Products are sorted" + scc + ".png");
		//FileUtils.copyFile(scrFile, new File(png));
//**************************************************************************************************************************	
	    }	
	  @Test
	  public void testDay1TestCase2() throws Exception{
		  System.out.println("This is test2");
		  //<h1>Mobile</h1>
		  System.out.println(driver.getCurrentUrl());
		  
		  //driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")).click();
	  }
	  
	  @AfterTest
		public void tearDown() throws Exception {
		  System.out.println("This is after test");
			driver.quit();
		   
		  }
	
	  
	}
