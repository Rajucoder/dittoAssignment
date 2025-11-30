package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class MemberPage {
	private static final Logger logger = LogManager.getLogger(LandingPage.class);
	private WebDriver driver;
	private String memberPageUrl = "https://app.joinditto.in/health/fq/care-supreme/members";
	
	@FindBy(xpath = "//div[text()=\"Male\"]")
	List<WebElement> maleButton;
	
	@FindBy(xpath = "//div[text()=\"Female\"]")
	List<WebElement> femaleButton;
	
	@FindBy(xpath = "//span[text()=\"Self\"]")
	WebElement selfLocator;
	
	@FindBy(xpath = "//span[text()=\"Spouse\"]")
	WebElement spouseLocator;
	
	@FindBy(xpath = "//span[text()=\"Next step\"]")
	WebElement nextStepButton;
	
	public MemberPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void open() {
        driver.get(memberPageUrl);
        WaitUtils.waitForPageLoad(driver, 15);
    }
	
	public boolean validatedCurrentUrl(String url) {
		logger.info("validatedCurrentUrl");
		if(url == memberPageUrl) return true;
		else return false;
	}
	
	public void validateSelf() {
		logger.info("validateSelf");
		WaitUtils.waitForClick(driver, selfLocator, 5);
	}
	
	public void validateSpouse() {
		logger.info("validateSpouse");
		WaitUtils.waitForClick(driver, spouseLocator, 5);
	}
	
	public void selectSelf(String self) {
		logger.info("selectSelf");
		validateSelf();
		if(self == "Male") {
			WaitUtils.waitForClick(driver, maleButton.get(0), 5);
			maleButton.get(0).click();
			assert maleButton.get(0).isDisplayed(): "Male in Self is not Selected";
		}
		if(self == "Female") {
			WaitUtils.waitForClick(driver, femaleButton.get(0), 5);
			femaleButton.get(0).click();
			assert femaleButton.get(0).isDisplayed(): "Female in Self is not Selected";
		}
	}
	
	public void selectSpouse(String self) {
		logger.info("selectSpouse");
		validateSpouse();
		if(self == "Male") {
			WaitUtils.waitForClick(driver, maleButton.get(1), 5);
			maleButton.get(1).click();
			assert maleButton.get(1).isDisplayed(): "Male in Spouse is not Selected";
		}
		if(self == "Female") {
			WaitUtils.waitForClick(driver, femaleButton.get(1), 5);
			femaleButton.get(1).click();
			assert maleButton.get(1).isDisplayed(): "Male in Spouse is not Selected";
		}
	}
	
	public PlanPage clickNextStep() {
		logger.info("clickNextStep");
		WaitUtils.waitForClick(driver, nextStepButton, 10);
		nextStepButton.click();
		return new PlanPage(driver);
	}
}
