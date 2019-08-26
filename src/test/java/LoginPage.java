import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	private String URL = "https://www.tut.by";

	@FindBy(className = "enter")
	private WebElement LOGIN_LINK;

	@FindBy(name = "login")
	private WebElement USERNAME;

	@FindBy(name = "password")
	private WebElement PASSWORD;

	@FindBy(xpath = "//input[@tabindex='4']")
	private WebElement LOGIN_BUTTON;

	@FindBy(css = "span[class='uname']")
	private WebElement LOGGED_IN_USERNAME;

	@FindBy(xpath = "//a[contains(@href, 'profile.tut.by/logout')]")
	private WebElement LOGOUT_BUTTON;

	public LoginPage() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}

	public void load() {
		this.driver.get(URL);
		this.driver.manage().window().maximize();
	}

	public void close() {
		this.driver.close();
	}

	public void login(String username, String password) {
		LOGIN_LINK.click();
		USERNAME.sendKeys(username);
		PASSWORD.sendKeys(password);
		LOGIN_BUTTON.click();
	}

	public String logout() {
		LOGGED_IN_USERNAME.click();
		LOGOUT_BUTTON.click();
		return LOGIN_LINK.getText();
	}

	public WebElement getLoggedInUsername() {
		return LOGGED_IN_USERNAME;
	}

	public WebElement getLoginLink() {
		return LOGIN_LINK;
	}
}
