package runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = { "Steps" },
//						 plugin = {
//						 "pretty", "json:target/cucumber-reports/Cucumber.json",
//									 "junit:target/cucumber-reports/Cucumber.xml",
//									 "html:target/cucumber-reports/Cucumber.html"
//									 },
		plugin = {
				// "me.jvt.cucumber.report.PrettyReports:target/cucumber-reports/cucumber"
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, publish = true)

public class TestRunner {

	@AfterClass
	public static void writeExtendReport() {
//		Reporter.loadXMLConfig(new File(FileManager.getInstance().getConfigFileReader().getReportConfigPath()));
//		Reporter.setSystemInfo("Guru Prasath", System.getProperty("user.name"));
//		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//		Reporter.setSystemInfo("Machine", "Windows 11" + "64 Bit");
//		Reporter.setSystemInfo("Selenium", "4.28.1");
//		Reporter.setSystemInfo("Maven", "3.9.9");
//		Reporter.setSystemInfo("Java Version", "21.0.2");
	}

}
