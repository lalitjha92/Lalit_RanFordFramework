package com.ranford.functionalities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageLibrary.AdminPage;
import PageLibrary.BranchesPage;
import PageLibrary.GenericPage;
import PageLibrary.LoginPage;
import TestBase.Base;
import excel.Excel_Class;
import utility.Screenshot;

public class Repository extends Base{
	
	WebDriver driver;
	
	public ExtentReports extentreport;
	public ExtentTest extentTest;
	
	// Method  (we can place anywhere in repository class)
	public void Report_Extent()
	{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String timestamp= df.format(date);
		extentreport = new ExtentReports("C:\\Users\\lalitjha\\Desktop\\Ranford\\Reports\\"+"ExtentReportResults"+timestamp+".html",false);
	}
	
	public void launch_Application()
	{
		Report_Extent();
		extentTest=extentreport.startTest("Start");
		
		String exePath = "C:\\Users\\lalitjha\\Desktop\\java\\chromedriver.exe";
	    System.setProperty("webdriver.chrome.driver", exePath);
		driver=new ChromeDriver();
		log.info("chrome browser launched");
		extentTest.log(LogStatus.PASS,"Launch Success");
		driver.get(read_testdata("sitUrl"));
		log.info("enter the url");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("Maximised the browser");
		extentTest.log(LogStatus.PASS,"Maximise Success");
		
		// To validate title display
		String strTitle = driver.getTitle();
		if(strTitle.equals("KEXIM BANK")) {   // for correct title display
		
		//if(strTitle.equals("HDFC BANK")) {   // for Incorrect title display
			System.out.println("Title displayed correctly as:"+strTitle);
			
			log.info("Title displayed correctly as:" +strTitle);
			extentTest.log(LogStatus.PASS,"Title Displayed Correctly as:"+strTitle);
			Screenshot.CaptureScreenShot("VerifyTitle"); //  Screenshot for pass scenario
		}else {

			String path =Screenshot.CaptureScreenShot("VerifyTitle"); // Screenshot for fail scenario
			System.out.println(path);
			extentTest.addScreenCapture(path);
			System.out.println("Incorrect Tiltle displayed c as:"+strTitle);
			extentTest.log(LogStatus.PASS,"Title Displayed Incorrectly as:"+strTitle);
		} 
	//	Assert.assertEquals(driver.getTitle(), "KEXIM BANK");
	}
	
	public void login_Application()
	{
		LoginPage.username_textfield(driver).sendKeys(read_testdata("username"));
		LoginPage.password_textfield(driver).sendKeys(read_testdata("password"));
		LoginPage.login_button(driver).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	boolean blnLogout =	AdminPage.logout_button(driver).isDisplayed();
	if(blnLogout)
	{
		Assert.assertTrue(true, "Login Successful");
	} else {
		Assert.assertTrue(false, "Login Failed");
	}
	}
	
	public void clickbranches()
	{
		AdminPage.branches_button(driver).click();
	}
		
/*	public void createNewBranch()
	{
		BranchesPage.newBranch_btn(driver).click();
		BranchesPage.branchName_txt(driver).sendKeys(read_testdata("branchname"));
		BranchesPage.branchAddress1_txt(driver).sendKeys(read_testdata("address"));
		BranchesPage.zipcode_txt(driver).sendKeys(read_testdata("zipcode"));
//		GenericPage.dropDownSelection(driver, By.id(read_OR("branch_country"))).selectByValue(read_testdata("country"));
		
		GenericPage.dropDownSelection(driver, getlocator("branch_country")).selectByValue(read_testdata("country"));
		
//		GenericPage.dropDownSelection(driver, By.id(read_OR("branch_state"))).selectByValue(read_testdata("state"));
		
		GenericPage.dropDownSelection(driver, getlocator("branch_state")).selectByValue(read_testdata("state"));		
		
//		GenericPage.dropDownSelection(driver, By.id(read_OR("branch_city"))).selectByValue(read_testdata("city"));
		

		GenericPage.dropDownSelection(driver, getlocator("branch_city")).selectByValue(read_testdata("city"));
		BranchesPage.cancel_btn(driver).click();
	}*/
	
	public void createBranch(String bname, String address, String zip, String country, String state, String city)
	{
		
		BranchesPage.newBranch_btn(driver).click();
		BranchesPage.branchName_txt(driver).sendKeys(bname);
		BranchesPage.branchAddress1_txt(driver).sendKeys(address);
		BranchesPage.zipcode_txt(driver).sendKeys(zip);
		GenericPage.dropDownSelection(driver, getlocator("branch_country")).selectByValue(country);
		GenericPage.dropDownSelection(driver, getlocator("branch_state")).selectByValue(state);
		GenericPage.dropDownSelection(driver, getlocator("branch_city")).selectByValue(city);
		BranchesPage.cancel_btn(driver).click();
		
		
	}
	
	
	public Object[][] excelContent(String fileName, String sheetName) throws IOException
	{
		Excel_Class.excelconnection(fileName, sheetName);
		int rc = Excel_Class.rcount();
		int cc = Excel_Class.ccount();
		
		String[][] data=new String[rc-1][cc];
		
		for(int r=1;r<rc;r++)
		{
			for(int c=0;c<cc;c++)
			{
				data[r-1][c] = Excel_Class.readdata(c, r);
			}
		}
		
		
		return data;
		
		
	}

	
	public void logout_Application()
	{
		AdminPage.branches_button(driver).click();
		driver.close();
		extentreport.endTest(extentTest);
		extentreport.flush();
	}
	
	

}
