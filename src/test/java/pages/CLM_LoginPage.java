package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CLM_LoginPage {

	private static WebElement element = null;
	
	//USERNAME TEXTBOX
		public static WebElement textbox_username(WebDriver driver) {
			
			element = driver.findElement(By.id("txtUserID"));
			return element; 
			
		}
		
		//PASSWORD TEXTBOX
		public static WebElement textbox_password(WebDriver driver) {
			
			element = driver.findElement(By.id("txtPassword"));
			return element;
		}
		
		//LOGIN BUTTON
		public static WebElement button_login(WebDriver driver) {
			
			element = driver.findElement(By.id("sub"));
			return element;
			
		}
	
}
