package cucumber;

import managers.PageManager;
import managers.WebDriverManager;

public class TestContext {

	private PageManager pageman;
	private WebDriverManager webdriver;
	private ScenarioContext scenContext;

	public TestContext() {
		webdriver = new WebDriverManager();
		pageman = new PageManager(webdriver.getDriver());
		scenContext = new ScenarioContext();
	}

	public PageManager getPageManager() {
		return pageman;

	}

	public WebDriverManager getWebDriverManager() {
		return webdriver;

	}

	public ScenarioContext getScenContext() {
		return scenContext;
	}

}
