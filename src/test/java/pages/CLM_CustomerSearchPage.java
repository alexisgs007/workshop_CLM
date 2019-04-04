package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CLM_CustomerSearchPage {
	
	private static WebElement element = null; 
	
	//SEARCH CUSTOMER TEXTBOX || THIS TEXTBOX IS AVAILABLE BEFORE CLICKING THE ADVANCED SEARCH LINK
	public static WebElement textbox_searchCustomer(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$pSearchValueName"));
		return element; 

	}
	
	//ADVANCED SEARCH LINK
	public static WebElement link_advancedSearch(WebDriver driver) {

		element = driver.findElement(By.name("AdvancedSearch_pyWorkPage_3"));
		return element; 

	}
	
	//CUSTOMER TYPE DROPDOWN
	public static WebElement dropdown_customerType(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$pPartyType"));
		return element; 

	}
	
	//CUSTOMER NAME TEXTBOX
	public static WebElement textbox_customerName(WebDriver driver) {

		element = driver.findElements(By.name("$PpyWorkPage$pSearchValueName")).get(1);
		return element; 

	}
	
	//ACCOUNT NUMBER TEXTBOX 
	public static WebElement textbox_accountNumber(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$pSearchValueAccountNumber"));
		return element; 

	}
	
	
	//PHONE NUMBER TEXTBOX 
	public static WebElement textbox_phoneNumber(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$pSearchValuePhoneNumber"));
		return element; 

	}
	
	
	//EMAIL TEXTBOX
	public static WebElement textbox_email(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$pSearchValueEmail"));
		return element; 

	}
	
	//SEARCH BUTTON
		public static WebElement button_search(WebDriver driver) {

			element = driver.findElement(By.name("CustomerSearch_pyWorkPage_46"));
			return element; 

		}
}
