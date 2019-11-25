package stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonMethods.CommonMethods;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FlipkartElements;

public class Flipkart {
	public static WebDriver driver;
	public static FlipkartElements flipkart;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static String Url = "https://www.flipkart.com/";
	
	
	static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
			System.getProperty("../Locus_Assignment/HtmlReport") + "/FlipKart.html");
	//static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("../Locus_Assignment/"+" FlipKart" +".html");
	static ExtentReports extent = new ExtentReports();
	static ExtentTest logger;

	@Before
	public void initializeDriver() {
		driver = CommonMethods.getDriver();
		js = (JavascriptExecutor) driver;

	}

	@Given("Open Flipkart site")
	public void open_Flipkart_site() {
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("<b>FlipKartSite</b>");
		// Navigate to a URL
		driver.get(Url);
		String getTitle = driver.getTitle();
		logger.log(Status.INFO, "Verify whether the user landed to flipKartSite");
		if(getTitle.contains("Online Shopping Site for Mobiles"))
		{
			logger.log(Status.PASS, "Landed to FlipKart Site..");
		}
		else
		{
			logger.log(Status.FAIL, "Error on landing to flipkart site..");
		}
		
		

	}

	@Given("Check whether the popup displayed")
	public void check_whether_the_popup_displayed() {
		// Initiate the elements
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);

		boolean elementState = CommonMethods.waitforElement(FlipkartElements.popupLogin);

		System.out.println("Test " + elementState);
		logger.log(Status.INFO, "Check Whether the user able to see the popup");
		if (elementState) {
			logger.log(Status.PASS, "Able to see the Popup");
			System.out.println("Able to see the login Popup, should cancel the popup");
		} else {
			logger.log(Status.FAIL, "Can't able to see the popup");
			System.out.println("Something went wrong with showing the popup");
		}
	}

	@Then("Cancel the popup")
	public void cancel_the_popup() {
		// Initiate the elements
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
		logger.log(Status.INFO, "Check whether the popup is displayed, Once clicks the cacel button");
		CommonMethods.clickOn(FlipkartElements.cancelBtn);
		logger.log(Status.PASS, "Popup Canceled");
	}

	@When("the user search a term shoes")
	public void the_user_search_a_term_shoes() {
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("<b>Product Search</b>");
		// Initiate the elements
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
		logger.log(Status.INFO, "Whether the User Able to see the Search field");
		// check whether the user able to see the search field
		boolean element = CommonMethods.waitforElement(FlipkartElements.searchField);
		if (element) {
			logger.log(Status.PASS, "Able to see the Search Field");
			// Send the "shoes" value to search field
			CommonMethods.sendKeys(FlipkartElements.searchField, "shoes");
			logger.log(Status.PASS, "Sent the shoes value to the search field");
			// Click search icon
			CommonMethods.clickOn(FlipkartElements.searchIcon);
		}

	}

	@Then("validate the values whether its searched for shoes.")
	public void validate_the_values_whether_its_searched_for_shoes() {
		// Initiate the elements
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
		logger.log(Status.INFO, "Validate whether the user looking for shoes in the searched result ");
		// URL validate - contains shoes
		String URL = driver.getCurrentUrl();
		if (URL.contains("q=shoes")) {
			logger.log(Status.PASS, "Successfully queried for the shoes");
			System.out.println("Showing shoes - Epected Behaviour");
		}
		// One more validation for showing the results for shoes..
		String getText = CommonMethods.getText(FlipkartElements.shoesResult);
		if (getText.contains("shoes")) {
			logger.log(Status.PASS, "At the searched result, Able to see the shoes result alone");
			System.out.println("Expected behavious for searched result.");
		}

	}

	@When("the user choose two filter")
	public void the_user_choose_two_filter() throws InterruptedException {
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("<b>Apply Filters</b>");
		// Initiate the elements
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
		// click min filter option
		logger.log(Status.INFO, "Check Whether the Filters applied ");
		CommonMethods.clickOn(FlipkartElements.minPriceFilter);
		// select the min price option value
		CommonMethods.clickOn(FlipkartElements.minOptionValue);
		// waits for invisibility of loader
		Thread.sleep(1000);
		// Select the max price option value
		CommonMethods.clickOn(FlipkartElements.maxPriceFilter);
		CommonMethods.clickOn(FlipkartElements.maxOptionValue);
		Thread.sleep(1000);
		// Select the brand
		CommonMethods.clickOn(FlipkartElements.selectBrand);
		Thread.sleep(1000);

	}

	@Then("Validate whether the filteres are selected")
	public void validate_whether_the_filteres_are_selected() {
		wait = new WebDriverWait(driver, 30);
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
		System.out.println("Test01");
		List<WebElement> filterCheck = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='_3clSXm']//div[@class='_3UZZGt']")));
		for (WebElement filters : filterCheck) {
			if (filters.getText().equalsIgnoreCase("₹1000-₹2000")) {
				logger.log(Status.PASS, "Able to see the price got filtered as per the user choosen");
				System.out.println("Price filter applied as per the expectation");
			} else if (filters.getText().equalsIgnoreCase("Puma")) {
				logger.log(Status.PASS, "Brand filter applied successfully");
				System.out.println("Brand selected");
			}

		}
	}
	
	@When("the user clicks the first product")
	public void the_user_clicks_the_first_product() throws InterruptedException {
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("<b>Product Detail Page</b>");
		wait = new WebDriverWait(driver, 30);
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
	  List<WebElement>  products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='IIdQZO _1R0K0g _1SSAGr']")));
	  logger.log(Status.INFO, "Check whether the first product clicked by the user");
	  for(WebElement firstProduct:products )
	  {
		  firstProduct.click();
		  Thread.sleep(1000);
		  break;
	  }
	}

	@When("the user  select the size of the item")
	public void the_user_select_the_size_of_the_item() {
		wait = new WebDriverWait(driver, 30);
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
	    //Click Buy button before select the size- should get notify message
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    logger.log(Status.PASS, "Able to see the selected product at the next tab.");
		CommonMethods.clickOn(FlipkartElements.buyNowBtn);
		logger.log(Status.INFO, "WhatIf the user clicks the buy button before select the size");
		String notifyMsg = CommonMethods.getText(FlipkartElements.notifyMsg);
		if(notifyMsg.equalsIgnoreCase("Please select a Size- UK/India to proceed"))
		{
			logger.log(Status.PASS, "Able to see the Notify message if the user clicks the buy-Now button before selects the size");
			System.out.println("Should select the size before clicks the buy button");
		}
		List<WebElement> Size = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='rPoo01']//span[@id='Size- UK/India']/../ul/li")));
		logger.log(Status.INFO, "Validate whether the user selects the Available size");
		for(WebElement chooseSize: Size)
		{
			chooseSize.click();
			
			try {
				boolean buyNow = CommonMethods.waitforElement(FlipkartElements.buyNowBtn);
				if(buyNow)
				{
					
					System.out.println("Size Selected");
					logger.log(Status.PASS, "Selected the size");
					break;
				}
			
			}
			catch(Exception e)
			{
				logger.log(Status.PASS, "Please Select next Size");
			}
			
		}
	}

	@Then("check whether the user able to see the Buy Now label")
	public void check_whether_the_user_able_to_see_the_Buy_Now_label() {
		wait = new WebDriverWait(driver, 30);
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
		logger.log(Status.INFO, "Validate whether the user able to see the BUY-Now button once selected the size");
	   // check whether the user able to see the BUY-NOW button
		boolean ElementState = CommonMethods.waitforElement(FlipkartElements.buyNowBtn);
		if(ElementState)
		{
			logger.log(Status.PASS, "Able to see the BUY-Now Button, Please click ");
			System.out.println("Able to see the Buy-Now button");
		}
	}

	@Then("clicks the Buy now label")
	public void clicks_the_Buy_now_label() {
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
		//Click the Buy-Now button
		CommonMethods.clickOn(FlipkartElements.buyNowBtn);
		
	   
	}

	@Then("should see the login page.")
	public void should_see_the_login_page() {
		flipkart = PageFactory.initElements(driver, FlipkartElements.class);
		logger.log(Status.INFO, "Check whether the user able see the login page, once clicks the BUY-Now button");
		//Check whether the user able to see the login page.
		boolean loginPageState = CommonMethods.waitforElement(FlipkartElements.loginPage);
		if(loginPageState)
		{
			logger.log(Status.PASS, "Able to see the login Page");
			System.out.println("Landed to login page...");
		}
		else
		{
			System.out.println("Something went wrong with landing to login page.");
		}
	   
		extent.flush();
		driver.quit();
	}

}
