package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.LoggedInPage;
import pageobjects.LoginPage;

import static org.testng.Assert.assertEquals;

@Listeners(Listener.class)
public class LoginTest extends BasePage {

	private LoginPage loginPage;
	private LoggedInPage loggenInPage;
	private final String URL = "https://www.tut.by";

	@BeforeMethod
	public void before() {
		openBrowser();
		goToPage(URL);
		loginPage = new LoginPage(driver);
		loggenInPage = new LoggedInPage(driver);
	}

	@AfterMethod
	public void after() {
		closeBrowser();
	}

	@Feature("Login")
	@Description("As a user I want to be able to login")
	@Link("LGN-1")
	@Test
	public void testLogin() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		assertEquals("Selenium Test", loggenInPage.getLoggedInUsername(), "Can't login");
	}

	@Feature("Login")
	@Description("As a user I want to be able to logout")
	@Link("LGN-2")
	@Test
	public void testLogout() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		loggenInPage.logout();
		assertEquals("Войти", loginPage.getLoginLink(), "Can't logout");
	}
}
