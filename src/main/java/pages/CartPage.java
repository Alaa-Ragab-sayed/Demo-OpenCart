package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.JavaScriptCode;
import utils.Waiting;

public class CartPage {
	private WebDriver driver;
	private HomePage homePage;
	private Waiting waiting;
	private LoginPage loginpage;
	private CheckoutPage checkoutPage;
	private JavaScriptCode js;
	private WebElement iPhoneItem;
	private WebElement macBookItem;
	private By checkoutButtonLocator = By.cssSelector("#content > div.row > div.col.text-end > a");
	private By iPhoneItemLocator = By
			.cssSelector("#shopping-cart > div > table > tbody > tr:nth-child(1) > td.text-start.text-wrap > a");
	private By macBookItemLocator = By
			.cssSelector("#shopping-cart > div > table > tbody > tr:nth-child(2) > td.text-start.text-wrap > a");

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.waiting = new Waiting(driver);
		this.js = new JavaScriptCode(driver);
		this.homePage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}

	public void addItemsAfterLogin() throws InterruptedException {

		loginpage.openLoginPage();
		loginpage.inputEmail();
		loginpage.inputPassword();
		homePage.openPage();
		homePage.selectItems();
	}

	public void toCartPageAfterAdding() {
		homePage.openItemsList();
		homePage.toCartPage();

	}

	public String titleForCartPage() {
		return driver.getTitle();
	}

	public List<String> verifyItems() {
		List<String> items = new ArrayList<>();
		iPhoneItem = waiting.fluentVisibilty(iPhoneItemLocator);
		macBookItem = waiting.fluentVisibilty(macBookItemLocator);
		items.add(iPhoneItem.getText());
		items.add(macBookItem.getText());
		return items;
	}

	public void clickCheckout() {
		js.scrollToElement(checkoutButtonLocator).click();
	}

	public String accessToCheckout() {
		return checkoutPage.getPageTitle();

	}
}
