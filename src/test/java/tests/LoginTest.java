package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageobjects.LoggenInPage;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BasePage {

	private LoginPage loginPage;
	private LoggenInPage loggenInPage;
	private final String URL = "https://www.tut.by";

	@BeforeEach
	public void before() {
		openBrowser();
		goToPage(URL);
		loginPage = new LoginPage(driver);
		loggenInPage = new LoggenInPage(driver);
	}

	@AfterEach
	public void after() {
		closeBrowser();
	}

	@Test
	public void testLogin() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		assertEquals("Can't login", "Selenium Test", loggenInPage.getLoggedInUsername().getText());
	}

	@Test
	public void testLogout() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		loggenInPage.logout();
		assertEquals("Can't logout", "Войти", loginPage.getLoginLink().getText());
	}
}
