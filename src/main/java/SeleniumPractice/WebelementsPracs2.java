package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebelementsPracs2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		
		driver.findElement(By.className("submit-btn")).click();
		
		Thread.sleep(3000);
		
		boolean status=false;
		
		try 
		{
			status = driver.findElement(By.className("cartBtn")).isDisplayed();			
		} 
		catch (Exception e) 
		{
			System.out.println("Did not find the cart button");
		}
		
		if(status)
		{
			System.out.println("Logged in successful");
		}
		else
		{
			System.out.println("Login Failed");
		}
		
		

	}

}
