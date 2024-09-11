package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ConfigReader {
	private static Properties properties = new Properties();

	static {
		String configPath = System.getProperty("configFilePath",
				"D:\\Automation Projects\\opencart-testing\\resources\\config.properties");
		try (FileReader fileReader = new FileReader(configPath)) {
			properties.load(fileReader);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load configuration file", e);
		}
	}

	public static String getBaseUrl() {
		return properties.getProperty("baseUrl");
	}

	public static String getJsonFile() {
		return properties.getProperty("jsonFilePath");

	}

	public static String getScreenshotsFile() {
		return properties.getProperty("screenshotsFilePath");

	}

	public static boolean isHeadless() {
		return Boolean.parseBoolean(properties.getProperty("headless", "false"));//if headless is false or any value in properties file, 
	//it return false but  if it is true , it will return true.
	}

	public static boolean isIncognito() {
		return Boolean.parseBoolean(properties.getProperty("incognito", "false"));//the same thing like headless.
	}

	public static WebDriver getBrowser() {
		String browser = properties.getProperty("browser");
		boolean headless = isHeadless();
		boolean incognito = isIncognito();

		switch (browser) {
		case "googleChrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			if (headless) {
				chromeOptions.addArguments("--headless");
			}
			if (incognito) {
				chromeOptions.addArguments("--incognito");
			}
			return new ChromeDriver(chromeOptions);

		case "fireFox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (headless) {
				firefoxOptions.addArguments("-headless");
			}
			if (incognito) {
				firefoxOptions.addArguments("-private");
			}
			return new FirefoxDriver(firefoxOptions);

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			if (headless) {
				edgeOptions.addArguments("--headless");
			}
			if (incognito) {
				edgeOptions.addArguments("--inprivate");
			}
			return new EdgeDriver(edgeOptions);

		default:
			throw new IllegalStateException("Unexpected value: " + browser);
		}
	}
}
