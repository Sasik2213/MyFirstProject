package org.sasi.testcases.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@id=\"menu-toggle\"]")
	private WebElement ToggleBtn;
	
	public void ToggleButton() {
		ToggleBtn.click();
	}
	
	@FindBy(xpath ="//a[normalize-space()=\"Login\"]")
	private WebElement Login;
	
	public void performLogin() {
		Login.click();
	}
	@FindBy(xpath = "//input[@id=\"txt-username\"]")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id=\"txt-password\"]")
	private WebElement userPasscode;
	
	@FindBy(xpath = "//button[@id=\"btn-login\"]")
	private WebElement submitBtn;
	
	public void enterFormDetails(String uname,String passcode) {
		userName.sendKeys(uname);
		userPasscode.sendKeys(passcode);
		submitBtn.click();
	}
	
	
}
