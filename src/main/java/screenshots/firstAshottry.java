package screenshots;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import helper.Utility;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class firstAshottry {

	public static void main(String[] args) {
		
		WebDriver driver=Utility.startbrowser("Chrome", "https://www.onlineservices.nsdl.com/paam/requestAndDownloadEPAN.html");
		
		//Creating Ashot object or instance for more: https://www.youtube.com/watch?v=TQixuiaojd0.
		AShot ashot=new AShot();
		//Converting the screenshot object to image
		Screenshot ss=ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		
		try 
		{
			//for converting we use the method "ImageIO" then in that "write" method we have
			ImageIO.write(ss.getImage(), "JPG", new File("./screenshots/FullPageSS.jpg"));
			System.out.println("AShot Screenshot captured successfully");
		} catch (IOException e) 
		{
			System.out.println("Screen Shot not captured");
		}
	}

}
