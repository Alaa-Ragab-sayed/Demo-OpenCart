package tests;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.WebDriverManager;

public class LoginTest {
	LoginPage loginpage;
	private WebDriver driver;

	@BeforeClass
	public void setup() throws TimeoutException {
		driver = WebDriverManager.getDriver();
		loginpage = new LoginPage(driver);
		loginpage.openLoginPage();
	}

	@Test
	public void testValidLogin() {

		loginpage.inputEmail();
		loginpage.inputPassword();
		loginpage.clickLogin();
		Assert.assertEquals("My Account", loginpage.isLoggedin());

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
