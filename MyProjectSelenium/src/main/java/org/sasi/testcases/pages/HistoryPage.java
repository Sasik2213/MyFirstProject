package org.sasi.testcases.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {

	public WebDriver driver;
	
	public HistoryPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"menu-toggle\"]")
	private WebElement appointmentToggle;
	@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")
	private WebElement historyBtn;
	
	public void performHistory() {
		appointmentToggle.click();
		historyBtn.click();
	}
}
