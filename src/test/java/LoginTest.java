import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals("Selenium Test", loginPage.getLoggedInUsername().getText(), "Can't login");
	}

	@Test
	public void testLogout() {
		loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
		loginPage.logout();
		assertEquals("Войти", loginPage.getLoginLink().getText(), "Can't logout");
	}
}
