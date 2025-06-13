package managers;

import dataProviders.ConfigFileReader;
import dataProviders.jsonDataReader;

public class FileManager {

	private static FileManager fileManager = new FileManager();
	private static ConfigFileReader configFileReader;
	private static jsonDataReader jsonreader;

	public static FileManager getInstance() {
		return fileManager;
	}

	public ConfigFileReader getConfigFileReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}

	public jsonDataReader getJsonFileReader() {
		return (jsonreader == null) ? new jsonDataReader() : jsonreader;
	}

}
