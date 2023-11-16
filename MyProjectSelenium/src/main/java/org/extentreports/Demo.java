package org.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		ExtentReports extentReports = new ExtentReports();
		File fs = new File(System.getProperty("user.dir")+"\\sasi\\sasi.html");
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fs);
		extentReports.attachReporter(extentSparkReporter);
		extentSparkReporter.config().setReportName("Testing");
		extentSparkReporter.config().setDocumentTitle("Testing One");
		ExtentTest test = extentReports.createTest("One").createNode("First Case Scenario").log(Status.PASS,"Pass");
		ExtentTest test1 = extentReports.createTest("Two").createNode("Second Scenario").log(Status.FAIL, "Failure");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationSrc = new File(System.getProperty("user.dir")+"\\destination\\destination_one.png");
		try {
			FileUtils.copyFile(srcFile, destinationSrc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(destinationSrc.getAbsolutePath(),"First Test Case").assignAuthor("Sasik")
		.assignCategory("testing").assignDevice("Laptop").fail("TryAgain");
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(fs.toURI());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
