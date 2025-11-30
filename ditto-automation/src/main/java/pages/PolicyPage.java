package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.WaitUtils;

public class PolicyPage {
	private static final Logger logger = LogManager.getLogger(LandingPage.class);
	private WebDriver driver;
	private String policyPageUrl = "https://app.joinditto.in/health/fq/care-supreme/policy";
	
	@FindBy(xpath = "//span[text() = \"Hospitalization\"]")
	private WebElement hospitalization;
	
	@FindBy(xpath = "//span[text() = \"Pre-Hospitalization\"]")
	private WebElement preHospitalization;
	
	@FindBy(xpath = "//span[text() = \"Post-Hospitalization\"]")
	private WebElement postHospitalization;
	
	@FindBy(xpath = "//span[text() = \"Room Category\"]")
	private WebElement roomCategory;
	
	@FindBy(xpath = "//span[text() = \"Day Care Treatments\"]")
	private WebElement dayCareTreatment;
	
	@FindBy(xpath = "//span[text() = \"Domiciliary Treatment\"]")
	private WebElement domiciliaryTreatment;
	
	@FindBy(xpath = "//span[text()=\"30 days\"]")
	private WebElement thirtyDay;
	
	@FindBy(xpath = "//span[text()=\"2 years\"]")
	private WebElement twoYear;
	
	@FindBy(xpath = "//span[text()=\"3 years\"]")
	private WebElement threeYear;
	
	@FindBy(xpath = "//span[text()=\"Maternity expenses\"]")
	private WebElement matExpense;
	
	@FindBy(xpath = "//span[text()=\"Unproven, experimental Treatments\"]")
	private WebElement unproven;
	
	@FindBy(xpath = "//span[text()=\"Suicide or Self-inflicted injury\"]")
	private WebElement suicide;
	
	@FindBy(xpath = "//span[text()=\"Bonus\"]")
	private WebElement bonus;
	
	@FindBy(xpath = "//span[text()=\"Unlimited Restoration\"]")
	private WebElement unlimRestore;
	
	@FindBy(xpath = "//span[text()=\"Health Checkup\"]")
	private WebElement healthCheckup;
	
	@FindBy(xpath = "//span[text()=\"Next\"]")
	private WebElement nextButton;
	
	@FindBy(xpath = "//span[text()=\"Continue\"]")
	private WebElement continueButton;
	
	public PolicyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void open() {
        driver.get(policyPageUrl);
        WaitUtils.waitForPageLoad(driver, 15);
    }
	
	public boolean validatedCurrentUrl(String url) {
		if(url == policyPageUrl) return true;
		else return false;
	}
	
	public void validateMainBenefits() {
		logger.info("validateMainBenefits()");
		WaitUtils.waitForVisibility(driver, hospitalization, 5);
		assert hospitalization.isDisplayed():"Hospitalization Element is not Displayed";
		WaitUtils.waitForVisibility(driver, preHospitalization, 5);
		assert preHospitalization.isDisplayed() : "Pre Hospitalization Element is not Displayed";
		WaitUtils.waitForVisibility(driver, postHospitalization, 5);
		assert postHospitalization.isDisplayed() : "Post Hospitalization Element is not Displayed";
		WaitUtils.waitForVisibility(driver, roomCategory, 5);
		assert roomCategory.isDisplayed() : "Room Category Element is not Disaplayed";
		WaitUtils.waitForVisibility(driver, dayCareTreatment, 5);
		assert dayCareTreatment.isDisplayed() : "Day Care Treatment is not displayed";
		WaitUtils.waitForVisibility(driver, domiciliaryTreatment, 5);
		assert domiciliaryTreatment.isDisplayed() : "Domicilary Treatment Element is not displayed";
	}
	
	public void validateWaitingPeriod() {
		logger.info("validateWaitingPeriod()");
		WaitUtils.waitForVisibility(driver, thirtyDay, 5);
		assert thirtyDay.isDisplayed():"30 Days Element is not Displayed";
		WaitUtils.waitForVisibility(driver, twoYear, 5);
		assert twoYear.isDisplayed() : "2 years Element is not Displayed";
		WaitUtils.waitForVisibility(driver, threeYear, 5);
		assert threeYear.isDisplayed() : "3 years Element is not Displayed";
	}
	
	public void validateWhatsNotCovered() {
		logger.info("validateWhatsNotCovered()");
		WaitUtils.waitForVisibility(driver, matExpense, 5);
		assert matExpense.isDisplayed():"Maternity expenses Element is not Displayed";
		WaitUtils.waitForVisibility(driver, unproven, 5);
		assert unproven.isDisplayed() : "Unproven, experimental Treatments Element is not Displayed";
		WaitUtils.waitForVisibility(driver, suicide, 5);
		assert suicide.isDisplayed() : "Suicide or Self-inflicted injury Element is not Displayed";
	}
	
	public void valdidateExtraBenefits() {
		logger.info("valdidateExtraBenefits()");
		WaitUtils.waitForVisibility(driver, bonus, 5);
		assert bonus.isDisplayed():"Bonus Element is not Displayed";
		WaitUtils.waitForVisibility(driver, unlimRestore, 5);
		assert unlimRestore.isDisplayed() : "Unlimited Restoration Element is not Displayed";
		WaitUtils.waitForVisibility(driver, healthCheckup, 5);
		assert healthCheckup.isDisplayed() : "Health Checkup Element is not Displayed";
	}
	
	public void clickNext() {
		logger.info("clickNext()");
		WaitUtils.waitForClick(driver, nextButton, 5);
		nextButton.click();
	}
	
	public MemberPage clickContinue() {
		logger.info("clickContinue()");
		WaitUtils.waitForClick(driver, continueButton, 5);
		continueButton.click();
		return new MemberPage(driver);
	}
}
