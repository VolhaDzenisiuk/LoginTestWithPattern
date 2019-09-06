package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	protected static WebDriver driver;

	public void openBrowser(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void closeBrowser(){
		driver.close();
	}

	public void goToPage(String URL) {
		driver.get(URL);
	}
}
