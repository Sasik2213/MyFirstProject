package org.sasi.testcases.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {

	public WebDriver driver;
	
	public Profile(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"menu-toggle\"]")
	private WebElement historyToggle;
	@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[4]/a")
	private WebElement profileBtn;
	
	public void performHistoryToggle() {
		historyToggle.click();
	}
	public void performProfile() {
		profileBtn.click();
	}
	@FindBy(xpath = "//*[@id=\"profile\"]/div/div/div/p[2]/a")
	private WebElement logOut;
	
	public void performLogout() {
		logOut.click();
	}
}
