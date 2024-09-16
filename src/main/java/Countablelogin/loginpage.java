package Countablelogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginpage {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://platform.countable.co/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		boolean status =driver.findElement(By.xpath("//img[contains(@alt,'Countable')]")).isDisplayed();
		
		if(status)
		{
			System.out.println("Passed - Login page logo is displayed");
		}
		else
		{
			System.out.println("Failed - Login page logo is not displayed");
		}
		
		String ele=driver.findElement(By.xpath("//h3[contains(text(),'Secure Login')]")).getText();
		
		String name="Secure Login";
		
		if(ele.contains(name))
		{
			System.out.println("Passed - Given string name is valid");
		}
		else
		{
			System.out.println("Failed - Given string name is not valid");
		}
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'E-mail')]")).sendKeys("usangular@yopmail.com");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("Count@123");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();

	}

}
