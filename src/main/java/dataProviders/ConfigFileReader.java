package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

	private Properties properties;
	private final String filePath = "src/resources/java/configs/configs.properties";

	public ConfigFileReader() {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			properties.load(buffer);
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config File not available");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DriverType getdriver() {
		String driver = properties.getProperty("driver");
		if (driver == null || driver.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if (driver == null || driver.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (driver == null || driver.equalsIgnoreCase("edge"))
			return DriverType.EDGE;
		else
			throw new RuntimeException("driver not specified in the Configuration.properties file.");

	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public int getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Integer.valueOf(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.local;
		else if (environmentName.equals("remote"))
			return EnvironmentType.remote;
		else if (environmentName.equals("cloud"))
			return EnvironmentType.cloud;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	public String getTestDataPath() {
		String path = properties.getProperty("testDataPath");
		if (path != null)
			return path;
		else
			throw new RuntimeException("testDataPath not specified in the Configuration.properties file.");
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

}
