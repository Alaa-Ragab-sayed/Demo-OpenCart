package pages;

import org.openqa.selenium.WebDriver;

import utils.Waiting;

public class CheckoutPage {
	private Waiting waiting;

	public CheckoutPage(WebDriver driver) {
		this.waiting = new Waiting(driver);
	}

	public String getPageTitle() {

		return waiting.loadURL("checkout/checkout");
	}

}
