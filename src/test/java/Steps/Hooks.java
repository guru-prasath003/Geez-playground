package Steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void setup() {
		/*
		 * What all you can perform here - Starting a webdriver, Setting up DB
		 * connections, Setting up test data, Setting up browser cookies, Navigating to
		 * certain page or anything before the test
		 */
		// Reporter.assignAuthor("Guru Nicojag");
	}

	@After
	public void teardown(Scenario scenario) {
		//validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = (((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES));
            scenario.attach(screenshot, "image/png", scenario.getUri().getPath() ); 
        } 
		testContext.getWebDriverManager().closeDriver();
	}

}
