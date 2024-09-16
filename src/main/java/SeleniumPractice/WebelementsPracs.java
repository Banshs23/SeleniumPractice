package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebelementsPracs {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		//first assertion to check if the expected result meet or not
		
		String title=driver.getTitle();
		
		if(title.contains("Learn Automation"))
		{
			System.out.println("Validation 1 - Passed - "+ title);
		}
		else
		{
			System.out.println("Validation 1 - Failed");
		}
		
		WebElement element = driver.findElement(By.id("email1"));
		
		System.out.println("Is Displayed " + element.isDisplayed());
		System.out.println("Is Enabled " + element.isEnabled());
		System.out.println("Is Selected " + element.isSelected());
		
		element.sendKeys("bansh@email.com");
		
		element.clear();
		
		element.sendKeys("admin@email.com");
		
		

	}

}
