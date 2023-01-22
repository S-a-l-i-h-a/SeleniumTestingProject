package ibu.edu.ba.SeleniumTestingProject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;


public class TestFindStore {
	
		private static WebDriver webDriver;
		private static String baseUrl;
		//private static WebDriver driver;

		@BeforeAll
		static void setUpBeforeClass() throws Exception {
			System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Saliha\\Desktop\\3rd year\\svvt\\chromedriver_win32");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			
			webDriver = new ChromeDriver(options);
			
			baseUrl = "https://www.deichmann.com/en-gb/";
			
		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
			webDriver.quit();
		}
		
		@Test
		void AcceptingCookiesAndFindingStore() throws InterruptedException {
			
			webDriver.get(baseUrl);
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
			
			//Remember current page tab since we will get back later 
			String handle1 = webDriver.getWindowHandle();
			System.out.println(handle1);
			
			for (String handle: webDriver.getWindowHandles()) {
				if (!handle.equals(handle1)) {
					webDriver.switchTo().window(handle);
					break;
				}
			}
			//Accept cookies
			WebElement acceptCookies = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"consent-layer-modal\"]/div[3]/div/footer/button[1]"))
					);
			acceptCookies.click();
			
			
			//Assert that is says 
			String main = webDriver.findElement(By.xpath("//*[@id=\"Section5Slot-Homepage-Master\"]/div/div/h1")).getText();
			assertEquals("Discover affordable footwear from the UK’s favourite shoe retailer", main);
			Thread.sleep(2000);
			
			
			//Click on the find store section
			WebElement findStore = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[1]/a"))
					);
			findStore.click();
			
			
			//Click on the slot for entering the address
			WebElement clickAddress = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#storefinder-default-guest > section"))
					);
			clickAddress.click();
			
			//Enter Address
			WebElement enterAddress = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchInput"))
					);
			enterAddress.sendKeys("United Kingdom House, London, UK");
			
			
			webDriver.findElement(By.xpath("//*[@id=\"storefinder-default-guest\"]/span/m-get-predictions/form/button[1]")).click();
			Thread.sleep(2000);
			
			//Click to expand address to see working hours
			WebElement workingTime = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"storecard-0\"]/section/span[2]"))
					);
			workingTime.click();
			
			//Click on the plan route button to open google maps
			WebElement planRoute = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"storecard-0\"]/section/div[5]/a[1]/button"))
					);
			planRoute.click();
			
			
			//Ending here since next step is going to google maps
			//Getting back on main page
			Thread.sleep(3000);
			webDriver.switchTo().window(handle1);
			Thread.sleep(2000);
			
			//switch to main page
			webDriver.get(baseUrl);
			Thread.sleep(2000);	
		}
 
}
