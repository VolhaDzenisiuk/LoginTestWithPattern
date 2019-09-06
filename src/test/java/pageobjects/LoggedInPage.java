package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage {

	protected WebDriver driver;

	private final By logoutButton = By.cssSelector("a[href*='profile.tut.by/logout']");
	private final By loggedInUsername = By.cssSelector("span[class='uname']");

	public LoggedInPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage logout() {
		driver.findElement(loggedInUsername).click();
		driver.findElement(logoutButton).click();
		return new LoginPage(driver);
	}

	public WebElement getLoggedInUsername() {
		return driver.findElement(loggedInUsername);
	}
}
