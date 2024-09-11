package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.RegistrationPage;
import utils.ScreenshotHelper;
import utils.WebDriverManager;

public class RegistrationTest {
	private RegistrationPage registrationPage;
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = WebDriverManager.getDriver();
		registrationPage = new RegistrationPage(driver);
		
	}

	@Test
	public void testValidLogin() {
		registrationPage.openRegistPage();
		registrationPage.inputFirstName();
		registrationPage.inputLastName();
		registrationPage.inputEmail();
		registrationPage.inputPassword();
		registrationPage.subscribeNewsletter();
		registrationPage.agreeToPrivacy();
		registrationPage.clickContinue();
		Assert.assertEquals("Your Account Has Been Created!", registrationPage.verifyRegist());
	}
	@AfterMethod
	public void captureFailedTest(ITestResult result) {
		ScreenshotHelper.takeScreenshot(driver, result);
	}

	@AfterClass
	public void quitFromDriver() {
		WebDriverManager.quitDriver();
	}

}
