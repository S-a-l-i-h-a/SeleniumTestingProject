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
class TestChildrenShopping {

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
	void ChildernShopping() throws InterruptedException {
		
        Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		//JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		Thread.sleep(5000);
		//Clicking on children section
		WebElement children = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"HeaderLinksSlot\"]/nav/ul/li[3]/a"))
						);
		children.click();
		Thread.sleep(4000);
		
		//Enter toddler section
		WebElement toddler = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-Homepage-kids-Master\"]/div[2]/div/div/div[2]/div/div/div/div/div[3]/div[2]/a/picture/img"))
						);
		toddler.click();
		Thread.sleep(4000);
		
		//Enter babies section 
		WebElement babies = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SubnavigationSlot\"]/m-y-category-navigation/ul/li[2]/ul/li[4]/ul/li[2]/a"))
						);
		babies.click();
		Thread.sleep(4000);
		
		//Click on the filter button to filter the products
		WebElement filter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]"))
								);
		filter.click();
		Thread.sleep(4000);
		
		//Click on the relevance slot to change from low to high
		WebElement relevanceSlot = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[1]/details/summary"))
								);
		relevanceSlot.click();
		
		WebElement lowToHigh = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[1]/details/ul/li[4]/label"))
								);
		lowToHigh.click();
		Thread.sleep(4000);
		
		//Filter by pink color
		WebElement pink = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[2]/i"))
						);
		pink.click();
		Thread.sleep(4000);
		
		//Upon applying filter show the results
		WebElement showFilter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label"))
						);
		showFilter.click();
		Thread.sleep(4000);
		
		//Choose pepapig slippers
		WebElement product = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[1]/a"))
						);
		product.click();
		Thread.sleep(3000);
		
		//See in which store is available
		WebElement available = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchInStoreDesktop\"]/a/a/m-branch-search-in-store/button/span"))
						);
		available.click();
		Thread.sleep(3000);
		
		//Choose EU instead of UK
		WebElement eu = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sizes-modal\"]/div[3]/div/nav/div/ul[1]/li[2]"))
						);
		eu.click();
		Thread.sleep(4000);
		
		
		//Exit the details about availability of the product
		WebElement exit = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sizes-modal\"]/div[3]/header/a"))
						);
		exit.click();
		Thread.sleep(4000);
		
		//Click on heart button and put it in wishlist
		WebElement wish = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[4]/form/button"))
						);
		wish.click();
		
		Thread.sleep(3000);
		
		//now entering wishlist- favourite in next test	
}
	

}
