package SeleniumPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowshandles {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentwindow=driver.getWindowHandle();
		
		List<WebElement> allsociallinks=driver.findElements(By.xpath("//h2[text()='Connect with us']//following-sibling::div//a"));
		
		for(WebElement link:allsociallinks)
		{
			link.click();
		}
		
		Set<String> allwindows=driver.getWindowHandles();
		
		System.out.println("Total Tabs " + allwindows.size());
		
		Iterator<String> itr=allwindows.iterator();
		
		while(itr.hasNext())
		{	
			String child=itr.next();
			if(!parentwindow.equals(child))
			{
				driver.switchTo().window(child);
				Thread.sleep(3000);
				
				if(driver.getCurrentUrl().contains("facebook"))
				{
					driver.findElement(By.xpath("//div[contains(@aria-label,'Close')]")).click();
					driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("bansh@gmail.com");
					break;
				}
				
				//driver.close();
			}
		}
		
		driver.switchTo().window(parentwindow);
		//driver.quit();
	}

}
