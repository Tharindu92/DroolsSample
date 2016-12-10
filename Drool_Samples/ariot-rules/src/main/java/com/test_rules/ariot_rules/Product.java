package com.test_rules.ariot_rules;

import net.sf.json.JSONObject;

public class Product {
	private JSONObject parameters;
	private boolean anomely;
	
	public JSONObject getParameters() {
		return parameters;
	}
	public void setParameters(JSONObject parameters) {
		this.parameters = parameters;
	}
	public boolean isAnomely() {
		return anomely;
	}
	public void setAnomely(boolean anomely) {
		this.anomely = anomely;
	}	
}
