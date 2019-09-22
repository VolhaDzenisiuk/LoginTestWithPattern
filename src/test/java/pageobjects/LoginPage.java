package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	protected WebDriver driver;

	private final By loginLink = By.cssSelector(".enter");
	private final By usernameField = By.cssSelector("input[name='login']");
	private final By passwordField = By.cssSelector("input[name='password']");
	private final By loginButton = By.cssSelector("input[tabindex='4']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoggedInPage login(String username, String password) {
		driver.findElement(loginLink).click();
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		return new LoggedInPage(driver);
	}

	public String getLoginLink() {
		return driver.findElement(loginLink).getText();
	}
}
