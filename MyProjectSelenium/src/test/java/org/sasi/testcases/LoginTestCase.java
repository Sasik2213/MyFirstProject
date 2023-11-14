package org.sasi.testcases;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sasi.testcases.base.Base;
import org.sasi.testcases.pages.HistoryPage;
import org.sasi.testcases.pages.LoginPage;
import org.sasi.testcases.pages.MakeAppointmentPage;
import org.sasi.testcases.pages.Profile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestCase extends Base {
	public LoginPage loginPage;
	public WebDriver driver;
	public MakeAppointmentPage appointmentPage;
	public HistoryPage historyPage;
	public Profile profile;
	public Properties prop;

	@BeforeMethod
	public void startProject() {
//	prop = new Properties();
	driver = implementPoject("chrome");
		
	}
	@AfterMethod
	public void endProject() {
		driver.close();
	}
	@Test
	public void performLogin() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.ToggleButton();
		loginPage.performLogin();
		loginPage.enterFormDetails("John Doe","ThisIsNotAPassword");
	}
	@Test
	public void makeAppointment() throws Exception {
		performLogin();
		appointmentPage = new MakeAppointmentPage(driver);
		appointmentPage.performFacility();
		appointmentPage.performCalender();
		appointmentPage.performTextArea("Testing!!");
		
	}
	@Test
	public void History() throws Exception {
		
		makeAppointment();
		historyPage = new HistoryPage(driver);
		historyPage.performHistory();
	}
	@Test
	public void profilePage() throws Exception {
		
		History();
		profile = new Profile(driver);
		profile.performHistoryToggle();
		profile.performProfile();
		profile.performLogout();
	}


}
