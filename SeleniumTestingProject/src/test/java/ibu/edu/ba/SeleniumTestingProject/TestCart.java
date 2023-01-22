package ibu.edu.ba.SeleniumTestingProject;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
class TestCart {

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
	
	@Test
	@Order(1)
	void Login() throws InterruptedException {

		webDriver.get(baseUrl);
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		//JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		//Accept cookies
		WebElement acceptCookies = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"consent-layer-modal\"]/div[3]/div/footer/button[1]"))
								);
		acceptCookies.click();
		Thread.sleep(2000);
		// LOGIN
		// Account icon
		WebElement accountLogin = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/a"))
				);
		accountLogin.click();
		Thread.sleep(4000);

		// Click on login button
		WebElement login = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/div/div/button"))
				);
		login.click();
		Thread.sleep(4000);

		// Insert email in the slot
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[1]/div/input")).click();
		WebElement emailLogin = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[1]/div/input"))
				);
		emailLogin.sendKeys("john.doe@gmail.com");
		Thread.sleep(4000);

		// Insert password in the slot
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[2]/div/input")).click();
		WebElement passwordLogin = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[2]/div/input"))
				);
		passwordLogin.sendKeys("12345678");
		Thread.sleep(4000);

		// Click on login button
		WebElement loginButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/m-button/button"))
				);
		loginButton.click();

		Thread.sleep(5000);

	}
	
	@Test
	@Order(2)
	void Cart() throws InterruptedException {
        Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		Thread.sleep(5000);
		
		//Open cart to see the added products
		WebElement cart = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[4]/a"))
						);
		cart.click();
		Thread.sleep(4000);
		
		//Assert how much money you are saving
		WebElement saving =webDriver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[2]/section[1]/div[2]/p"));
		String text2 = saving.getText();
		assertEquals("Savings £14.00", text2);
		js.executeScript("alert('Great, you are saving 14 ')");
		Thread.sleep(3000);
		
		//Proceed to the payment page
		WebElement payment = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div[1]/div[2]/span[1]"))
						);
		payment.click();
		
		Thread.sleep(4000);
		
		
		//Since this is real site we will not continue with further payment 

	}
}
