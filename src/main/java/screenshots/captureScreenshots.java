package screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import helper.Utility;

public class captureScreenshots {

	
	public static void main(String[] args)
	{
		
		WebDriver driver=Utility.startbrowser("chrome", "https://platform.countable.co/");
		
		TakesScreenshot ss=(TakesScreenshot) driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		
		try 
		{
			String title=driver.getTitle();
			FileHandler.copy(src, new File("./screenshots/"+title.concat(".png")));    					//./screenshots/selenium.png
		} catch (IOException e) {
			System.out.println("Could not save the screenshot to desired folder");
		}
	}
}
