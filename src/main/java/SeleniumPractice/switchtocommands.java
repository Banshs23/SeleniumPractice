package SeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchtocommands {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//input[contains(@title,'Sign in')]")).click();
		
		TargetLocator tl= driver.switchTo();
		Alert alt= tl.alert();
		Thread.sleep(2000);
		System.out.println(alt.getText());
		alt.accept();

	}

}
