package pages;

import org.openqa.selenium.WebDriver;

import utils.Waiting;

public class MyAccountPage {
	private Waiting waiting;
	public MyAccountPage(WebDriver driver) {
		this.waiting = new Waiting(driver);
	}

	public String getPageTitle() {
		return waiting.loadURL("customer");
	}
}
