package com.brainmentors.utils;

import java.util.ResourceBundle;

public interface BundleReader {
	ResourceBundle rb = ResourceBundle.getBundle("config");
	public static String getValue(String key) {
		return rb.getString(key);
	}

}
