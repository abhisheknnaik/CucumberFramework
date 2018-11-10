package managers;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {
	private WebDriver driver;
	private static String driverType;
	private static String environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {

		if (System.getProperty("excecutionEnvironment") != null) {
			System.out.println(System.getProperty("excecutionEnvironment"));
		}
		if (System.getProperty("excecutionBrowser") != null) {
			System.out.println(System.getProperty("excecutionBrowser"));
			driverType=System.getProperty("excecutionBrowser");
		} else {
			driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		}
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case "local":
			driver = createLocalDriver();
			break;
		case "remote":
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {

		switch (driverType) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"G:\\Selenium_Automation\\seleniumandjavabasic-master\\drivers\\geckodriver.exe");

			// File pathBinary = new File(
			// "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			// Set binary is very important for CI , as jenkins need the binary
			// path of chrome
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setBinary("C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			System.setProperty(CHROME_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new ChromeDriver();
			break;
		case "iexplorer":
			System.setProperty("webdriver.ie.driver",
					"G:\\Selenium_Automation\\seleniumandjavabasic-master\\drivers\\IEDriverServer.exe");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();

			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setCapability("ignoreProtectedModeSettings", true);
			cap.setCapability("initialBrowserUrl", "www.google.co.in");
			cap.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
			cap.setCapability("ignoreZoomSetting", true);

			driver = new InternetExplorerDriver(cap);
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}