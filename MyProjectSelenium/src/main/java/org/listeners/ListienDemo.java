package org.listeners;

import java.awt.Desktop;
import java.net.URI;

import org.base.classes.test.Base_One;
import org.extentreports.DemoExp;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListienDemo extends Base_One  implements ITestListener {

	ExtentReports extentReports = DemoExp.getExtentReports();
	public ExtentTest test1;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
		String name = result.getMethod().getMethodName();
		test1 = extentReports.createTest(name);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
		String name = result.getMethod().getMethodName();
		test1.generateLog(Status.PASS, name+" test Passed!!!");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result);
		String name = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String testingPic = snapShotMaker(name, driver);
		test1.addScreenCaptureFromPath(testingPic,"First Time Capture Error Pics"+name);
		test1.log(Status.FAIL, result.getThrowable());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		extentReports.flush();
		
	}
	
	

}
