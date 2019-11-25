package commonMethods;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.FlipkartElements;

public class CommonMethods {
	public static WebDriver driver;
	public static FlipkartElements flipkart;
	
	static {
		System.out.println("Driver initiating");
		// driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "../Locus_Assignment/chromedriver");
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/vinoth/Documents/workspace/geckodriver");
		System.out.println("Driver setup completed.Proceeding the testing with Chrome driver");

		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("test-type");
		cOptions.addArguments("start-maximized");
		cOptions.addArguments("--js-flags=--expose-gc");
		cOptions.addArguments("--enable-precise-memory-info");
		cOptions.addArguments("--disable-popup-blocking");
		cOptions.addArguments("--disable-default-apps");
		cOptions.addArguments("disable-infobars");
		cOptions.addArguments("--disable-notifications");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		cOptions.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(cOptions);
		int width1 = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height1 = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(width1, height1));

	}

	public static WebDriver getDriver() {
		return driver;
	}
	public static void newWindow() throws InterruptedException {
		String windowtitle = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().window(windowtitle);
		Thread.sleep(2000);
	}
	
	
	public static boolean waitforElement(WebElement locator) {
		
		boolean element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(locator)).isDisplayed();
		System.out.println(element);

		return element;
	}
	
	public static String getText(WebElement locator) {

		WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(locator));
		String getText = element.getText();
		return getText;

	}
	@SuppressWarnings("null")
	public static void clickOn(WebElement locator) {

		WebElement safeClick = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(locator));
		if (safeClick != null) {
			safeClick.click();
		} else {
			System.out.println("Check whether the element is displayed " + safeClick.isDisplayed());
		}

	}
	
	public static void sendKeys(WebElement locator,String str)
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(locator)).sendKeys(str);
	}

}
