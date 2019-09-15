package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	protected WebDriver driver;

	@FindBy(css = ".enter")
	private WebElement loginLink;

	@FindBy(css = "input[name='login']")
	private WebElement usernameField;

	@FindBy(css = "input[name='password']")
	private WebElement passwordField;

	@FindBy(css = "input[tabindex='4']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoggedInPage login(String username, String password) {
		loginLink.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return new LoggedInPage(driver);
	}

	public String getLoginLink() {
		return loginLink.getText();
	}
}
