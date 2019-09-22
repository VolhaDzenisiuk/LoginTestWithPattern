package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

	protected static WebDriver driver;

	public void openBrowser() throws MalformedURLException {

		String sauceUserName = System.getenv("SAUCE_USERNAME");
		String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
		String sauceURL = "https://ondemand.eu-central-1.saucelabs.com/wd/hub";

		//Windows 10, Microsoft Edge (latest version)
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setCapability("platform", "Windows 10");
		edgeOptions.setCapability("version", "16.16299");

		//Windows 8.1, Mozilla Firefox 39.0
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("platform", "Windows 8.1");
		firefoxOptions.setCapability("version", "39.0");

		//Linux, Google Chrome 40
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("platform", "Linux");
		chromeOptions.setCapability("version", "40.0");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("username", sauceUserName);
		caps.setCapability("accessKey", sauceAccessKey);
		caps.setCapability("edgeOptions", edgeOptions);
//		caps.setCapability("moz:firefoxOptions", firefoxOptions);
//		caps.setCapability("chromeOptions", chromeOptions);

		driver = new RemoteWebDriver(new URL(sauceURL), caps);
		driver.manage().window().maximize();
	}

	public void closeBrowser(){
		driver.close();
	}

	public void goToPage(String URL) {
		driver.get(URL);
	}
}
