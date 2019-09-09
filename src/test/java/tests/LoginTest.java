package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageobjects.LoggedInPage;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BasePage {

	private LoginPage loginPage;
	private LoggedInPage loggenInPage;
	private final String URL = "https://www.tut.by";

	@BeforeEach
	public void before() {
		openBrowser();
		goToPage(URL);
		loginPage = new LoginPage(driver);
		loggenInPage = new LoggedInPage(driver);
	}

	@AfterEach
	public void after() {
		closeBrowser();
	}

	@Test
	public void testLogin() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		assertEquals("Can't login", "Selenium Test", loggenInPage.getLoggedInUsername());
	}

	@Test
	public void testLogout() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		loggenInPage.logout();
		assertEquals("Can't logout", "Войти", loginPage.getLoginLink());
	}
}
