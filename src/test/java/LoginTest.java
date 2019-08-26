import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {

	private LoginPage loginPage;

	@Before
	public void openBrowser() {
		loginPage = new LoginPage();
		loginPage.load();
	}

	@Test
	public void testLogin() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		assertEquals("Can't login", "Selenium Test", loginPage.getLoggedInUsername().getText());
	}

	@Test
	public void testLogout() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		loginPage.logout();
		assertEquals("Can't logout", "Войти", loginPage.getLoginLink().getText());
	}

	@After
	public void closeBrowser() {
		loginPage.close();
	}
}
