package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchtocommands2 {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath("//li[contains(@data-text,'Account')]")).click();
		
		//ul[contains(@class,'header_dropdown_menu')]//li//span[contains(text(),'Login/ Sign Up')]
		driver.findElement(By.xpath("//div[contains(@class,'dropdown_wrap')]//ul//li[5]")).click();
		
		int elementsize=driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of frame : "+elementsize );
		
		WebElement frameelement=driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
		
		driver.switchTo().frame(frameelement);
		
		String str=driver.findElement(By.xpath("//div[contains(text(),'Sign in to avail exciting discounts and cashbacks!!')]")).getText();
		
		String content="Sign in to avail exciting discounts and cashbacks!!";
		if(content.equalsIgnoreCase(str))
		{
			System.out.println("PASSED : I m switched into frame");
		}
		else 
		{
			System.out.println("FAILED : It did not switched into frame");
		}
		
		WebElement ele=driver.findElement(By.xpath("//div[contains(@id,'otp-container')]"));
		String classes=ele.getAttribute("class");
		Boolean isdisabled = classes.contains("disabled");
				
		if(isdisabled)
		{
			System.out.println("PASSED : Button is Disabled");
		}
		else
		{
			System.out.println("FAILED : Button is Enabled");
		}
		
		driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys("9889607021");
		
		Thread.sleep(3000);
		
		WebElement innerelement=driver.findElement(By.xpath("//iframe[contains(@title,'reCAPTCHA')]"));
		
		driver.switchTo().frame(innerelement);
		
		//checking is captcha is checked or not
		Thread.sleep(2000);
		WebElement checkboxele=driver.findElement(By.xpath("(//span[contains(@role,'checkbox')])"));
		checkboxele.click();
		
		Thread.sleep(3000);
		String ischecked=checkboxele.getAttribute("aria-checked");
		Boolean schecked=ischecked.contains("true");
		
		if(schecked)
		{
			System.out.println("PASSED : Checkbox is checked");
		}
		else
		{
			System.out.println("FAILED : Checkbox is not checked");
		}
		
		
		//checking if button is enabled or not after checkbox is selected
		driver.switchTo().parentFrame();
		WebElement button=driver.findElement(By.xpath("//div[contains(@id,'otp-container')]"));
		String bclasses=button.getAttribute("class");
		Boolean isEnabled = bclasses.contains("disabled");
		
		if(isEnabled == false)
		{
			System.out.println("PASSED : Button is Enabled");
		}
		else if(isEnabled == true)
		{
			System.out.println("FAILED : Button is Disabled");
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'GENERATE OTP ')]")).click();
		
	}

}
