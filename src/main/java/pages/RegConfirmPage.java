package pages;

import org.openqa.selenium.WebDriver;

import utils.Waiting;

public class RegConfirmPage {
	private Waiting waiting;

	public RegConfirmPage(WebDriver driver) {
		this.waiting = new Waiting(driver);

	}

	public String getTitlePage() {
		return waiting.loadURL("success");
	}
}
