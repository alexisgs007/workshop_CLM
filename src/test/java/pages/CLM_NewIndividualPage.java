package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CLM_NewIndividualPage {

	private static WebElement element = null; 

	//NEW INDIVIDUAL PAGE
	//COLLECT BASIC CUSTOMER DETAILS 

	//FIRST NAME TEXTBOX
	public static WebElement textbox_firstName(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pFirstName"));
		return element; 

	}

	//LAST NAME TEXTBOX
	public static WebElement textbox_lastName(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pLastName"));
		return element; 

	}

	//MIDDLE NAME TEXTBOX
	public static WebElement textbox_middleName(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pMiddleName"));
		return element; 

	}

	//PREFIX DROPDOWN
	public static WebElement dropdown_prefix(WebDriver driver, String option) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pPrefix"));
		Select prefixSelect = new Select(element);
		prefixSelect.selectByValue(option);

		return element;

	}

	//SUFFIX DROPDOWN
	public static WebElement dropdown_suffix(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pSuffix"));
		return element; 

	}

	//DATE OF BIRTH - CALENDAR 
	public static WebElement dateOfBirth(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pDateOfBirth"));
		return element; 

	}

	//COUNTRY OF BIRTH - CONTROL TEXTBOX
	public static WebElement textbox_countryOfBirth(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pCountryOfBirthName"));
		return element; 

	}

	//MARITAL STATUS DROPDOWN
	public static WebElement dropdown_maritalStatus(WebDriver driver, String option) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pMaritalStatus"));
		Select maritalStatusSelect = new Select(element);
		maritalStatusSelect.selectByValue(option);
		return element; 

	}

	//GENDER TYPE RADIOBUTTONS 
	//FEMALE, MALE, UNSPECIFIED
	public static WebElement radiobutton_gender(WebDriver driver, String gender) {

		int index = gender.equals("Female") ? 0 : (gender.equals("Male") ? 1 : 2) ;
		element = driver.findElements(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pGender")).get(index);
		element = element.findElement(By.xpath("../label"));
		return element; 

	}

	//COUNTRY OF CITIZENSHIP IS DIFFERENT FROM COUNTRY OF BIRTH
	public static WebElement checkbox_citizenship(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pCountryOfCitizenshipDifferent"));
		return element; 

	}

	//COUNTRY OF FISCAL RESIDENCY IS DIFFERENT FROM COUNTRY OF BIRTH
	public static WebElement checkbox_fiscalResidency(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pCountryOfFiscalResidencyDifferent"));
		return element; 

	}

	//IDENTIFICATION
	//ID TYPE DROPDOWN
	public static WebElement dropdown_idType(WebDriver driver, String idType) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pPrimaryIDType"));
		Select idTypeSelect = new Select(element);
		idTypeSelect.selectByValue(idType);
		return element; 

	}

	//PRIMARY IDENTIFIER TEXTBOX
	public static WebElement textbox_primaryIdentifier(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pPrimaryIDValue"));
		return element; 

	}

	//PRIMARY CONTACT INFORMATION
	//PHONE NUMBER TEXTBOX
	public static WebElement textbox_phoneNumber(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pPhone$gHome$pNumber"));
		return element; 

	}

	//EMAIL TEXTBOX 
	public static WebElement textbox_email(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pEmail$gEmail1$pAddress"));
		return element; 

	}

	//ADDRESS TYPE DROPDOWN
	public static WebElement dropdown_addressType(WebDriver driver) {

		element = driver.findElement(By.name("$PpyWorkPage$ppyWorkParty$gCustomer$pAddressType"));
		return element; 

	}

	//ADDRESS LINE 1 TEXTBOX 
	public static WebElement textbox_addressLine1(WebDriver driver) {

		element = driver.findElement(By.name("$PTempAddress$pAddressLine1"));
		return element; 

	}

	//ADDRESS LINE 2 TEXTBOX 
	public static WebElement textbox_addressLine2(WebDriver driver) {

		element = driver.findElement(By.name("$PTempAddress$pAddressLine2"));
		return element; 

	}

	//CITY NAME TEXTBOX
	public static WebElement textbox_cityName(WebDriver driver) {

		element = driver.findElement(By.name("$PTempAddress$pCity"));
		return element; 

	}

	// STATE/PROVINCE TEXTBOX 
	public static WebElement textbox_state_province(WebDriver driver) {

		element = driver.findElement(By.name("$PTempAddress$pStateCode"));
		return element; 

	}

	//POSTAL CODE
	public static WebElement textbox_postalCode(WebDriver driver) {

		element = driver.findElement(By.name("$PTempAddress$pZipCode"));
		return element; 

	}

	//COUNTRY
	public static WebElement textbox_country(WebDriver driver) {

		element = driver.findElement(By.name("$PTempAddress$pCountry"));
		return element; 

	}

	//NEXT BUTTON 
	public static WebElement button_next(WebDriver driver) {

		element = driver.findElement(By.name("TreeNavigationFooter_pyWorkPage_14"));
		return element; 

	}

	//CANCEL BUTTON 
	public static WebElement button_cancel(WebDriver driver) {

		element = driver.findElement(By.name("TreeNavigationFooter_pyWorkPage_12"));
		return element; 

	}

}
