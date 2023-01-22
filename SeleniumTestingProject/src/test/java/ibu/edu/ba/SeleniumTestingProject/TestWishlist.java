package ibu.edu.ba.SeleniumTestingProject;


import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
class TestWishlist {
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
	void Wishlist() throws InterruptedException {
        Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		//JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		Thread.sleep(5000);
		
		//Clicking on wishlist section
		WebElement wishlistSection = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[3]/a"))
						);
		wishlistSection.click();
		Thread.sleep(4000);
		
		WebElement enter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[3]/div/div/section/button"))
						);
		enter.click();
		Thread.sleep(4000);
		
		
		//Click on x to exclude the black sneakers from wishlist
		WebElement black = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[1]/form/button"))
						);
		black.click();
		Thread.sleep(4000);
		
		//Add product from wislist to the cart
		WebElement cart = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[1]/div/button"))
						);
		cart.click();
		Thread.sleep(4000);
		
		//Choose EU instead of the UK
		WebElement eu = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sizes-modal-02098277\"]/div[3]/div/nav/div/ul[1]/li[2]"))
						);
		eu.click();
		Thread.sleep(4000);
		
		//Choose available size
		WebElement size = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"m-option-1\"]/span"))
						);
		size.click();
		Thread.sleep(4000);
		
		//Add to the cart and go to the basket to see the added product
		WebElement basket = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"added-modal_desktop\"]/div[3]/div/div/div[2]/a[2]"))
						);
		basket.click();
		Thread.sleep(4000);
		
		//finishing here - going to next test to test the cart functionalities
	}

}
