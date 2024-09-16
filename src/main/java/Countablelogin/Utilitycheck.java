package Countablelogin;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class Utilitycheck {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		//WebDriver driver;
		
		WebDriver driver=Utility.startbrowser("chrome", "https://platform.countable.co/login");
		
		Thread.sleep(2000);
		
		//Utility.Findbrokenlinks(By.tagName("a"), By.tagName("img"), "href", "javascript","mailto");
		
		Utility.getElementWithHighlight(driver,By.xpath("//input[contains(@placeholder,'E-mail')]"), 2).sendKeys("usangular@yopmail.com");
		Utility.getElementWithHighlight(driver,By.xpath("//input[contains(@type,'password')]"), 2).sendKeys("Count@123");
		//Utility.getElementWithHighlight(By.xpath("//span[contains(text(),'Login')]"), 2).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//driver.findElement(By.name("q")).sendKeys("goldman");
		
		////li[contains(@role,'presentation')]//div[contains(@role,'presentation')]/span
		
	
		
		//Utility.selectValuefromlist(By.xpath("//li[@role='presentation']//div[@role='presentation']"), "mumbai");
		
		/*
		 * List<WebElement> elements=driver.findElements(By.xpath(
		 * "//li[@role='presentation']//div[@role='presentation']"));
		 * 
		 * System.out.println("List of elements ---> " + elements.size());
		 * 
		 * for(int i=0;i<elements.size();i++) { WebElement element = elements.get(i);
		 * 
		 * if(element.getText().length()>0) { String text = element.getText();
		 * System.out.println(text); if(text.contains("mumbai")) { element.click();
		 * break; }
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

	}

}
