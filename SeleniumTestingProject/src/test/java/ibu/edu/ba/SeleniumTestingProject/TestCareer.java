package ibu.edu.ba.SeleniumTestingProject;



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
class TestCareer {
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
	
	/*@Test
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

	}*/
	
	@Test
	@Order(2)
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
