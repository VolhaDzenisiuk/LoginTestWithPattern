package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pageobjects.LoggedInPage;
import pageobjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

	private LoginPage loginPage;
	private LoggedInPage loggedInPage;
	private final String URL = "https://www.tut.by";

	@BeforeEach
	public void before() {
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
		driver.get(URL);
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		assertEquals("Selenium Test", loggedInPage.getLoggedInUsername().getText(), "Can't login");
	}

	@Test
	public void testLogout() {
		LoggedInPage loggedInPage = loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		loggedInPage.logout();
		assertEquals("Войти", loginPage.getLoginLink().getText(), "Can't logout");
	}
}
