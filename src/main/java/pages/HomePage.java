package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.JavaScriptCode;
import utils.Waiting;

public class HomePage {
	private WebDriver driver;
	private JavaScriptCode js;
	private Waiting waiting;

	private By myAccount = By.cssSelector(".fa-solid.fa-user");
	private By register = By.cssSelector("a[href='https://demo.opencart.com/en-gb?route=account/register']");
	private By login = By.cssSelector("a[href='https://demo.opencart.com/en-gb?route=account/login']");
	private By cartForMacBook = By.cssSelector(
			"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(1) > div > div.content > form > div > button:nth-child(1)");
	private By cartForIPhone = By.cssSelector(
			"#content > div.row.row-cols-1.row-cols-sm-2.row-cols-md-3.row-cols-xl-4 > div:nth-child(2) > div > div.content > form > div > button:nth-child(1)");
	private By itemsListLocator = By.cssSelector(".btn.btn-lg.btn-inverse.btn-block.dropdown-toggle");
	private By viewCartLocator = By.cssSelector("a[href='https://demo.opencart.com/en-gb?route=checkout/cart']");
	private By closeAlertLocator = By.cssSelector(".btn-close");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.js = new JavaScriptCode(driver);
		this.waiting = new Waiting(driver);
	}

	public void openPage() {
		driver.get(ConfigReader.getBaseUrl());
		waiting.waitForLoadingPage();
	}

	public void toRegistration() {
		js.click(myAccount);
		js.click(register);

	}

	public void toLogin() {

		js.click(myAccount);
		js.click(login);

	}

	public void selectItems() {
		waiting.waitForLoadingPage();
		js.scrollToElement(cartForMacBook).click();// scroll then click button by JavaScript
		waiting.toBeInvisible(closeAlertLocator);
		waiting.waitForLoadingPage();
		js.scrollToElement(cartForIPhone).click();
		waiting.toBeInvisible(closeAlertLocator);
		waiting.waitForLoadingPage();
	}

	public void openItemsList() {
		waiting.waitForLoadingPage();
		js.scrollToElement(itemsListLocator).click();
	}

	public void toCartPage() {
		js.click(viewCartLocator);
	}

}
