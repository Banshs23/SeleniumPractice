package SeleniumPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowshandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentwindow=driver.getWindowHandle();
		
		driver.findElements(By.xpath("//a[contains(@href,'facebook')]")).get(0).click();
		
		Set<String> allwindows=driver.getWindowHandles();
		
		System.out.println("Total Tabs " + allwindows.size());
		
		Iterator<String> itr=allwindows.iterator();
		
		while(itr.hasNext())
		{
			String child=itr.next();
			if(!parentwindow.equals(child))
			{
				driver.switchTo().window(child);
			
				driver.findElement(By.xpath("//div[contains(@aria-label,'Close')]")).click();
				driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("bansh@gmail.com");
				
				//driver.close();
			}
		}
		
		driver.switchTo().window(parentwindow);
		//driver.quit();
	}

}
