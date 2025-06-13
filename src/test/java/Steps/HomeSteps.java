package Steps;

import com.google.gson.Gson;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.FileManager;
import pageObjects.Homepage;
import pageObjects.ProductListing;
import testDataTypes.Customer;

public class HomeSteps {

//	private static WebDriver driver;
//	PageManager pagemanager;
//	// ConfigFileReader config;
//	WebDriverManager webDriverManager;
	TestContext testContext;
	Homepage home;
	ProductListing productListing;

	public HomeSteps(TestContext context) {
		testContext = context;
		home = testContext.getPageManager().getHomePage();
		productListing = testContext.getPageManager().getProductList();
	}
//	public sample() {
//	}

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		// config = new ConfigFileReader();
//		System.setProperty("webdriver.chrome.driver", FileManager.getInstance().getConfigFileReader().getDriverPath());// config.getDriverPath()
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// webDriverManager = new WebDriverManager();
		// driver = webDriverManager.getDriver();
		// home = new PageManager(driver).getHomePage(); // home = new Homepage(driver);
		// made a common file reader to avoid creating object of property file in every
		// class
		home.navigateTo(FileManager.getInstance().getConfigFileReader().getApplicationUrl());
		home.verifyFlipHome();
	}

	@When("User Searches for {string}")
	public void user_searches_for(String item) {
		// to check json data being retrived
		Customer cust = FileManager.getInstance().getJsonFileReader().getCustomerDataByName("Joel");
		Gson gson = new Gson();
		System.out.println(gson.toJson(FileManager.getInstance().getJsonFileReader().getCustomerData()));
		System.out.println(gson.toJson(cust)); // to print the customer details from json
		home.globalSearchFor(item);
	}

}
