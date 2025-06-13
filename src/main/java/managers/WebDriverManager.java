package managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

	private static WebDriver driver;
	private static EnvironmentType envType;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		envType = FileManager.getInstance().getConfigFileReader().getEnvironment();
		driverType = FileManager.getInstance().getConfigFileReader().getdriver();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	public WebDriver createDriver() {
		switch (envType) {
		case local:
			driver = createLocalDriver();
			break;
		case remote:
			driver = createRemoteDriver();
			break;
		case cloud:
			driver = creteaCloudDriver();
			break;
		default:
			break;
		}
		return driver;
	}

	public WebDriver creteaCloudDriver() {
		throw new RuntimeException("CloudWebDriver is not yet implemented");
	}

	public WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	public WebDriver createLocalDriver() {
		switch (driverType) {
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, FileManager.getInstance().getConfigFileReader().getDriverPath());
		    System.setProperty("extent.reporter.html.out", "test-output/ExtentReport.html");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
		if (FileManager.getInstance().getConfigFileReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(
				Duration.ofSeconds(FileManager.getInstance().getConfigFileReader().getImplicitlyWait()));
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
