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

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.CartPage;
import utils.WebDriverManager;

public class CartTest {
	CartPage cartPage;
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = WebDriverManager.getDriver();
		cartPage = new CartPage(driver);

	}

	@Feature("Shopping Cart Feature")
	@Severity(SeverityLevel.NORMAL)
	@Step("Test access to cart page")
	@Test(priority = 0)
	public void testAccesstoCartPage() throws InterruptedException {
		cartPage.addItemsAfterLogin();
		cartPage.toCartPageAfterAdding();
		Assert.assertEquals("Shopping Cart", cartPage.titleForCartPage());

	}

	@Feature("Shopping Cart Feature")
	@Severity(SeverityLevel.CRITICAL)
	@Step("Verify items in the cart")
	@Test(priority = 1)
	public void testVerifyItems() throws TimeoutException {
		List<String> selectedItems = cartPage.verifyItems();// create a List at first to receive that List in CartPage
		Assert.assertEquals(selectedItems, Arrays.asList("iPhone", "MacBook"));

	}

	@Feature("Shopping Cart Feature")
	@Severity(SeverityLevel.CRITICAL)
	@Step("Access to checkout process")
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
