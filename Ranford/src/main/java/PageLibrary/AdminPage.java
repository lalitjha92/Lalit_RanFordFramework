 package PageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;


public class AdminPage extends Base{

	public static WebElement branches_button(WebDriver driver) {
	//	return driver.findElement(By.xpath(read_OR("branches_btn")));
		
		return driver.findElement(getlocator("branches_btn"));


	}
	
	public static WebElement logout_button(WebDriver driver) {
		//return driver.findElement(By.xpath(read_OR("logout_btn")));
		
		return driver.findElement(getlocator("logout_btn"));
  
	}

}
