package screenshots;

import org.openqa.selenium.WebDriver;

import helper.Utility;

public class captureScreenshots2 {

	public static void main(String[] args) {

		WebDriver driver= Utility.startbrowser("chrome", "https://google.com/");

		Utility.captureScreenshots(driver);
		
	}
}
