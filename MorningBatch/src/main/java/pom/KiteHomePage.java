package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {

	@FindBy(xpath ="//span[@class='user-id']") private WebElement UserId;
	
	@FindBy(xpath = "//span[@class='icon icon-exit']") private WebElement LogoutButton;
	
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String userIDValidation()
	{
		String ActualUsID =UserId.getText();
		return ActualUsID;

	}
		public void ClickOnUserID()
		{
			
			UserId.click();
		}
		
		public void ClickOnLogout()
		{
			LogoutButton.click();
		}
		

}
