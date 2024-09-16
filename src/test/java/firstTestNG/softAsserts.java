package firstTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAsserts {

	WebDriver driver;
	SoftAssert sa = new SoftAssert();
	
	@Test(priority = 1)
	public void startbrowser() {
		
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	
		//Verifying URL
		String actualURL=driver.getCurrentUrl();	
		String expectedURL="https://www.google.com";
		sa.assertEquals(actualURL, expectedURL,"URL Mismatched");
	
		//Verifying Title
		String actualTitle=driver.getTitle();
		String expectedTitle="Google";
		sa.assertEquals(actualTitle, expectedTitle, "Title Mismatched");
	}
	
	@Test(priority = 4, dependsOnMethods = "startbrowser")
	public void closebrowser() {
		driver.quit();
		sa.assertAll();
	}
}
