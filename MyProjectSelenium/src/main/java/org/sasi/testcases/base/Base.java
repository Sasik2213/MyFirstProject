package org.sasi.testcases.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public File configFile;
	public FileInputStream fis;
	public void Base() {
		prop = new Properties();
		configFile = new File(System.getProperty("user.dir")+"\\config.properties");
		try {
		fis = new FileInputStream(configFile);
		prop.load(fis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void Base() { properties = new Properties(); File fileConfig = new
	 * File( System.getProperty("user.dir") +
	 * "\\src\\main\\java\\org\\sasi\\testcases\\config\\config.properties"); try {
	 * FileInputStream fis = new FileInputStream(fileConfig); properties.load(fis);
	 * } catch (Throwable e) { // TODO: handle exception e.printStackTrace(); } }
	 */

	public WebDriver implementPoject(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get("https://katalon-demo-cura.herokuapp.com");
		return driver;

		/*
		 * if (browser.equals(properties.getProperty("browser"))) { driver= new
		 * ChromeDriver(); } else if(browser.equals(properties.getProperty("browser")))
		 * { driver = new EdgeDriver(); } else { driver = new FirefoxDriver(); }
		 * driver.get(properties.getProperty("url")); return driver;
		 */
	}
}
