package ibu.edu.ba.SeleniumTestingProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class SeleniumTest2 {
	private static WebDriver webDriver;
	private static String baseUrl;

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
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void RegisterAndLogin() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		//accepting cookies
		webDriver.findElement(By.xpath("//*[@id=\"consent-layer-modal\"]/div[3]/div/footer/button[1]")).click();
		Thread.sleep(2000);
		//person button
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/a")).click();
		Thread.sleep(3000);
		//register no account
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/div/div/a/u")).click();
		Thread.sleep(3000);
		//mr radio button
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/form/form/div[1]/div[1]/div[2]/span/label/span[1]")).click();
		Thread.sleep(2000);
		//insert name
		webDriver.findElement(By.xpath("//*[@id=\"delivery-firstName\"]")).sendKeys("John");
		Thread.sleep(2000);
		//insert last name
		webDriver.findElement(By.xpath("//*[@id=\"delivery-lastName\"]")).sendKeys("Doe");
		Thread.sleep(2000);
		//Insert email
		webDriver.findElement(By.xpath("//*[@id=\"delivery-email\"]")).sendKeys("john.doee@gmail.com");
		Thread.sleep(2000);
		//insert password
		webDriver.findElement(By.xpath("//*[@id=\"delivery-password\"]")).sendKeys("12345678");
		//zip code
		webDriver.findElement(By.xpath("//*[@id=\"delivery-postalCode\"]")).sendKeys("L2 2DP");
		webDriver.findElement(By.xpath("/html/body/div[1]/main")).click();
		Thread.sleep(2000);
		//chose address
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/form/form/div[1]/button")).click();
		Thread.sleep(2000);
		//choose
		webDriver.findElement(By.xpath("//*[@id=\"suggested-address\"]/div[3]/div/div[1]/div[1]/span/label/span[1]")).click();
		//Confirm button
		webDriver.findElement(By.xpath("//*[@id=\"suggested-address\"]/div[3]/div/div[2]/m-button/button")).click();
		Thread.sleep(2000);
		//confirm privacy
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/form/form/div[2]/div[2]/label/span")).click();
		Thread.sleep(2000);
		//register button
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/form/form/div[3]/button")).click();
		Thread.sleep(5000);
		//logout 
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/aside/a[5]")).click();
		Thread.sleep(3000);	
		
		//person button
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/a")).click();
		Thread.sleep(3000);
		//login button
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/div/div/button")).click();
		Thread.sleep(3000);
		//insert email
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[1]/div/input")).sendKeys("john.doee@gmail.com");
		Thread.sleep(2000);
		//insert password
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[2]/div/input")).sendKeys("12345678");
		Thread.sleep(2000);
		//login button
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/m-button/button")).click();
		Thread.sleep(2000);
		
	}

}
