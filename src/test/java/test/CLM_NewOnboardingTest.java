package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import pages.CLM_HomePage;
import pages.CLM_LoginPage;
import pages.CLM_NewIndividualPage;
import utility.constant;

/**
 * 
 * @author Alexis
 *
 */

public class CLM_NewOnboardingTest {

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
	public static void newOnboardingTest() throws InterruptedException {

		final Logger LOGGER = Logger.getLogger(CLM_SearchCustomerTest.class);
		WebDriverWait waiting = new WebDriverWait(driver, 20);

		//Logging in 
		driver.get(constant.CLM_URL);
		CLM_LoginPage.textbox_username(driver).sendKeys(constant.clm_username);
		CLM_LoginPage.textbox_password(driver).sendKeys(constant.clm_password);
		CLM_LoginPage.button_login(driver).click();
		System.out.println("already logged in");
		
		//Click on New Onboarding button 
		CLM_HomePage.button_newOnboarding(driver).click();
		
		//Click the Individual button

		CLM_HomePage.button_individual(driver);
		
		//Verify the customer does not exist and create new
		CLM_HomePage.textbox_searchCustomer_Onboarding(driver).sendKeys(customerName);
		CLM_HomePage.textbox_searchCustomer_Onboarding(driver).sendKeys(Keys.ENTER);
		
		//Searching the message: "No Matches Found"
		WebElement element = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/div/div[4]/div/div/div/div/div/div/div")));
		AssertJUnit.assertEquals("No Matches Found", "No matches found.", element.getText().trim());
		
		//Click on the Create New Link 
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("SearchOnboardCustomer_pyWorkPage_21")));
		CLM_HomePage.link_createNew(driver);
		
		//Fill out all the form and click on Save
		//Collect basic customer details
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pPrefix")));
		CLM_NewIndividualPage.dropdown_prefix(driver, "Mr.");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pDateOfBirth")));
		CLM_NewIndividualPage.dateOfBirth(driver).sendKeys("1/1/1985");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pMaritalStatus")));
		CLM_NewIndividualPage.dropdown_maritalStatus(driver, "Married");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pCountryOfBirthName")));
		CLM_NewIndividualPage.textbox_countryOfBirth(driver).sendKeys("United States");
		CLM_NewIndividualPage.textbox_countryOfBirth(driver).sendKeys(Keys.TAB);
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pGender")));
		CLM_NewIndividualPage.radiobutton_gender(driver, "Male").click();
		
		//Identification
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pPrimaryIDType")));
		CLM_NewIndividualPage.dropdown_idType(driver, "Valid SSN ID");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pPrimaryIDValue")));
		CLM_NewIndividualPage.textbox_primaryIdentifier(driver).sendKeys("547500449");
		
		//Primary Contact Information
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pPhone$gHome$pNumber")));
		CLM_NewIndividualPage.textbox_phoneNumber(driver).sendKeys("8649012224");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pEmail$gEmail1$pAddress")));
		CLM_NewIndividualPage.textbox_email(driver).sendKeys("john.doe@rulesware.com");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PTempAddress$pAddressLine1")));
		CLM_NewIndividualPage.textbox_addressLine1(driver).sendKeys("4512 Brown Avenue");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PTempAddress$pCity")));
		CLM_NewIndividualPage.textbox_cityName(driver).sendKeys("Greenville");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PTempAddress$pCity")));
		CLM_NewIndividualPage.textbox_state_province(driver).sendKeys("South Carolina");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PTempAddress$pZipCode")));
		CLM_NewIndividualPage.textbox_postalCode(driver).sendKeys("29601");
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("$PTempAddress$pCountry")));
		CLM_NewIndividualPage.textbox_country(driver).sendKeys("United States");
		CLM_NewIndividualPage.textbox_country(driver).sendKeys(Keys.TAB);
			
		//Clicking on the Next Button 
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("TreeNavigationFooter_pyWorkPage_14")));
		CLM_NewIndividualPage.button_next(driver).click();
		
		//Clicking the Cases menu at the top of the screen 
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("pyPortalHeader_pyPortalHarness_6")));
		CLM_HomePage.menu_cases(driver).click();
		
		//Checking the first case that appears, is the last that was created 
		WebElement el = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("DisplayCustomerName_D_pyMyCasesTree.pxResults(1)_1")));
		AssertJUnit.assertEquals("THE CUSTOMER NAME APPEARS IN THE FIRST ROW", "John Doe", el.getText());
		LOGGER.info("TEST CASE PASS");
		
	}
	
	@AfterTest
	public void tearDown() {

		driver.quit();

	}

}
