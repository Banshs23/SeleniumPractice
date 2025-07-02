package Countablelogin;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLinkBroken {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://platform.countable.co/login");

		// ✅ Wait until the page is ready and a specific element is visible (e.g., login
		// form or body tag)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Total links and images: " + linkslist.size());

		List<WebElement> activelinks = new ArrayList<>();

		for (WebElement element : linkslist) {
			String href = element.getAttribute("href");
			if (href != null && !href.contains("javascript")) {
				activelinks.add(element);
			}
		}

		System.out.println("Total active links: " + activelinks.size());

		HttpClient client = HttpClient.newHttpClient();

		for (WebElement element : activelinks) {
			String href = element.getAttribute("href");
			if (href != null && !href.startsWith("mailto")) {
				try {
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(href)).timeout(Duration.ofSeconds(10))
							.GET().build();

					HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

					System.out.println(href + " --> " + response.statusCode());
				} catch (Exception e) {
					System.out.println(href + " --> ERROR: " + e.getMessage());
				}
			}
		}

		driver.quit();
	}
}
