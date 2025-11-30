package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class PremiumSummaryPage {
	private static final Logger logger = LogManager.getLogger(LandingPage.class);
	private WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@class, 'mantine-Checkbox-root') and @data-checked = \"true\"]/ancestor::div[contains(@class, 'mantine-Stack-root')][1]//div[contains(@class, 'mantine-visible-from-sm')]//span[contains(text(),'Premium')]/following-sibling::span")
	private List<WebElement> checkedPremiumValue;
	
	@FindBy(xpath = "//span[text() = \"Base Premium\"]/following-sibling::span")
	private WebElement basePremiumValue;
	
	@FindBy(xpath = "//span[text() = \"Total Premium\"]/following-sibling::span")
	private WebElement totalPremiumValue;
	
	public PremiumSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public float selectedRidersValue() {
		logger.info("selectedRidersValue");
		float addOnValue = 0;
		if(checkedPremiumValue.size() == 0) {
			addOnValue = 0;
		}
		else {
			for(int i=0; i<checkedPremiumValue.size(); i++) {
				WaitUtils.waitForVisibility(driver, checkedPremiumValue.get(i), 10);
				float value = Float.parseFloat(checkedPremiumValue.get(i).getText()
						.replaceAll(",", "").replaceAll("₹", ""));
				addOnValue+=value;
			}
		}
		return addOnValue;
	}
	
	public float totalPremium() {
		logger.info("totalPremium");
		WaitUtils.waitForVisibility(driver, totalPremiumValue, 10);
		return Float.parseFloat(totalPremiumValue.getText()
				.replaceAll(",", "").replaceAll("₹", ""));
	}
	
	public float basePremium() {
		logger.info("totalPremium");
		WaitUtils.waitForVisibility(driver, basePremiumValue, 10);
		float value = Float.parseFloat(basePremiumValue.getText()
				.replaceAll(",", "").replaceAll("₹", ""));
		return value;
	}
}
