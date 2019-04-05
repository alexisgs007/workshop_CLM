package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pages.CLM_CustomerSearchPage;
import pages.CLM_HomePage;
import pages.CLM_LoginPage;
import utility.constant;

/**
 * 
 * @author Alexis
 *
 */

public class CLM_SearchCustomerTest {

	private static WebDriver driver = null;
	private static String customerName = "John Doe";

	@BeforeTest
	public void setUp() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public static void searchCustomerTest() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		final Logger LOGGER = Logger.getLogger(CLM_SearchCustomerTest.class);

		//Logging in 
		driver.get(constant.CLM_URL);
		CLM_LoginPage.textbox_username(driver).sendKeys(constant.clm_username);
		CLM_LoginPage.textbox_password(driver).sendKeys(constant.clm_password);
		CLM_LoginPage.button_login(driver).click();
		System.out.println("already logged in");

		//Clicking the Customers Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pyPortalHeader_pyDisplayHarness_7")));
		CLM_HomePage.menu_customers(driver).click();

		//Clicking the Advanced Search Link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("AdvancedSearch_pyWorkPage_3")));
		CLM_CustomerSearchPage.link_advancedSearch(driver).click();

		//Sending a non existent customer name to the field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$pSearchValueName")));
		CLM_CustomerSearchPage.textbox_customerName(driver).sendKeys(customerName);
		CLM_CustomerSearchPage.button_search(driver).click();

		//Validating the message "No results found" appears
		
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='RULE_KEY']/div[1]//div[text()='No results found']")));		
		AssertJUnit.assertEquals("NO RESULTS FOUND", "No results found", text.getText());
		LOGGER.info("NO RESULTS FOUND || TEST CASE PASS");
		
	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}
}
