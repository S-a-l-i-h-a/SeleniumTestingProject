package ibu.edu.ba.SeleniumTestingProject;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
class TestWomanShopping {
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
	void WomanShopping() throws InterruptedException {
		
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		
		//Clicking on woman section
		WebElement woman = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"HeaderLinksSlot\"]/nav/ul/li[1]/a"))
						);
		woman.click();
		Thread.sleep(5000);
	
		
		//Put sneakers in wishlist
		WebElement sneakersfav = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-Homepage-Women-Master\"]/div[3]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/article/form/button"))
						);
		sneakersfav.click();
		Thread.sleep(5000);
		
		//Click on all trainers to enter new page
		WebElement trainersSection = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-Homepage-Women-Master\"]/div[3]/div/div/div[1]/a"))
						);
		trainersSection.click();
		Thread.sleep(5000);
		
		//Click on filter button to filter results
		WebElement filter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]"))
						);
		filter.click();
		Thread.sleep(5000);
		
		//Clear the already put max price and enter new
		WebElement max = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("max-price"))
						);
		max.clear();
		Thread.sleep(5000);
		max.sendKeys("50");
		
		Thread.sleep(4000);
		//Apply price and enter color section
		WebElement colorSection = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[3]/i"))
						);
		colorSection.click();
		
		Thread.sleep(4000);
		//Choose purple color
		WebElement purple = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[8]/i"))
						);
		purple.click();
		
		Thread.sleep(4000);
	    //Choose neutral color
		WebElement neutral = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[9]/i"))
						);
		neutral.click();
		
		Thread.sleep(5000);
		//Assert the number of results
		String filterResults = webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label/button/span")).getText();
		assertEquals("17 Show results", filterResults);
		js.executeScript("alert('You have 17 results displayed here!')");	
		Thread.sleep(6000);
		
		//Upon applying filter show the results
		WebElement showFilter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label"))
						);
		showFilter.click();
		Thread.sleep(5000);
		
		//Add sneakers to wishlist
		WebElement wishlist = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[6]/form/button"))
						);
		wishlist.click();
		Thread.sleep(5000);
		
		//Shop Jack Wolfskin sneakers
		WebElement shopSneakers = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[2]/a"))
						);
		shopSneakers.click();
		Thread.sleep(5000);
		
		//Slide down for more pictures
		WebElement pictures = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/div[1]/section/product-slider/div[1]/div[1]/div[3]/div"))
						);
		pictures.click();
		Thread.sleep(5000);
		
		
		//Open to see size chart numbers and then close
		WebElement sizeChartOpen = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[3]/m-product-size-table/div/a/span"))
						);
		sizeChartOpen.click();
		Thread.sleep(5000);
		
		WebElement sizeChartClosed = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"size-selection-overlay\"]/div[3]/header/a"))
						);
		sizeChartClosed.click();
		
		Thread.sleep(5000);
		//Add product to the cart
		WebElement addToCart = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[4]/div/form/button"))
						);
		addToCart.click();
		
		Thread.sleep(4000);
		//Chose EU size instead of UK
		WebElement eu = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sizes-modal\"]/div[3]/div/nav/div/ul[1]/li[2]"))
						);
		eu.click();
		Thread.sleep(4000);
		
		//Chose available size
		WebElement size = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"m-option-19\"]/span"))
						);
		size.click();
		Thread.sleep(4000);
		
		//View the basket you placed the product
		WebElement basket = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"added-modal_desktop\"]/div[3]/div/div/div[2]/a[2]"))
						);
		basket.click();
		Thread.sleep(4000);
		

}
	
}
