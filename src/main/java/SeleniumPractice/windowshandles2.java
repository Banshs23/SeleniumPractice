package SeleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowshandles2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//String parentwindow=driver.getWindowHandle();
		
		List<WebElement> allsociallinks=driver.findElements(By.xpath("//h2[text()='Connect with us']//following-sibling::div//a"));
		
		for(WebElement link:allsociallinks)
		{
			link.click();
		}
		
		Set<String> allwindows=driver.getWindowHandles();
		
		List<String> switchwindow=new ArrayList<String>(allwindows);
		
		driver.switchTo().window(switchwindow.get(0));
		Thread.sleep(2000);
		driver.switchTo().window(switchwindow.get(1));
		Thread.sleep(2000);
		driver.switchTo().window(switchwindow.get(2));
		Thread.sleep(2000);
		driver.switchTo().window(switchwindow.get(3));
		Thread.sleep(2000);
		driver.switchTo().window(switchwindow.get(4));
		

		driver.switchTo().window(switchwindow.get(1));
		driver.switchTo().window(switchwindow.get(2));
		driver.switchTo().window(switchwindow.get(3));
		driver.switchTo().window(switchwindow.get(4));
		

		driver.switchTo().window(switchwindow.get(0));
		driver.switchTo().window(switchwindow.get(3));
		driver.switchTo().window(switchwindow.get(1));
		driver.switchTo().window(switchwindow.get(4));
		
		System.out.println("Total Tabs " + allwindows.size());
		
		
	}

}
