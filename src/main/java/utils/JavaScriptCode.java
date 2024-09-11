package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptCode {
	private JavascriptExecutor js;
	private Waiting waiting;

	public JavaScriptCode(WebDriver driver) {
		this.js = (JavascriptExecutor) driver;
		this.waiting = new Waiting(driver);
	}

	public WebElement scrollToElement(By locator) {
		WebElement element = waiting.fluentPresence(locator);// wait until element exist in DOM.
		if (element != null) {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			element = waiting.fluentVisibilty(locator);
			return element;
		} else {
			System.out.println("Element is null after scroll.");
		}
		return null;

	}

	public void click(By locator) {
		WebElement element = (waiting.fluentPresence(locator));
		js.executeScript("arguments[0].click();", element);
	}

}
