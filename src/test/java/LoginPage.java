import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	private String URL = "https://www.tut.by";
	private By loginLink = By.cssSelector(".enter");
	private By usernameField = By.cssSelector("input[name='login']");
	private By passwordField = By.cssSelector("input[name='password']");
	private By loginButton = By.cssSelector("input[tabindex='4']");
	private By logoutButton = By.cssSelector("a[href*='profile.tut.by/logout']");
	private By loggedInUsername = By.cssSelector("span[class='uname']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void load() {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public void close() {
		driver.close();
	}

	public void login(String username, String password) {
		driver.findElement(loginLink).click();
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void logout() {
		driver.findElement(loggedInUsername).click();
		driver.findElement(logoutButton).click();
	}

	public WebElement getLoggedInUsername() {
		return driver.findElement(loggedInUsername);
	}

	public WebElement getLoginLink() {
		return driver.findElement(loginLink);
	}
}
