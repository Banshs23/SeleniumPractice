package optionsjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class optionHeadless {

	public static void main(String[] args) {
		
		ChromeOptions opt=new ChromeOptions();
		
		opt.addArguments("--headless=new");
		
		WebDriver driver =new ChromeDriver(opt);
		
		driver.get("https://www.google.com");
		
		System.out.println("URL " + driver.getCurrentUrl());
		
		System.out.println("Title " + driver.getTitle());
		
		driver.quit();

	}

}
