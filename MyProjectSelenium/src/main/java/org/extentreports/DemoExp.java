package org.extentreports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoExp {

	public static ExtentReports getExtentReports() {
		ExtentReports extentReports = new ExtentReports();
		File fs = new File(System.getProperty("user.dir")+"\\testing\\reportTests.html");
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fs);
		extentReports.attachReporter(extentSparkReporter);
		extentReports.flush();
		return extentReports;
	}
}
