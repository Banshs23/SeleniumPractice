package SeleniumPractice;

import org.openqa.selenium.edge.EdgeDriver;

public class Seleniumfirst2 {

	public static void main(String[] args) {

		EdgeDriver driver = new EdgeDriver();

		driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.20.0");
		
		driver.close();
		
		driver.quit();

	}

}
