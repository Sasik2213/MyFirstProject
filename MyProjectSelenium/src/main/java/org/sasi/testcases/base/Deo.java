package org.sasi.testcases.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Deo {
	
	public static Properties prop;
	public static void main(String[] args) {
		prop = new Properties();
		File configFile = new File(System.getProperty("user.dir")+"\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(configFile);
		prop.load(fis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("url"));
	}

}
