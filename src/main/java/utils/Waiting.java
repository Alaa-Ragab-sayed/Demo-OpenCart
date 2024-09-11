package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiting {
	private WebDriverWait waitFor;
	private FluentWait<WebDriver> fluent;
	private WebDriver driver;
	private JavascriptExecutor js;

	public Waiting(WebDriver driver) {
		this.waitFor = new WebDriverWait(driver, Duration.ofSeconds(50));
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(ElementNotInteractableException.class)
				.ignoring(ElementClickInterceptedException.class);

	}

	public WebElement fluentVisibilty(By locator) {
		return fluent.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public WebElement fluentPresence(By locator) {
		return fluent.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public WebElement fluentClickable(By locator) {
		return fluent.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void toBeInvisible(By locator) {
		fluent.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public String loadURL(String partialURL) {
		fluent.until(ExpectedConditions.urlContains(partialURL));// wait for a specific part of a URL

		return driver.getTitle();
	}

	public void waitForLoadingPage() {
		// We used Lambda in JAVA which is :( ->{} is an expression in Programming for
		// implementation any interface's methods.
		// webDriver is just a parameter, we can change this name.
		waitFor.until(webDriver -> {
			// Check if document is fully loaded
			String readyState = (String) js.executeScript("return document.readyState");
			if (!"complete".equals(readyState)) {
				return false;
			}

			// Check if jQuery is defined (loaded in the page)
			boolean isJQueryPresent = (Boolean) js.executeScript("return typeof jQuery !== 'undefined'");
			if (isJQueryPresent) {
				// If jQuery is present, check if all Ajax requests are done
				boolean isJQueryActive = (Boolean) js.executeScript("return jQuery.active === 0");
				if (!isJQueryActive) {
					return false;
				}
			}

			// Check if XMLHttpRequest is present, check if any requests are pending
			boolean isXHRActive = (Boolean) js
					.executeScript("return window.XMLHttpRequest && window.XMLHttpRequest.DONE !== 4");
			if (isXHRActive) {
				return false;
			}

			// Check if fetch API is used and if there are pending fetch requests
			boolean isFetchActive = (Boolean) js.executeScript("return window.fetch && window.pendingFetches > 0");
			return !isFetchActive;
		});
	}

}
