package screenshots;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import helper.Utility;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class screenshotwithAshot {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Utility.startbrowser("chrome",
				"https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html");

		String date = Utility.defaultdateFormat();
		Screenshot screens = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1500))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screens.getImage(), "PNG", new File("./screenshots/AshotFullPageSS" + date + ".png"));
			System.out.println("Screenshot for full page is captured successfully!");
		} catch (IOException e) {
			System.out.println("Unable to capture full screen shot");
		}

	}

}
