package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import Utility.Utility;
import pom.KiteHomePage;
import pom.KiteLoginPage;
import pom.KitePinPage;

public class Kite_APP_Test extends Base {
  
	KiteLoginPage login;// declaration
	KitePinPage pin;
	KiteHomePage home;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		Reporter.log("Initailising browser", true);
		browserInitialise();
		login= new KiteLoginPage(driver);
		pin= new KitePinPage(driver);
		home= new KiteHomePage(driver);
	}
	
	@BeforeMethod
	public void loginToKite() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("entering UseriD and Password", true);
		login.enterUserId(Utility.getDataFromExcel(0, 0));
		login.enterPassword(Utility.getDataFromExcel(0, 1));
		login.ClickOnLoginButton();
		Thread.sleep(1000);
//		Reporter.log("Entering Pin", true);
//		pin.enterPIN(Utility.getDataFromExcel(0, 2));
//		pin.clickOnContinueButton();
	}
	
	@Test
	public void validateErrorMsg() throws EncryptedDocumentException, IOException, InterruptedException
	{
		int TCID=11;
		String ExpectedErrorMsg = Utility.getDataFromExcel(0, 3);
		Thread.sleep(1000);
		String ActualErrorMsg = login.getErrorMsg();
		Thread.sleep(1000);
		Assert.assertEquals(ExpectedErrorMsg, ActualErrorMsg, "ErrorMsg not matching, TC failed");
		Reporter.log("ErrorMSG matched TC is Passed",true);
		Thread.sleep(1000);
		Utility.CaptureScreen(driver, TCID);
	}
	
	@Test(enabled = false)
  public void ValidateUserID() throws EncryptedDocumentException, IOException, InterruptedException 
{
		int TCID=10;
		Thread.sleep(1000);
		String ActualUserID = home.userIDValidation();
		String ExpextedUserID = Utility.getDataFromExcel(0, 0);
		Reporter.log("Validating UserID", true);
		Thread.sleep(2000);
		Assert.assertEquals(ActualUserID, ExpextedUserID,"User ID not matching TC Failed");
		Reporter.log("User ID Matching TC "+TCID+" is passed",true);
		Reporter.log("Taking screenshot", true);
		Thread.sleep(1000);
		Utility.CaptureScreen(driver, TCID);

}
	
	@AfterMethod(enabled = false)
	public void LogOutFromKite() throws InterruptedException
	{
		Thread.sleep(1000);
		Reporter.log("logging out..", true);
		home.ClickOnUserID();
		Thread.sleep(1000);
		home.ClickOnLogout();
		Thread.sleep(1000);
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		Reporter.log("Closing browser", true);
		driver.close();
	}
}
