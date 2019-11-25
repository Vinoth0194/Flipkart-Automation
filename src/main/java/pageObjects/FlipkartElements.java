package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlipkartElements {
	final WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_1XBjg- row']")
	public static WebElement popupLogin;
	@FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _29YdH8']")
	public static WebElement cancelBtn;
	@FindBy(how = How.XPATH, using = "//input[@title='Search for products, brands and more']")
	public static WebElement searchField;
	@FindBy(how = How.XPATH, using = "//button[@class='vh79eN']")
	public static WebElement searchIcon;
	@FindBy(how = How.XPATH, using = "//span[@class='_2yAnYN']")
	public static WebElement shoesResult;
	@FindBy(how = How.XPATH, using = "//div[@class='_1qKb_B']")
	public static WebElement minPriceFilter;
	@FindBy(how = How.XPATH, using = "//div[@class='_3Uy12X']//div[@class='_1YoBfV']")
	public static WebElement maxPriceFilter;
	@FindBy(how = How.XPATH, using = "//div[@class='_1qKb_B']//select//option[@value=1000]")
	public static WebElement minOptionValue;
	@FindBy(how = How.XPATH, using = "//div[@class='_1YoBfV']//select//option[@value=2000]")
	public static WebElement maxOptionValue;
	@FindBy(how = How.XPATH, using = "//div[@class='_4IiNRh _2mtkou'][@title='Puma']//div[@class='_1p7h2j']")
	public static WebElement selectBrand;
	@FindBy(how = How.XPATH, using = "//div[@data-id='SHOF3XMABCTN6VBR']")
	public static WebElement firstProduct;
	@FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']//span")
	public static WebElement buyNowBtn;
	@FindBy(how = How.XPATH, using = "//span[text()='Please select a Size- UK/India to proceed']")
	public static WebElement notifyMsg;
	@FindBy(how = How.XPATH, using = "//button[text()='NOTIFY ME']")
	public static WebElement notifyMe;
	@FindBy(how = How.XPATH, using = "//span[text()='Login or Signup']")
	public static WebElement loginPage;
	
	
	
	public FlipkartElements(WebDriver driver) {
		this.driver = driver;
	}
}
