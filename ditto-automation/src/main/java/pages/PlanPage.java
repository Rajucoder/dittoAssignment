package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class PlanPage {
	private static final Logger logger = LogManager.getLogger(LandingPage.class);
	private WebDriver driver;
	private String planPageUrl = "https://app.joinditto.in/health/fq/care-supreme/plan";
	
	@FindBy(xpath = "//input[contains(@name, \"Selfage\")]")
	private WebElement yourAge;
	
	@FindBy(xpath = "//input[contains(@name, \"Spouseage\")]")
	private WebElement spouseAge;
	
	@FindBy(xpath = "//input[contains(@placeholder, \"Enter your pin code\")]")
	private WebElement pincode;
	
	@FindBy(xpath = "//p[contains(@class, \"mantine-NumberInput-error\")]")
	private List<WebElement> error;
	
	@FindBy(xpath = "//span[text()=\"Calculate Premium\"]")
	private WebElement calculatePremium;
	
	
	public PlanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void open() {
        driver.get(planPageUrl);
        WaitUtils.waitForPageLoad(driver, 15);
    }
	
	public boolean validatedCurrentUrl(String url) {
		logger.info("validatedCurrentUrl");
		if(url == planPageUrl) return true;
		else return false;
	}
	
	public int noOfErr() {
		logger.info("noOfErr");
		return error.size();
	}
	
	public void enterYourAge(int yAge) {
		logger.info("enterYourAge");
		assert yourAge.isDisplayed();
		yourAge.sendKeys(Integer.toString(yAge));
	}
	
	public void enterSpouseAge(int sAge) {
		logger.info("enterSpouseAge");
		assert spouseAge.isDisplayed();
		spouseAge.sendKeys(Integer.toString(sAge));
	}
	
	public void enterPincode(String pin) {
		logger.info("enterPincode");
		assert pincode.isDisplayed();
		pincode.sendKeys(pin);
	}
	
	public String getErrorText(int index) {
		logger.info("getErrorText");
		assert error.get(index).isDisplayed():"Error Message is not Displayed";
		return error.get(index).getText();
	}
	
	public void clickCalculatePremium() {
		logger.info("clickCalculatePremium");
		WaitUtils.waitForClick(driver, calculatePremium, 10);
		calculatePremium.click();
	}
	
	public PremiumSummaryPage postiveClickCalculatePremium() {
		logger.info("postiveClickCalculatePremium");
		WaitUtils.waitForClick(driver, calculatePremium, 10);
		calculatePremium.click();
		return new PremiumSummaryPage(driver);
	}
}
