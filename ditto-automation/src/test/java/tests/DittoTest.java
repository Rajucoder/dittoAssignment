package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.LandingPage;
import pages.MemberPage;
import pages.PlanPage;
import pages.PolicyPage;
import pages.PremiumSummaryPage;
import utils.ScreenshotUtils;
import utils.WaitUtils;

public class DittoTest extends BaseTest{
	
    String yourAgeError = "Your age is a required field";
	
	String spouseAgeError = "Spouse's age is a required field";
	
	String pincodeError = "Pin code is required";
	@Test
    public void validatePremiumCalculation() throws Exception {
		test = extent.createTest("validatePremiumCalculation");
	    test.info("Test Started: Validating premium calculation");
		
		test.info("Open the Term and Health Insurance Landing page");
		LandingPage landing = new LandingPage(driver);
		landing.open();
		
		PolicyPage policypage = landing.clickHealthPlan();
		WaitUtils.waitForPageLoad(driver, 15);
		
		test.info("Validate MainBenefits elements and click Next");
		policypage.validateMainBenefits();
		policypage.clickNext();
		
		test.info("Validate Waiting Periods elements and click Next");
		policypage.validateWaitingPeriod();
		policypage.clickNext();
	
		test.info("Validate Whats not covered elements and click Next");
		policypage.validateWhatsNotCovered();
		policypage.clickNext();
		
		test.info("Validate Extra Benefits elements and click Continue");
		policypage.valdidateExtraBenefits();
		MemberPage memberPage = policypage.clickContinue();
		WaitUtils.waitForPageLoad(driver, 15);
		
		memberPage.selectSelf("Female");
		memberPage.selectSpouse("Male");
		
		PlanPage planPage = memberPage.clickNextStep();
		WaitUtils.waitForPageLoad(driver, 15);

		test.info("Validate Plan page elements and error messages");
		planPage.clickCalculatePremium();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		assertEquals(planPage.noOfErr(), 3, "Number of Error is Mismatching");
		
		assertTrue(planPage.getErrorText(0).contains(yourAgeError), "Your age Error Message is not present");
		assertTrue(planPage.getErrorText(1).contains(spouseAgeError), "Spouse age Error Message is not present");
		assertTrue(planPage.getErrorText(2).contains(pincodeError), "Pincode Error Message is not present");
		
		planPage.enterYourAge(27);
		planPage.enterSpouseAge(33);
		planPage.enterPincode("560104");
		
		test.info("Validate total Premium is sum of base premium and addon");
		PremiumSummaryPage premiumSummaryPage = planPage.postiveClickCalculatePremium();
		float basePremium = premiumSummaryPage.basePremium();
		float addOnPremium = premiumSummaryPage.selectedRidersValue();
		int totalPremium = (int) premiumSummaryPage.totalPremium();
		int summation = (int) (addOnPremium+basePremium);
		assertEquals(summation, totalPremium, "Total premium is not the sum of base premiums, riders selected in the plan");
		test.info("Premium calculation validated successfully");
		
        String finalShot = ScreenshotUtils.capture(driver, "final_summary");
        if (finalShot != null) test.addScreenCaptureFromPath(finalShot);
	}

}
