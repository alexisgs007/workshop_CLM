package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pages.CLM_LoginPage;
import utility.constant;

/**
 * 
 * @author Alexis
 *
 */

public class CLM_LoginTest {
	
	private static WebDriver driver = null;
	private static String title = "Client Lifecycle Management";
	
	@BeforeTest
	public void setUp() {
				
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public static void login() {
	
		final Logger LOGGER = Logger.getLogger(CLM_LoginTest.class);
		
		//Logging in
		driver.get(constant.CLM_URL);
		
		CLM_LoginPage.textbox_username(driver).sendKeys(constant.clm_username);
		CLM_LoginPage.textbox_password(driver).sendKeys(constant.clm_password);
		CLM_LoginPage.button_login(driver).click();
		System.out.println("already logged in");
		
		System.out.println("TITLE: " +driver.getTitle().trim());
		
		AssertJUnit.assertEquals("LOGIN SUCCESSFUL", title, driver.findElement(By.xpath("//*[@id='RULE_KEY']//div[text()='Client Lifecycle Management']")).getText());
		LOGGER.info("TEST CASE PASS");
		System.out.println("adding a comment");
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
	}

}
