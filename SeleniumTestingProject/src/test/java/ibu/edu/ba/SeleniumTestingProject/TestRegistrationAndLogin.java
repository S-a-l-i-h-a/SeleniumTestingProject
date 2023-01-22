package ibu.edu.ba.SeleniumTestingProject;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestRegistrationAndLogin {
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

}
