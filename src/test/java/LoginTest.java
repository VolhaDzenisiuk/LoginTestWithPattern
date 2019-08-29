import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginTest {

	private LoginPage loginPage;
	private WebDriver driver;

	@BeforeEach
	public void openBrowser() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		loginPage.load();
	}

	@AfterEach
	public void closeBrowser() {
		loginPage.close();
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
}
