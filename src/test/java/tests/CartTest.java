package tests;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import utils.ScreenshotHelper;
import utils.WebDriverManager;

public class CartTest {
	CartPage cartPage;
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = WebDriverManager.getDriver();
		cartPage = new CartPage(driver);
	
	}

	@Test(priority = 0)
	public void testAccesstoCartPage() throws InterruptedException {
		cartPage.addItemsAfterLogin();
		cartPage.toCartPageAfterAdding();
		Assert.assertEquals("Shopping Cart", cartPage.titleForCartPage());

	}

	@Test(priority = 1)
	public void testVerifyItems() throws TimeoutException {
		List<String> selectedItems = cartPage.verifyItems();// create a List at first to receive that List in CartPage
		Assert.assertEquals(selectedItems, Arrays.asList("iPhone", "MacBook"));
	}

	@Test(priority = 2)
	public void testAccessToCheckout() throws TimeoutException {
		cartPage.clickCheckout();
		cartPage.accessToCheckout();
		Assert.assertEquals("Checkout", cartPage.accessToCheckout());
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
