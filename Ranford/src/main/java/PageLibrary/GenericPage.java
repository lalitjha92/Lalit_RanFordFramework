package PageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import TestBase.Base;

public class GenericPage extends Base{
	
	public static Select dropDownSelection(WebDriver driver, By prop)
	{
		Select x = new Select(driver.findElement(prop));
		return x;	
		
	}

}
