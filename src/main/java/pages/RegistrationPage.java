package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.DataForRegistration;
import utils.JavaScriptCode;
import utils.Waiting;

public class RegistrationPage {

	private WebDriver driver;
	private HomePage homePage;
	private Waiting waiting;
	private RegConfirmPage confirmation;
	private JavaScriptCode js;
	private DataForRegistration data;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private By firstNameLocator = By.id("input-firstname");
	private By lastNameLocator = By.id("input-lastname");
	private By emailLocator = By.id("input-email");
	private By passwordLocator = By.id("input-password");
	private By continueButtton = By.cssSelector(".btn.btn-primary");
	private By newsletterlocator = By.id("input-newsletter");
	private By privacyLocator = By.name("agree");

	// Constructor
	public RegistrationPage(WebDriver driver) {
		this.homePage = new HomePage(driver);
		this.driver = driver;
		this.data = DataForRegistration.loadData();
		this.firstName = data.getFirstName();
		this.lastName = data.getLastName();
		this.email = data.getEmail();
		this.password = data.getPassword();
		this.waiting = new Waiting(driver);
		confirmation = new RegConfirmPage(driver);
		this.js = new JavaScriptCode(driver);

	}

	public void openRegistPage() {
		homePage.openPage();
		homePage.toRegistration();
	}

	public void inputFirstName() {
		waiting.fluentVisibilty(firstNameLocator).sendKeys(firstName);

	}

	public void inputLastName() {
		driver.findElement(lastNameLocator).sendKeys(lastName);

	}

	public void inputEmail() {
		driver.findElement(emailLocator).sendKeys(email);

	}

	public void inputPassword() {
		driver.findElement(passwordLocator).sendKeys(password);

	}

	public void subscribeNewsletter() {
		js.scrollToElement(newsletterlocator).click();
	}

	public void agreeToPrivacy() {
		waiting.fluentVisibilty(privacyLocator).click();

	}

	public void clickContinue() {
		waiting.fluentVisibilty(continueButtton).click();
	}

	public String verifyRegist() {
		return confirmation.getTitlePage();

	}
}
