import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	private String URL = "https://www.tut.by";

	@FindBy(css = ".enter")
	private WebElement loginLink;

	@FindBy(css = "input[name='login']")
	private WebElement usernameField;

	@FindBy(css = "input[name='password']")
	private WebElement passwordField;

	@FindBy(css = "input[tabindex='4']")
	private WebElement loginButton;

	@FindBy(css = "a[href*='profile.tut.by/logout']")
	private WebElement logoutButton;

	@FindBy(css = "span[class='uname']")
	private WebElement loggedInUsername;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void load() {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public void close() {
		driver.close();
	}

	public void login(String username, String password) {
		loginLink.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	public void logout() {
		loggedInUsername.click();
		logoutButton.click();
	}

	public WebElement getLoggedInUsername() {
		return loggedInUsername;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}
}
