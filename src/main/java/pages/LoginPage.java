package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.DataForRegistration;
import utils.Waiting;

public class LoginPage {
	private WebDriver driver;
	private HomePage homePage;
	private Waiting waiting;
	private MyAccountPage successfulLogin;
	private DataForRegistration data = DataForRegistration.loadData();
	private String email = data.getEmail();
	private String password = data.getPassword();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(driver);
		waiting = new Waiting(driver);
		successfulLogin = new MyAccountPage(driver);
	}

	public void openLoginPage() {

		homePage.openPage();
		homePage.toLogin();
	}

	public void inputEmail() {
		waiting.fluentVisibilty(By.id("input-email")).sendKeys(email);
	}

	public void inputPassword() {
		driver.findElement(By.id("input-password")).sendKeys(password);

	}

	public void clickLogin() {
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

	public void login() {
		openLoginPage();
		inputEmail();
		inputPassword();
		clickLogin();
	}

	public String isLoggedin() {
		return successfulLogin.getPageTitle();
	}
}
