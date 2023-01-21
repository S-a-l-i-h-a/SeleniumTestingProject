package ibu.edu.ba.SeleniumTestingProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(OrderAnnotation.class)
class SeleniumTest1 {
	private static WebDriver webDriver;
	private static String baseUrl;
	private static WebDriver driver;

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
	@Order(1)
	void AcceptingCookiesAndFindingStore() throws InterruptedException {
		
		webDriver.get(baseUrl);
		Thread.sleep(2000);
		
		String handle1 = webDriver.getWindowHandle();
		System.out.println(handle1);
		
		for (String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		//accepting cookies
		webDriver.findElement(By.xpath("//*[@id=\"consent-layer-modal\"]/div[3]/div/footer/button[1]")).click();
		Thread.sleep(2000);
		
		/*//find store on maps
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[1]/a")).click();
		Thread.sleep(2000);

	    webDriver.findElement(By.cssSelector("#MiniCartSlot > m-mini-cart > div > map.storefinder > div > div > button")).click();
		Thread.sleep(3000);
		
		//enter address on page
		webDriver.findElement(By.cssSelector("#storefinder-default-guest > section")).click();
		webDriver.findElement(By.cssSelector("#searchInput")).sendKeys("United Kingdom House, London, UK");
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("//*[@id=\"storefinder-default-guest\"]/span/m-get-predictions/form/button[1]")).click();
		Thread.sleep(2000);
		
		//see working time 
		webDriver.findElement(By.xpath("//*[@id=\"storecard-0\"]/section/span[2]")).click();
		Thread.sleep(2000);
		
		//plan route to the shop
		webDriver.findElement(By.xpath("//*[@id=\"storecard-0\"]/section/div[5]/a[1]/button")).click();
		Thread.sleep(3000);
		
		//ending here since next step is going to google maps
		//getting back on main page
		
		webDriver.switchTo().window(handle1);
		Thread.sleep(2000);
		
		//switch to main page
		webDriver.get(baseUrl);
		Thread.sleep(2000);	*/
	}
	
	/*@Test
	@Order(2)
	void RegisterAndLogin() throws InterruptedException {
		/*webDriver.get(baseUrl);
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
		Thread.sleep(3000);	*/
		
		/*//person button
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

	
	/*@Test
	@Order(3)
	void WomanShopping() throws InterruptedException {
		//enter woman section
		webDriver.findElement(By.xpath("//*[@id=\"HeaderLinksSlot\"]/nav/ul/li[1]/a")).click();
		Thread.sleep(5000);
		//put sneakers in favourite
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-Homepage-Women-Master\"]/div[3]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/article/form/button")).click();
		Thread.sleep(3000);
		//All trainers
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-Homepage-Women-Master\"]/div[3]/div/div/div[1]/a")).click();
		Thread.sleep(3000);
		//click on filter
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]")).click();
		Thread.sleep(2000);
		//put max price 50
		webDriver.findElement(By.id("max-price")).clear();
		Thread.sleep(3000);
		webDriver.findElement(By.id("max-price")).sendKeys("50");
		Thread.sleep(2000);
		//chose color 
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[3]/i")).click();
		Thread.sleep(2000);
		//choose purple
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[8]/i")).click();
		Thread.sleep(2000);
		//chose neutral
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[9]/i")).click();
		Thread.sleep(2000);
		//show result button
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label")).click();
		Thread.sleep(3000);
		//add to favourites
		webDriver.findElement(By.xpath("//*[@id=\"product-list\"]/article[6]/form/button")).click();
		Thread.sleep(3000);
		//shop jack wolfskin
		webDriver.findElement(By.xpath("//*[@id=\"product-list\"]/article[2]/a")).click();
		Thread.sleep(4000);
		//see more pictures 
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[1]/section/product-slider/div[1]/div[1]/div[3]/div")).click();
		Thread.sleep(3000);
		//view and close size chart
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[3]/m-product-size-table/div/a/span")).click();
		Thread.sleep(5000);
		webDriver.findElement(By.xpath("//*[@id=\"size-selection-overlay\"]/div[3]/header/a")).click();
		Thread.sleep(3000);
		//add to cart 
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[4]/div/form/button")).click();
		Thread.sleep(3000);
		//chose EU
		webDriver.findElement(By.xpath("//*[@id=\"sizes-modal\"]/div[3]/div/nav/div/ul[1]/li[2]")).click();
		Thread.sleep(4000);
		//chose size
		webDriver.findElement(By.xpath("//*[@id=\"m-option-19\"]/span")).click();
		Thread.sleep(4000);
		//view the basket
		webDriver.findElement(By.xpath("//*[@id=\"added-modal_desktop\"]/div[3]/div/div/div[2]/a[2]")).click();
		Thread.sleep(4000);
		
		
	
}*/
	/*@Test
	 @Order(4)
	void ManShopping() throws InterruptedException {
		//entering man section
		webDriver.findElement(By.xpath("//*[@id=\"HeaderLinksSlot\"]/nav/ul/li[2]/a")).click();
		Thread.sleep(3000);
		//choose addidas setion
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-Homepage-men-Master\"]/div[5]/div/div/div[2]/div/div/div/div[1]/div[3]/div[2]/a/picture/img")).click();
		Thread.sleep(3000);
		//Addd sock to favorite 
		webDriver.findElement(By.xpath("//*[@id=\"product-list\"]/article[16]/form/button")).click();
		Thread.sleep(7000);
		//enter filter section
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]")).click();
		Thread.sleep(2000);
		//put min price 50
		webDriver.findElement(By.id("min-price")).clear();
		Thread.sleep(3000);
		webDriver.findElement(By.id("min-price")).sendKeys("40");
		Thread.sleep(7000);
		//put max price
		webDriver.findElement(By.id("max-price")).click();
		webDriver.findElement(By.id("max-price")).clear();
		Thread.sleep(3000);
		webDriver.findElement(By.id("max-price")).sendKeys("50");
		Thread.sleep(2000);
		//select olive 
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[6]/i")).click();
		Thread.sleep(2000);
		//show results
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label")).click();
		Thread.sleep(5000);
		//filter again
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]")).click();
		Thread.sleep(2000);
		//add color 
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[2]/i")).click();
		Thread.sleep(5000);
		//show results
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label")).click();
		Thread.sleep(5000);
		//choose shoes
		webDriver.findElement(By.xpath("//*[@id=\"product-list\"]/article[3]/a")).click();
		Thread.sleep(3000);
		//check material 
		webDriver.findElement(By.xpath("//*[@id=\"product-details\"]/section/m-product-classification/section/details/summary")).click();
		Thread.sleep(3000);
		//add to cart
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[4]/div/form/button/span")).click();
		Thread.sleep(3000);
		//Select EU
		webDriver.findElement(By.xpath("//*[@id=\"sizes-modal\"]/div[3]/div/nav/div/ul[1]/li[2]")).click();
		Thread.sleep(3000);
		//select size
		webDriver.findElement(By.xpath("//*[@id=\\\"m-option-19\\\"]/span")).click();
		Thread.sleep(3000);
		//view basket
		webDriver.findElement(By.xpath("//*[@id=\"added-modal_desktop\"]/div[3]/div/div/div[2]/a[2]")).click();
		Thread.sleep(3000);
		//Assert ther is   price
		WebElement price =webDriver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[2]/section[1]/div[1]/p[2]"));
		String text = price.getText();
		assertEquals("£42.99", text);
		
		
	
}*/
	
	/*@Test
	 @Order(5)
	void ChildernShopping() throws InterruptedException {
		//enter child section
		webDriver.findElement(By.xpath("//*[@id=\"HeaderLinksSlot\"]/nav/ul/li[3]/a")).click();
		Thread.sleep(4000);
		//choose toddlers
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-Homepage-kids-Master\"]/div[2]/div/div/div[2]/div/div/div/div/div[3]/div[2]/a/picture/img")).click();
		Thread.sleep(3000);
		//choose babies
		webDriver.findElement(By.xpath("//*[@id=\"SubnavigationSlot\"]/m-y-category-navigation/ul/li[2]/ul/li[4]/ul/li[2]/a")).click();
		Thread.sleep(3000);
		//enter filter 
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/label/span[1]")).click();
		Thread.sleep(3000);
		//choose releveance
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[1]/details/summary")).click();
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[1]/details/ul/li[4]/label")).click();
		Thread.sleep(4000);
		//choose pink
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/section[4]/section/label[2]/i")).click();
		Thread.sleep(4000);
		//show results
		webDriver.findElement(By.xpath("//*[@id=\"anchor_productGrid\"]/div[1]/section[1]/form/label")).click();
		Thread.sleep(3000);
		//choose pepapig
		webDriver.findElement(By.xpath("//*[@id=\"product-list\"]/article[1]/a")).click();
		Thread.sleep(3000);
		//see in stores
		webDriver.findElement(By.xpath("//*[@id=\"searchInStoreDesktop\"]/a/a/m-branch-search-in-store/button/span")).click();
		Thread.sleep(3000);
		//chose EU
		webDriver.findElement(By.xpath("//*[@id=\"sizes-modal\"]/div[3]/div/nav/div/ul[1]/li[2]")).click();
		Thread.sleep(2000);
		//Exit
		webDriver.findElement(By.xpath("//*[@id=\"sizes-modal\"]/div[3]/header/a")).click();
		Thread.sleep(2000);
		//putt in fav
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/section[4]/form/button")).click();
		Thread.sleep(2000);
		//now entering wishlist- favourite in next test	
}*/
	/*@Test
	@Order(7)
	void Wishlist() throws InterruptedException {
		//entering wishlist 
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[3]/a")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[3]/div/div/section/button")).click();
		Thread.sleep(2000);
		//exclude black shoes 
		webDriver.findElement(By.xpath("//*[@id=\"product-list\"]/article[1]/form/button")).click();
		Thread.sleep(2000);
		//add to cart 
		webDriver.findElement(By.xpath("//*[@id=\"product-list\"]/article[2]/div/button")).click();
		Thread.sleep(2000);
		//chose EU
		webDriver.findElement(By.xpath("//*[@id=\"sizes-modal-02098277\"]/div[3]/div/nav/div/ul[1]/li[2]")).click();
		Thread.sleep(3000);
		//choose 38
		webDriver.findElement(By.xpath("//*[@id=\"m-option-7\"]/span")).click();
		Thread.sleep(3000);
		//view basket
		webDriver.findElement(By.xpath("//*[@id=\"added-modal_desktop\"]/div[3]/div/div/div[2]/a[2]")).click();
		Thread.sleep(3000);
		
		
	
}*/
	/*@Test
	  @Order(8)
	void Cart() throws InterruptedException {
		//open basket 
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[4]/a")).click();
		Thread.sleep(3000);
		//assert
		WebElement saving =webDriver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[2]/section[1]/div[2]/p"));
		String text2 = saving.getText();
		assertEquals("Savings £14.00", text2);
		Thread.sleep(3000);
		//pay
		webDriver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/div[2]/span[1]")).click();
		
		//Since this is real site we will not continue with further payment 
		
	
}*/
	

	/*
	@Test
	@Order(6)
	void Contact() throws InterruptedException {
		Thread.sleep(10000);
		webDriver.get("https://www.deichmann.com/en-gb/faq");
		Thread.sleep(2000);
		//enter c0ntact form
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-cmsitem_00050034\"]/div[2]/div/div/div[2]/div/div/div/div/div[4]/div[2]/a/picture/img")).click();
		Thread.sleep(2000);
		//select male
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[1]/span[2]/label/span")).click();
		Thread.sleep(2000);
		//insert name
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[2]/input")).sendKeys("John");
		Thread.sleep(2000);
		//insert last name
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[3]/input")).sendKeys("Doe");
		Thread.sleep(2000);
		//Insert email
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[4]/input")).sendKeys("john.doee@gmail.com");
		Thread.sleep(2000);
		//insert town
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[8]/input")).sendKeys("London");
		Thread.sleep(2000);
		//reason 
		webDriver.findElement(By.xpath("/html/body/div[1]/main/m-slot[2]/m-y-contact-form/div/form/div[10]/select")).click();
		Select reason = new Select (webDriver.findElement(By.xpath("/html/body/div[1]/main/m-slot[2]/m-y-contact-form/div/form/div[10]/select")));
		reason.selectByIndex(8);
		Thread.sleep(2000);
		//text
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/div[13]/textarea")).sendKeys("I want to know how much orders I have successfully done in past years");
		Thread.sleep(3000);
		//send message
		webDriver.findElement(By.xpath("//*[@id=\"Section1Slot-KontaktPage\"]/m-y-contact-form/div/form/button")).click();
		
		///mesagge sent		
	
}*/
	
	/*@Test
	void Newsletter() throws InterruptedException {
		Thread.sleep(5000);
		//open profile
		webDriver.findElement(By.xpath("//*[@id=\"MiniCartSlot\"]/m-mini-cart/div/map[2]/a")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/section/m-accountcontentpage/section")).click();
		//open newsletter
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/aside/a[4]")).click();
		Thread.sleep(2000);
		//intrest
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/div[1]/div[1]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/div[1]/div[2]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/div[1]/div[3]")).click();
		Thread.sleep(2000);
		//privacy policy
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/div[2]/label/span[1]")).click();
		Thread.sleep(2000);
		//submit to newsletter
		webDriver.findElement(By.xpath("/html/body/div[1]/main/section/section/main/section/form/form/button")).click();
		Thread.sleep(5000);
		
		
	
}*/
	/*@Test
	void Career() throws InterruptedException {
		//Open careers
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 8500)");
		Thread.sleep(2000);
		js.executeScript("window.location = 'https://corpsite.deichmann.com/gb-en/careers/'");
		Thread.sleep(4000);
		//Try with side link of career_roles
		
		//Cookies
		webDriver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
		Thread.sleep(2000);
		//careers
		webDriver.findElement(By.xpath("//*[@id=\"menu-item-20620\"]/a")).click();
		Thread.sleep(3000);
		webDriver.get("https://corpsite.deichmann.com/gb-en/careers/career-roles/");
		Thread.sleep(5000);
		//retail roles
		webDriver.findElement(By.xpath("//*[@id=\"attachment_20480\"]/a/img")).click();
		Thread.sleep(3000);
		//scroll and open people page
		JavascriptExecutor career = (JavascriptExecutor) webDriver;
		career.executeScript("window.scrollBy(0, 700)");
		Thread.sleep(2000);
		career.executeScript("window.location = 'https://corpsite.deichmann.com/gb-en/careers/people/'");
		Thread.sleep(4000);
		//scroll and open vaacancies page
		JavascriptExecutor vacancies = (JavascriptExecutor) webDriver;
		vacancies.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(2000);
		vacancies.executeScript("window.location = 'https://www.deichmann.com/engage/jobexchange/searchJobOffersQuick.do?j=UK_myjobexchange'");
		
		//Seleceting which job
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/form/table/tbody/tr[3]/td[2]/input[2]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/form/table/tbody/tr[4]/td[2]/input[2]")).click();
		Thread.sleep(3000);
		//type area
		webDriver.findElement(By.xpath("//*[@id=\"geoLocAddress\"]")).sendKeys("London UK");
		Thread.sleep(2000);
		//area in km 
		webDriver.findElement(By.xpath("//*[@id=\"geoLocCircumference\"]")).sendKeys("150");
		Thread.sleep(2000);
		//search 
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/form/table/tbody/tr[9]/td/input[1]")).click();
		Thread.sleep(3000);
		JavascriptExecutor job = (JavascriptExecutor) webDriver;
		job.executeScript("window.scrollBy(0, 600)");
		job.executeScript("window.location = 'https://www.deichmann.com/engage/jobexchange/showJobOfferDetail.do?jobOfferId=2c92820e81ccd6180185819ad4c3122c&j=UK_myjobexchange&organizationUnitId='");
		Thread.sleep(4000);
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/div/table[2]/tbody/tr[3]/td[2]/input[2]")).click();
		Thread.sleep(3000);
		
		//this is real life page I will not proceed since this is real job post 
		
		
		
		
	
}*/
}
	
	
