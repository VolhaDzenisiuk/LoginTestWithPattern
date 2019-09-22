package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pageobjects.LoggedInPage;
import pageobjects.LoginPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

	private LoginPage loginPage;
	private LoggedInPage loggedInPage;
	private final String URL = "https://www.tut.by";

	@BeforeEach
	public void before() throws MalformedURLException {
		openBrowser();
		goToPage(URL);
		loginPage = new LoginPage(driver);
		loggedInPage = new LoggedInPage(driver);
	}

	@AfterEach
	public void after() {
		closeBrowser();
	}

	@Test
	public void testLogin() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		assertEquals("Selenium Test", loggedInPage.getLoggedInUsername(), "Can't login");
	}

	@Test
	public void testLogout() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		loggedInPage.logout();
		assertEquals("Войти", loginPage.getLoginLink(), "Can't logout");
	}
}
