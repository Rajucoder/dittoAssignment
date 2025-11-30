package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.WaitUtils;

public class LandingPage {
    private static final Logger logger = LogManager.getLogger(LandingPage.class);

	private WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Care Supreme')]")
	private WebElement careSupreme;
	
	public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public PolicyPage clickHealthPlan() {
		logger.info("clickHealthPlan()");
		WaitUtils.waitForVisibility(driver, careSupreme, 5);
		careSupreme.click();
		return new PolicyPage(driver);
	}
	
	public void open() {
        driver.get("https://app.joinditto.in/fq");
        WaitUtils.waitForPageLoad(driver, 15);
    }
}
