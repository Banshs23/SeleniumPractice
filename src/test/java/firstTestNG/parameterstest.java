package firstTestNG;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class parameterstest {

	WebDriver driver;
	SoftAssert sa = new SoftAssert();

	@Parameters("browserName")
	@BeforeTest
	public void initializeBrowser(@Optional("chrome") String Browsername) {
		switch (Browsername.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.err.println("Mentioned browser name is invalid");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
	}

	@AfterTest
	public void closebrowser() {
		driver.quit();
		sa.assertAll();
	}

	@Parameters("url")
	@Test(priority = 1)
	public void Launchapp(String URL) {
		driver.get(URL);
	}

	@Parameters({ "username", "password" })
	@Test(priority = 2, dependsOnMethods = "Launchapp")
	public void EnterLoginDetails(String UserName, String Password) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 3, dependsOnMethods = "EnterLoginDetails")
	public void NavigatetoMyInfo() {
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
	}

	@Test(priority = 4, dependsOnMethods = "NavigatetoMyInfo")
	public void verifyInfo() {
		boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).isDisplayed();
		assertTrue(status);
	}

	@Test(priority = 5, dependsOnMethods = "NavigatetoMyInfo")
	public void verifyLogin() {
		WebElement element = driver.findElement(By.xpath("//h6[normalize-space()='Jamna Fox']"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Jamna"));

	}

}
