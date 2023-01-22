package ibu.edu.ba.SeleniumTestingProject;



import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
class TestNewsletter {

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
	void Newsletter() throws InterruptedException {
		Thread.sleep(5000);
		
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		
		Thread.sleep(5000);
		
		//Open your account to be able to enter the newsletter
		WebElement account = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/a"))
						);
		account.click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/section/m-accountcontentpage/section")).click();
		Thread.sleep(4000);
		
		//open newsletter form
		WebElement newsletter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/section/aside/a[4]"))
						);
		newsletter.click();
		Thread.sleep(2000);
		
		//Click for which products you are interested in
		WebElement woman = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/div[1]/div[1]"))
						);
		woman.click();
		Thread.sleep(2000);
		
		WebElement man = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/div[1]/div[2]"))
						);
		man.click();
		Thread.sleep(2000);
		WebElement children = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/div[1]/div[3]"))
						);
		children.click();
		Thread.sleep(2000);
		
		//Click to accept the terms of privacy policy
		WebElement policy = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/div[2]/label/span[1]"))
						);
		policy.click();
		Thread.sleep(2000);
		
		//If all is true, submit the request to receive newsletter
		WebElement submit = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/button"))
						);
		submit.click();
		Thread.sleep(5000);
		
		}

}
