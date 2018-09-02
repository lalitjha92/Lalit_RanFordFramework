package PageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class LoginPage extends Base{
	
	public static WebElement username_textfield(WebDriver driver) {
		//return driver.findElement(By.name(read_OR("username_txt")));
		
		return driver.findElement(getlocator("username_txt"));

	}
	
	public static WebElement password_textfield(WebDriver driver) {
	//	return driver.findElement(By.name(read_OR("password_txt")));
		
		return driver.findElement(getlocator("password_txt"));

	}
	
	public static WebElement login_button(WebDriver driver) {
		//return driver.findElement(By.name(read_OR("login_btn")));
  
		return driver.findElement(getlocator("login_btn"));
	}	

}
