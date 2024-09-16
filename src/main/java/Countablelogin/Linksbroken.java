package Countablelogin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linksbroken {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://platform.countable.co/login");
		// driver.manage().window().maximize();

		Thread.sleep(5000);

		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Size of full links and images ----->" + linkslist.size());

		List<WebElement> activelinks = new ArrayList<WebElement>();

		for (int i = 0; i < linkslist.size(); i++) {
			// System.out.println(linkslist.get(i).getAttribute("href"));
			if (linkslist.get(i).getAttribute("href") != null
					&& (!linkslist.get(i).getAttribute("href").contains("javascript"))) {
				activelinks.add(linkslist.get(i));
			}
		}

		System.out.println("Size of active links and images ----->" + activelinks.size());

		for (int j = 0; j < activelinks.size(); j++) {
			if ((!activelinks.get(j).getAttribute("href").contains("mailto"))) {
				HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href"))
						.openConnection();

				connection.connect();
				String response = connection.getResponseMessage();
				int statuscode = connection.getResponseCode();
				connection.disconnect();

				System.out.println(activelinks.get(j).getAttribute("href") + " ----> " + statuscode + " " + response);
			}

		}

	}

}
