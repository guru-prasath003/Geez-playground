package cucumber;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	Map<String, Object> scenContext;

	public ScenarioContext() {
		scenContext = new HashMap<String, Object>();
	}

	public void setContext(String key, String value) {
		scenContext.put(key, value);
	}

	public Object getContext(String key) {
		return scenContext.get(key.toString());
	}

	public Boolean isContains(String key) {
		return scenContext.containsKey(key);
	}

}
