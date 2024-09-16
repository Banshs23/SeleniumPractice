package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class webdriverwaits {

	public static void main(String[] args) {

		WebDriver driver = Utility.startbrowser("chrome",
				"http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

		WebElement element = Utility.waitforWebElement(driver, By.xpath("//p[text()='WebDriver']"), 15);

		/*
		 * WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		 * 
		 * WebElement
		 * element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//p[text()='WebDriver']")));
		 */

		// Boolean status=
		// wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[text()='WebDriver']"),
		// "WebDriver"));

		if (element.getText().contains("WebDriver") && element.isDisplayed()) {
			System.out.println("Expected Condition Satisfied");
		}

	}

}
