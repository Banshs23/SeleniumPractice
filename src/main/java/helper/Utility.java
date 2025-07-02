package helper;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utility {

	/*
	 * @param - Browsername user need to provide name of browser
	 * 
	 * @param - URL user can provide URL
	 * 
	 */

	public static WebDriver startbrowser(String Browsername, String URL) {
		WebDriver driver = null;

		if (Browsername.contains("Chrome") || Browsername.contains("chrome")) {
			driver = new ChromeDriver();
		}

		else if (Browsername.contains("Edge") || Browsername.contains("edge")) {
			driver = new EdgeDriver();
		}

		else if (Browsername.contains("Firefox") || Browsername.contains("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (Browsername.contains("Safari") || Browsername.contains("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("!!Sorry We Do Not Support This Browser...");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public static WebElement elementHighlight(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"arguments[0].setAttribute('style','border:solid 2.5px transparent; border-radius: 1rem; border-image: linear-gradient(to right, lightblue, lightgreen, blue) 1;');",
				element);
		wait(1);
		js.executeScript("arguments[0].setAttribute('style','border:solid 2px #c3cbd6');", element);

		return element;
	}

	/*
	 * @Param - FormatType
	 * 
	 * @for more types visit given link:
	 * https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
	 * Day: d,dd, EEE Month: MM, MMM Year: YYYY, YYY AM/PM: a Hours: hh Minutes: mm
	 * Seconds: ss eg: "dd/MM/YYYY"
	 * 
	 */

	public static String customdateFormat(String formattype) {
		SimpleDateFormat formatter = new SimpleDateFormat(formattype);
		Date today = new Date();
		String dateoutput = formatter.format(today);
		return dateoutput;
	}

	public static String defaultdateFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("d_MM_yyyy_hh_mm_ss");
		Date today = new Date();
		String dateoutput = formatter.format(today);
		return dateoutput;
	}

	/*
	 * 
	*/
	public static void captureScreenshots(WebDriver driver) {
		try {
			String datetime = defaultdateFormat();
			String title = driver.getTitle();
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./screenshots/" + title + "-" + datetime + ".png"));
		} catch (IOException e) {
			System.out.println("Could not save the screenshot to desired folder");
		}
	}

	public static void captureFullPageScreenshot(WebDriver driver) {
		// before using check for device pixel ratio using "window.devicePixelRatio"
		Screenshot screens = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1500))
				.takeScreenshot(driver);
		try {
			String datetime = defaultdateFormat();
			String title = driver.getTitle();
			ImageIO.write(screens.getImage(), "PNG", new File("./screenshots/" + title + "-" + datetime + ".png"));
			System.out.println("Screenshot for full page is captured successfully!");
		} catch (IOException e) {
			System.out.println("Unable to capture full screen shot");
		}
	}

	/*
	 * Wait for element and wait
	 */

	public static void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {

		}
	}

	public static WebElement getElementWithHighlight(WebDriver driver, By locator, int time) {
		WebElement element = waitforWebElement(driver, locator, time);
		return elementHighlight(driver, element);
	}

	public static WebElement waitforWebElement(WebDriver driver, By locator, int time) {
		WebElement element = null;
		for (int i = 0; i < time; i++) {
			try {
				element = driver.findElement(locator);
				if (element.isDisplayed() && element.isEnabled()) {
					break;
				}

			} catch (NoSuchElementException | ElementNotInteractableException e) {
				System.out.println("Waiting for element to be visible...!!!");
				wait(1);
			} catch (Exception e) {
				System.out.println("Waiting for element to be visible...!!!");
				wait(1);
			}
		}

		return element;
	}

	// Click event By xpath or with WebElement

	public static void clickElement(WebDriver driver, WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));

		try {
			element.click();

		} catch (Exception e) {
			System.out.println("LOG:INFO - WebElement Click failed ---> Trying with JS click");

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("argument[0].click()", element);

			} catch (Exception e1) {
				System.out.println("LOG:INFO - JS click failed ---> Trying with Action click");

				new Actions(driver).moveToElement(element).click().build().perform();
			}

		}
	}

	public static void clickElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		try {
			element.click();

		} catch (Exception e) {
			System.out.println("LOG:INFO - WebElement Click failed ---> Trying with JS click");

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("argument[0].click()", driver.findElement(locator));

			} catch (Exception e1) {
				System.out.println("LOG:INFO - JS click failed ---> Trying with Action click");

				new Actions(driver).moveToElement(driver.findElement(locator)).click().build().perform();
			}

		}
	}

	/*
	 * @param - Locator by provide xpath
	 * 
	 * @param - Bylocator is of your choice however you want to pass
	 * 
	 * @param - value to search - value that needs to be searched
	 * 
	 */

	public static void selectValuefromlist(WebDriver driver, String Locator, String valuetosearch) {

		List<WebElement> elementslist = driver.findElements(By.xpath(Locator));

		System.out.println("List of elements ---> " + elementslist.size());

		for (WebElement element : elementslist) {

			if (element.getText().contains(valuetosearch)) {
				element.click();
				break;
			}
		}
	}

	public static void selectValuefromlist(WebDriver driver, By ByLocator, String valuetosearch) {

		List<WebElement> elementslist = driver.findElements(ByLocator);

		System.out.println("List of elements ---> " + elementslist.size());

		for (WebElement element : elementslist) {

			if (element.getText().contains(valuetosearch)) {
				element.click();
				break;
			}
		}
	}

	/*
	 * @param - By Locator user can provide "a" tagname and "img" tagname
	 * 
	 * @param - Attribute user need to provide "href" is he/she need to find link
	 * 
	 * @param - containstext if url is under javascript so to avoid it user need to
	 * pass "javascript".
	 * 
	 */

	public static void FindBrokenLinks(WebDriver driver, By locator, By additionalLocator, String attribute,
			String excludeIfContains) throws IOException, InterruptedException {

		List<WebElement> elements = driver.findElements(locator);
		elements.addAll(driver.findElements(additionalLocator));

		System.out.println("Total links/images found: " + elements.size());

		List<String> validUrls = new ArrayList<>();

		for (WebElement element : elements) {
			String url = element.getAttribute(attribute);
			if (url != null && !url.contains(excludeIfContains)) {
				validUrls.add(url);
			}
		}

		System.out.println("Active links/images to check: " + validUrls.size());

		HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();

		for (String url : validUrls) {
			try {
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).timeout(Duration.ofSeconds(10))
						.GET().build();

				HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

				System.out.println(url + " --> " + response.statusCode());
			} catch (Exception e) {
				System.out.println(url + " --> ERROR: " + e.getMessage());
			}
		}
	}

	public static void FindBrokenLinks(WebDriver driver, By primaryLocator, By secondaryLocator, String attribute,
			String excludeIfContains, String alsoExcludeIfContains) throws IOException, InterruptedException {

		List<WebElement> elements = driver.findElements(primaryLocator);
		elements.addAll(driver.findElements(secondaryLocator));

		System.out.println("Total links/images found: " + elements.size());

		List<String> validUrls = new ArrayList<>();

		for (WebElement el : elements) {
			String url = el.getAttribute(attribute);
			if (url != null && !url.contains(excludeIfContains)) {
				validUrls.add(url);
			}
		}

		System.out.println("Filtered active links: " + validUrls.size());

		HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();

		for (String url : validUrls) {
			if (!url.contains(alsoExcludeIfContains)) {
				try {
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).timeout(Duration.ofSeconds(10))
							.GET().build();

					HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

					System.out.println(url + " --> " + response.statusCode());
				} catch (Exception e) {
					System.out.println(url + " --> ERROR: " + e.getMessage());
				}
			}
		}
	}

}
