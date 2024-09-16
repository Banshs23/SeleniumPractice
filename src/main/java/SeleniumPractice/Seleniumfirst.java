package SeleniumPractice;

import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumfirst {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.20.0");
		driver.quit();

	}

}
