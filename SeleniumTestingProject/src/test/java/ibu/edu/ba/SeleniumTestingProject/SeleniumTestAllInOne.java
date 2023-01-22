package ibu.edu.ba.SeleniumTestingProject;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
class SeleniumTestAllInOne {
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
	@Order(1)
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

	
	@Test
	@Order(2)
	void RegisterAndLogin() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		//Accept cookies
		WebElement acceptCookies = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"consent-layer-modal\"]/div[3]/div/footer/button[1]"))
				);
		acceptCookies.click();
		Thread.sleep(2000);
		
		//Press the Account button
		WebElement account = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/a"))
				);
		account.click();
		
	
		//Select Register (New here)
		WebElement register = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/div/div/a"))
				);
		register.click();
		
		//Select MR (mister) radio button
		WebElement mr = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/form/form/div[1]/div[1]/div[2]/span/label/span[1]"))
				);
		mr.click();
		
		//Insert Name
		WebElement name = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("delivery-firstName"))
				);
		name.sendKeys("John");
		
		//Insert Last Name
		WebElement lastName = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("delivery-lastName"))
				);
		lastName.sendKeys("Doe");
		
		//Insert email
		WebElement email = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("delivery-email"))
				);
		email.sendKeys("john.doee40@gmail.com");
		
		//Insert password
		WebElement password = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("delivery-password"))
				);
		password.sendKeys("12345678");
		
		//Insert Zip Code
		
		WebElement zipCode = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("delivery-postalCode"))
				);
		zipCode.sendKeys("L2 2DP");
		zipCode.click();
		
		webDriver.findElement(By.xpath("/html/body/div[1]/main")).click();
		Thread.sleep(3000);
		
		//Chose address from presented ones
		WebElement address = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/form/form/div[1]/button"))
				);
		address.click();
		
		WebElement address2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"suggested-address\"]/div[3]/div/div[1]/div[1]/span/label/span[2]"))
				);
		address2.click();
		
		//Confirm entered address
		WebElement confirm = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"suggested-address\"]/div[3]/div/div[2]/m-button/button"))
				);
		confirm.click();
		
		//Confirm privacy policy
		WebElement privacy = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/form/form/div[2]/div[2]/label/div/span[1]"))
				);
		privacy.click();
		
		//Complete registration by pressing register button
		WebElement registerButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/form/form/div[3]/button"))
				);
		registerButton.click();
		
		//Logout to perform login
		WebElement logout = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/section/aside/a[5]"))
				);
		logout.click();
		
		/*//Assert that we are logged out and back to the main page
		String main = webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-Homepage-Master\"]/div[1]/div/div/div[1]")).getText();
		assertEquals("Shop your favourite brands", main);*/ 
		
		Thread.sleep(5000);
		
		
		
		//LOGIN
		//Account icon
		WebElement accountLogin = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/a"))
				);
		accountLogin.click();
		
		//Click on login button
		WebElement login = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/div/div/button"))
				);
		login.click();
		Thread.sleep(3000);
		
		
		//Insert email in the slot 
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[1]/div/input")).click();
		WebElement emailLogin = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[1]/div/input"))
				);
		emailLogin.sendKeys("john.doe@gmail.com");
		
		
		//Insert password in the slot
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[2]/div/input")).click();
		WebElement passwordLogin = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/d-input[2]/div/input"))
				);
		passwordLogin.sendKeys("12345678");
		
		
		//Click on login button 
		WebElement loginButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/div/form/fieldset/m-button/button"))
				);
		loginButton.click();
		
		Thread.sleep(5000);
		
		//Assert that we are logged and back to the main page
		String mainLogged = webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-Homepage-Master\"]/div[1]/div/div/div[1]")).getText();
		assertEquals("Shop your favourite brands", mainLogged);
		js.executeScript("alert('You are logged!')");	
		Thread.sleep(3000);
		
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
	
		
		//Put sneakers in wishlist
		WebElement sneakersfav = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-Homepage-Women-Master\"]/div[3]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/article/form/button"))
						);
		sneakersfav.click();
		
		//Click on all trainers to enter new page
		WebElement trainersSection = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-Homepage-Women-Master\"]/div[3]/div/div/div[1]/a"))
						);
		trainersSection.click();
		
		//Click on filter button to filter results
		WebElement filter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]"))
						);
		filter.click();
		
		//Clear the already put max price and enter new
		WebElement max = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("max-price"))
						);
		max.clear();
		Thread.sleep(3000);
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
		
		Thread.sleep(2000);
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
		Thread.sleep(4000);
		
		//Add sneakers to wishlist
		WebElement wishlist = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[6]/form/button"))
						);
		wishlist.click();
		
		//Shop Jack Wolfskin sneakers
		WebElement shopSneakers = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[2]/a"))
						);
		shopSneakers.click();
		
		//Slide down for more pictures
		WebElement pictures = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/div[1]/section/product-slider/div[1]/div[1]/div[3]/div"))
						);
		pictures.click();
		
		
		//Open to see size chart numbers and then close
		WebElement sizeChartOpen = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[3]/m-product-size-table/div/a/span"))
						);
		sizeChartOpen.click();
		
		WebElement sizeChartClosed = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"size-selection-overlay\"]/div[3]/header/a"))
						);
		sizeChartClosed.click();
		
		Thread.sleep(4000);
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
	
	@Test
	@Order(4)
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
		
		
		//Add black socks to favorite 
		WebElement socks = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]/article[16]/form/button"))
						);
		socks.click();
		//Click on filter button to filter results
		WebElement filter = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]"))
								);
		filter.click();
		//Clear and put min price to 40
		WebElement min = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("min-price"))
						);
		min.clear();
		Thread.sleep(4000);
		min.sendKeys("50");
		
		
		//Clear and put max price as 50
		WebElement max = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("max-price"))
						);
		max.clear();
		Thread.sleep(4000);
		max.sendKeys("50");
		
		
		//Select olive color 
		WebElement olive = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[6]/i"))
						);
		olive.click();
		//Assert the filter results
		String filterResults = webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label/button/span")).getText();
		assertEquals(" Show results", filterResults);
		js.executeScript("alert('You have 17 results displayed here!')");	
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
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"m-option-19\"]/span"))
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
	
	@Test
	@Order(5)
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
	
	
	@Test
	@Order(6)
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
	
	
	@Test
	@Order(7)
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
	

	@Test
	@Order(8)
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
	
	

	@Test
	@Order(9)
	void Contact() throws InterruptedException {
        Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		Thread.sleep(5000);
		
		webDriver.get("https://www.deichmann.com/en-gb/faq");
		Thread.sleep(2000);
		
		//Clicking on contact from to enter form
		WebElement contact = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-cmsitem_00050034\"]/div[2]/div/div/div[2]/div/div/div/div/div[4]/div[2]/a/picture/img"))
						);
		contact.click();
		Thread.sleep(4000);
		
		
		//Click on the circle to select male
		WebElement male = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[1]/span[2]/label/span"))
						);
		male.click();
		Thread.sleep(2000);
		
		//Insert Name
		WebElement name = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[2]/input"))
				);
		name.sendKeys("John");
		Thread.sleep(2000);

		// Insert Last Name
		WebElement lastName = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[3]/input"))
				);
		lastName.sendKeys("Doe");
		Thread.sleep(2000);

		// Insert email
		WebElement email = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[4]/input"))
				);
		email.sendKeys("john.doe@gmail.com");
		Thread.sleep(2000);
		
		//insert town
		WebElement town = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[8]/input"))
				);
		town.sendKeys("London");
		Thread.sleep(2000);
		
		
		//Choose the reason you are contacting them from dropdown
		webDriver.findElement(By.xpath("/html/body/div[1]/main/m-slot[2]/m-y-contact-form/div/form/div[10]/select")).click();
		Select reason = new Select (webDriver.findElement(By.xpath("/html/body/div[1]/main/m-slot[2]/m-y-contact-form/div/form/div[10]/select")));
		reason.selectByIndex(8);
		Thread.sleep(3000);
		
		//Insert text stating your request or problem
		WebElement problem = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[13]/textarea"))
				);
		problem.sendKeys("I want to know how much orders I have successfully done in past years");
		Thread.sleep(2000);
		
		//Click on the button to submit your message
		WebElement submit = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/button"))
				);
		submit.click();
		Thread.sleep(3000);
		
		
		//Assert that the message has been sent	
		String submitted = webDriver.findElement(By.xpath("//*[@id=\"HiddenContentSlot-KontaktPage\"]/div[2]/div")).getText();
		assertEquals("Your request is on its way to us.\r\n"
				+ "We'll get back to you as soon as possible!", submitted);
		js.executeScript("alert('You have sucessfully sent your message!')");	
		Thread.sleep(6000);
	}


	


		
		

	@Test
	@Order(10)
	void Career() throws InterruptedException {
		webDriver.get(baseUrl);
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
        
      //Accept cookies
        WebElement acceptCookies = wait.until(
      		ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"consent-layer-modal\"]/div[3]/div/footer/button[1]"))
      								);
	    acceptCookies.click();
	    Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0, 8500)");
		Thread.sleep(2000);
		js.executeScript("window.location = 'https://corpsite.deichmann.com/gb-en/careers/'");
		Thread.sleep(4000);
		//Try with side link of career_roles
		
		//Acceptting the cookies
		WebElement acceptCookies2 = wait.until(
	      		ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]"))
	      								);
		acceptCookies2.click();
		
		//Enter careers section page
		WebElement careers = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-20620\"]/a"))
				);
		careers.click();
		Thread.sleep(3000);
		webDriver.get("https://corpsite.deichmann.com/gb-en/careers/career-roles/");
		Thread.sleep(5000);
		
		//Enter retails roles details
		WebElement retails = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"attachment_20480\"]/a/img"))
				);
		retails.click();
		Thread.sleep(3000);
		
		//Scroll down and open People section for more details
		JavascriptExecutor career = (JavascriptExecutor) webDriver;
		career.executeScript("window.scrollBy(0, 700)");
		Thread.sleep(2000);
		career.executeScript("window.location = 'https://corpsite.deichmann.com/gb-en/careers/people/'");
		Thread.sleep(4000);
		
		//Scroll down and open vacancies for more details
		JavascriptExecutor vacancies = (JavascriptExecutor) webDriver;
		vacancies.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(2000);
		vacancies.executeScript("window.location = 'https://www.deichmann.com/engage/jobexchange/searchJobOffersQuick.do?j=UK_myjobexchange'");
		
		//Click on wanated roles to search for job in your area
		WebElement role1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr[7]/td[2]/form/table/tbody/tr[3]/td[2]/input[2]"))
				);
		role1.click();
		Thread.sleep(3000);
		
		WebElement role2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr[7]/td[2]/form/table/tbody/tr[4]/td[2]/input[2]"))
				);
		role2.click();
		Thread.sleep(3000);
		
		//Type in the area that fits you - city and range
		WebElement city = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"geoLocAddress\"]"))
				);
		city.sendKeys("London UK");
		Thread.sleep(3000);
		
		WebElement area = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"geoLocCircumference\"]"))
				);
		area.sendKeys("150");
		Thread.sleep(3000);
		
		//Click on the button to search for this parameters
		WebElement search = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr[7]/td[2]/form/table/tbody/tr[9]/td/input[1]"))
				);
		search.click();
		Thread.sleep(3000);
		
		//Scroll down and click on the job 
		JavascriptExecutor job = (JavascriptExecutor) webDriver;
		job.executeScript("window.scrollBy(0, 600)");
		job.executeScript("window.location = 'https://www.deichmann.com/engage/jobexchange/showJobOfferDetail.do?jobOfferId=2c92820e81ccd6180185819ad4c3122c&j=UK_myjobexchange&organizationUnitId='");
		Thread.sleep(4000);
		
		WebElement jobPost = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr[7]/td[2]/div/table[2]/tbody/tr[3]/td[2]/input[2]"))
				);
		jobPost.click();
		Thread.sleep(3000);
	
		
		//This is real life page I will not proceed since this is real job post 
		
	}
		
	
}

	
	
