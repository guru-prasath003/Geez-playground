package selenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileManager;

public class Waits {

	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, int waitTimeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeout));
		wait.withTimeout(Duration.ofSeconds(waitTimeout));
		try {
			wait.until(waitCondition);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
		until(driver, waitCondition, FileManager.getInstance().getConfigFileReader().getImplicitlyWait());
	}

	public static void untiljQueryIsDone(WebDriver driver, int waitTimeout) {
		until(driver, (d) -> {
			Boolean jQuertDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!jQuertDone)
				System.out.println("jQuer is still active");
			return jQuertDone;
		}, waitTimeout);
	}

	public static void untiljQueryIsDone(WebDriver driver) {
		untiljQueryIsDone(driver, FileManager.getInstance().getConfigFileReader().getImplicitlyWait());
	}

	public static void waitTillPageLoads(WebDriver driver, int waitTimeout) {
		until(driver, (d) -> {
			Boolean isLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState")
					.equals("Complete");
			if (!isLoaded)
				System.out.println("Document is still loading");
			return isLoaded;
		}, waitTimeout);
	}

	public static void waitTillPageLoads(WebDriver driver) {
		waitTillPageLoads(driver, FileManager.getInstance().getConfigFileReader().getImplicitlyWait());
	}

}
