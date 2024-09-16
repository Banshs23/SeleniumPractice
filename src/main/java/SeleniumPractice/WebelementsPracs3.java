package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebelementsPracs3 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		WebElement ele = driver.findElement(By.id("email1"));
		ele.sendKeys("admin@email.com");
		
		driver.findElement(By.name("password1")).sendKeys("admin1@123");
		
		driver.findElement(By.className("submit-btn")).click();
		
		Thread.sleep(4000);
		
		String text= driver.findElement(By.className("errorMessage")).getText();
		
		if(text.contains("USER Email Doesn't Exist") || text.contains("Email and Password Doesn't match") )
		{
			System.out.println("Error message matched " + text);
		}
		else
		{
			System.out.println("Error msg did not matched");
		}

		Thread.sleep(3000);
		System.out.println(ele.getAttribute("class").contains("subLink"));
		System.out.println(ele.getCssValue("Border"));
		
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().window().minimize();
	}

}
