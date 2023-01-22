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
class TestManShopping {

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
	void ManShopping() throws InterruptedException {
		
        Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		Thread.sleep(5000);
		//Clicking on man section
		WebElement man = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"HeaderLinksSlot\"]/nav/ul/li[2]/a"))
						);
		man.click();
		
		Thread.sleep(4000);
		
		//Choose addidas brand section
		WebElement addidas = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-Homepage-men-Master\"]/div[5]/div/div/div[2]/div/div/div/div[1]/div[3]/div[2]/a/picture/img"))
						);
		addidas.click();
		Thread.sleep(5000);
		
		
		//Add black socks to favorite 
		WebElement socks = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[16]/form/button"))
						);
		socks.click();
		Thread.sleep(5000);
		
		//Click on filter button to filter results
		WebElement filter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]"))
								);
		filter.click();
		Thread.sleep(5000);
		
		//Clear and put min price to 40
		WebElement min = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("min-price"))
						);
		min.clear();
		Thread.sleep(4000);
		min.sendKeys("40");
		Thread.sleep(4000);
		
		
		//Clear and put max price as 55
		WebElement max = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("max-price"))
						);
		max.clear();
		Thread.sleep(5000);
		max.sendKeys("50");
		Thread.sleep(4000);
		
		
		//Select olive color 
		WebElement olive = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[6]/i"))
						);
		olive.click();
		Thread.sleep(5000); 
		
		//Assert the filter results
		String filterResults = webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label/button/span")).getText();
		assertEquals("2 Show results", filterResults);
		js.executeScript("alert('You have 2 results displayed here!')");	
		Thread.sleep(6000);
		
		//Upon applying filter show the reults
		WebElement showFilter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label"))
						);
		showFilter.click();
		
		//Enter filter section again
		Thread.sleep(3000);
		filter.click();
		
		//Add another color to the filter 
		WebElement color = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[2]/i"))
						);
		color.click();
		Thread.sleep(5000);
		
		//upon adding new color show results again
		WebElement showFilterAgain = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label"))
						);
		showFilterAgain.click();
		Thread.sleep(5000);
		
		//Enter into product details
		WebElement product = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[3]/a"))
						);
		product.click();
		Thread.sleep(4000);
		
		//Expand the material details about the product
		WebElement materialDetails = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-details\"]/section/m-product-classification/section/details/summary"))
						);
		materialDetails.click();
		Thread.sleep(5000);
		
		//Add product to the shopping cart
		WebElement cart = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[4]/div/form/button/span"))
						);
		cart.click();
		Thread.sleep(5000);
		
		//Select EU size instead of UK
		WebElement eu = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sizes-modal\"]/div[3]/div/nav/div/ul[1]/li[2]"))
						);
		eu.click();
		Thread.sleep(4000);
		
		//Choose size from available ones
		WebElement size = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"m-option-1\"]/span"))
						);
		size.click();
		Thread.sleep(4000);
		
		//View basket in which you purchased products
		WebElement basket = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"added-modal_desktop\"]/div[3]/div/div/div[2]/a[2]"))
						);
		basket.click();
		Thread.sleep(4000);
		
		//Assert current price in the cart after woman and man shopping
		WebElement price =webDriver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[2]/section[1]/div[1]/p[2]"));
		String text = price.getText();
		assertEquals("£92.98", text);
		js.executeScript("alert('Be careful, until now you have £92.98 ')");
		Thread.sleep(5000);
		
		
	
}

}
