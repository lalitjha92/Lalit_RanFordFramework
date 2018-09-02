package PageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class BranchesPage extends Base{
	
	public static WebElement newBranch_btn(WebDriver driver) {		
	//	return driver.findElement(By.id(read_OR("newBranch")));
		
		return driver.findElement(getlocator("newBranch"));

	}
	
	public static WebElement branchName_txt(WebDriver driver) {
		//return driver.findElement(By.id(read_OR("branchName")));
		
		return driver.findElement(getlocator("branchName"));

	}
	
	public static WebElement branchAddress1_txt(WebDriver driver) {
	//	return driver.findElement(By.id(read_OR("branch_address1")));
		
		return driver.findElement(getlocator("branch_address1"));

	}	
	
	public static WebElement zipcode_txt(WebDriver driver) {
		//return driver.findElement(By.id(read_OR("branch_zipcode")));
		
		return driver.findElement(getlocator("branch_zipcode"));

	}
	
	public static WebElement cancel_btn(WebDriver driver) {
		//return driver.findElement(By.id(read_OR("branch_cancelBtn")));
		
		return driver.findElement(getlocator("branch_cancelBtn"));

	}

}
