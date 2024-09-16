package Countablelogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class JSexecutorTocapturetext {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=Utility.startbrowser("Chrome", "https://platform.countable.co/login");
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'E-mail')]")).sendKeys("usangular@yopmail.com");

		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("Count@1234");

		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		
		Thread.sleep(3000);
		
		WebElement element= driver.findElement(By.xpath("//div[contains(@id,'toast-container')]"));
	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String str=(String) js.executeScript("return arguments[0].innerText;",element);
	
		
		/*
		 * JavascriptExecutor js=(JavascriptExecutor) driver; String str=(String) js.
		 * executeScript("return document.getElementById(\"toast-container\").innerText;"
		 * );
		 */
		
		System.out.println(str);

	}

}
