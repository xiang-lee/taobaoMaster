package com.master.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertityHelper {

	
	
	public String getAccessTokenURL() {
		try {
			return getPropertity("ACCESS_TOKEN_URL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	private String getPropertity(String name) throws IOException{
		String res = "";
		Properties prop = new Properties();
		// load a properties file
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("propertity.properties");
		prop.load(input);
		res = prop.getProperty(name);
		if (input != null) {
			input.close();
		}
		return res;
	}

}
