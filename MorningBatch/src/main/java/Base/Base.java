package Base;

import org.openqa.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Base 
{
	protected WebDriver driver;
	
	public void browserInitialise() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "D:\\Velocity\\Java Class\\Aug-2021 Class\\chromedriver_win32 (1)\\chromedriver.exe");
		 ChromeOptions opt= new ChromeOptions();
		 opt.addArguments("--disable-notifications");
		 driver= new ChromeDriver(opt);
		 driver.get("https://kite.zerodha.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(1000);
		
		
	}

}
