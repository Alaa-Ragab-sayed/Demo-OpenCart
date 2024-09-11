package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = ConfigReader.getBrowser();
			driver.manage().window().maximize();
		}
		return driver;

	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
