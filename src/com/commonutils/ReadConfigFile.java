package com.commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	public Properties readConfigData() throws IOException{
		File file = new File("C:\\Users\\PRIYA\\workspace\\com.framework\\src\\config.properties");
		FileInputStream fileInputStream =  new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}

}
