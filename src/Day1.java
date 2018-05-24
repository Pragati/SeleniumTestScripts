import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/pragati/Documents/Softwares/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://live.guru99.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\'top\']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/h2"));
		System.out.println(list);
	}

}

//*[@id="nav"]/ol/li[1]/a

//*[@id="top"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select


//*[@id="top"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]