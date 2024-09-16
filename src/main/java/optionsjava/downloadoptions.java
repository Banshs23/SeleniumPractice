package optionsjava;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class downloadoptions {

	public static void main(String[] args) {
		
		//for file download : https://the-internet.herokuapp.com/
		//path	/SeleniumProject/Downloads
		//System.getProperty("user.dir") it gives you the current directory path
		
		String userpath=System.getProperty("user.dir")+"\\downloads\\";
		System.out.println(userpath);
		
		ChromeOptions opt=new ChromeOptions();
		Map<String, Object> downloadmap=new HashMap<String, Object>();
		downloadmap.put("download.default_directory",userpath);
		opt.setExperimentalOption("prefs", downloadmap);
		
		WebDriver driver=new ChromeDriver(opt);
		
		driver.get("https://the-internet.herokuapp.com/download");
		
		driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
		
		driver.findElement(By.xpath("//a[text()='sample.pdf']")).click();
		
		driver.findElement(By.xpath("//a[text()='testFile.xlsx']")).click();
		
		//driver.findElement(By.xpath("//a[text()='testFile.png']")).click();
		
		File destination=new File(userpath);
		
		int count=destination.listFiles().length;
		
		System.out.println("Current Count "+ count);
		
		if(destination.list().length>0)
		{
			//Need to update the logic that gives me count of recently downloaded file/files :: currently it's giving me the count of files available in the folder
			if(count>1)
			{
				System.out.println(count +" "+"Files Downloaded");
			}
			else
			{
				System.out.println(count +" "+"File Downloaded");
			}
		}
		else
		{
			System.out.println("File Not Downloaded");
		}
		
		//driver.quit();
		
	}

}
