package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
	public static String getDataFromExcel(int rowNum , int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream MyFile = new FileInputStream("D:\\Velocity\\Java Class\\Aug-2021 Class\\Java notes\\Aug21excelReading.xlsx");
		Sheet MySheet = WorkbookFactory.create(MyFile).getSheet("Sheet4");
		String value = MySheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	
	}
	
	public static void CaptureScreen(WebDriver driver,int TCID ) throws IOException

	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("D:\\Velocity\\Java Class\\Aug-2021 Class\\Java notes\\Selenium images\\TestID"+TCID+".png");
		FileHandler.copy(src, dest);
	}

}
