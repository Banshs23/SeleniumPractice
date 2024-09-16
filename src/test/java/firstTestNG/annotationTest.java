package firstTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class annotationTest {

	WebDriver driver;
	SoftAssert sa = new SoftAssert();
	
	
	@BeforeTest
	public void launchapp()
	{
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closeapp()
	{
		driver.quit();
		sa.assertAll();
	}
	
	@Test(priority = 1)
	public void startbrowser() {
		
		
		//Verifying URL
		String actualURL=driver.getCurrentUrl();	
		String expectedURL="https://www.google.com/";
		sa.assertEquals(actualURL, expectedURL,"URL Mismatched");
	
		//Verifying Title
		String actualTitle=driver.getTitle();
		String expectedTitle="Google";
		sa.assertEquals(actualTitle, expectedTitle, "Title Mismatched");
	}
	
}
