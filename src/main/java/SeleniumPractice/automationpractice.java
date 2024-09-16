package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class automationpractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		driver = Utility.startbrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		
		
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		
		driver.findElement(By.className("submit-btn")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Manage')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(@class,'manage')]//a[1]")).click();

	}

}
