package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage 
{
	//Step1. Declaration of variables
	@FindBy(id="userid") private WebElement UserID;
	
	@FindBy(id="password") private WebElement Password;
	
	@FindBy(xpath="//button[@class='button-orange wide']") private WebElement LoginButton;
	
	@FindBy(xpath = "//p[@class='error text-center']") private WebElement ErrorMsg;
	
	//Step2. Initialize variables using Constructor-->PageFactory class and initElements static method
	
	public KiteLoginPage(WebDriver driver)// int a// String name
	
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Step3. variable usage--> using Methods
	
	public void enterUserId(String Userid)
	{
		UserID.sendKeys(Userid);
		
	}
	
	public void enterPassword(String PWD)
	{
		Password.sendKeys(PWD);
	}
	
	public void ClickOnLoginButton()
	{
		LoginButton.click();
	}
	
	public String getErrorMsg()
	{
		String ActualErrorMsg = ErrorMsg.getText();
		return ActualErrorMsg;
		
	}
}
