package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ScreenshotHelper {

	
	public  static void takeScreenshot(WebDriver driver,ITestResult result) {
		try {
			if (ITestResult.FAILURE == result.getStatus()) {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
				File destFile = new File(ConfigReader.getScreenshotsFile()+result.getName()+".png");
				FileUtils.copyFile(srcFile, destFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
