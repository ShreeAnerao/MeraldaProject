package baseUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class CommonUtility {

	public static WebDriver driver;
	public WebDriverWait wait;

	@BeforeSuite
	public void startSession() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Desktop\\class\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@BeforeTest
	public void launchSite() {
		driver.get("https://meralda.scalenext.io/user/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.manage().window().maximize();
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, "Meralda || Register");
	}

	@AfterSuite
	public void endSession() {

		driver.quit();
	}

	public void scrollToElement(String btnRegister) throws Exception {
		WebElement ele = driver.findElement(By.xpath(btnRegister));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public void clickOnElement(WebElement ele) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		;

	}
}
