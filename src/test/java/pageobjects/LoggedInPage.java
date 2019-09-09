package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInPage {

	protected WebDriver driver;

	@FindBy(css = "a[href*='profile.tut.by/logout']")
	private WebElement logoutButton;

	@FindBy(css = "span[class='uname']")
	private WebElement loggedInUsername;

	public LoggedInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage logout() {
		loggedInUsername.click();
		logoutButton.click();
		return new LoginPage(driver);
	}

	public String getLoggedInUsername() {
		return loggedInUsername.getText();
	}
}
