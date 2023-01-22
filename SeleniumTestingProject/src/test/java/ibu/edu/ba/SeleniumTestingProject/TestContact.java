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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
class TestContact {

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
}
