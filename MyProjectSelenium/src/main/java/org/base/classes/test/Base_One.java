package org.base.classes.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Base_One {
	
	public WebDriver driver;
	public String snapShotMaker(String name,WebDriver driver) {
		
		File srcPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir")+"\\prpScreenshots\\"+name+".png";
		try {
			FileHandler.copy(srcPath,new File(destPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destPath;
		
	}

}
