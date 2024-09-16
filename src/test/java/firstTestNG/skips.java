package firstTestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class skips {

	
	@Test(priority = 1)
	public void startbrowser() {
		
		Reporter.log("Browser started",false);
		Assert.assertTrue(true);
	}
	
	@Test(priority = 2)
	public void verifyURL() {
		Reporter.log("URL Verified",true);
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3, dependsOnMethods = "startbrowser")
	public void verifyTitle() {
		Reporter.log("Title Verified",true);
		Assert.assertTrue(true);
	}
	
	@Test(priority = 4, dependsOnMethods = "startbrowser")
	public void closebrowser() {
		Reporter.log("Browser close",true);
		Assert.assertTrue(true);
	}
}
