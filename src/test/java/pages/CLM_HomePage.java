package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CLM_HomePage {
	
	private static WebElement element = null; 

	//MENUS
	//DASHBOARD MENU
	public static WebElement menu_dashboard(WebDriver driver) {

		element = driver.findElement(By.name("pyPortalHeader_pyDisplayHarness_5"));
		return element; 

	}
	
	//CASES
	public static WebElement menu_cases(WebDriver driver) {

		element = driver.findElement(By.name("pyPortalHeader_pyPortalHarness_6"));
		return element; 

	}
	
	//CUSTOMERS
	public static WebElement menu_customers(WebDriver driver) {

		element = driver.findElement(By.name("pyPortalHeader_pyDisplayHarness_7"));
		return element; 

	}
	
	//CALENDAR
	public static WebElement menu_calendar(WebDriver driver) {

		element = driver.findElement(By.name("pyPortalHeader_pyDisplayHarness_9"));
		return element; 

	}
	
	//REPORTS 
	public static WebElement menu_reports(WebDriver driver) {

		element = driver.findElement(By.name("pyPortalHeader_pyDisplayHarness_10"));
		return element; 

	}	
	
	//BUTTON
	//NEW ONBOARDING BUTTON
	public static WebElement button_newOnboarding(WebDriver driver) {

		element = driver.findElement(By.name("CLMDashboardHeader_pyDisplayHarness_6"));
		return element; 

	}
	
	//MODAL DIALOG
	//INDIVIDUAL BUTTON 
	public static WebElement button_individual(WebDriver driver) {
		driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
		element = driver.findElement(By.name("PartyTypeDetails_D_PartyTypeSummary.pxResults(1)_1"));
		actions.doubleClick(element).build().perform();
		return element; 

	}
	
	//MODAL DIALOG FOR SEARCHING CUSTOMER - ONBOARDING
	public static WebElement textbox_searchCustomer_Onboarding(WebDriver driver) {
		
		element = driver.findElement(By.name("$PpyWorkPage$pSearchValueName"));
		return element; 

	}
	
	//MODAL DIALOG - CREATE NEW LINK 
		public static WebElement link_createNew(WebDriver driver) {

			Actions actions = new Actions(driver);
			element = driver.findElement(By.name("SearchOnboardCustomer_pyWorkPage_21"));
			actions.doubleClick(element).build().perform();
			return element; 

		}
	
	
}
