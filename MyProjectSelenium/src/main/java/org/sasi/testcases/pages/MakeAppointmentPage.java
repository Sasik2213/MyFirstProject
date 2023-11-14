package org.sasi.testcases.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MakeAppointmentPage {

	public WebDriver driver;
	public MakeAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id=\"combo_facility\"]")
	private WebElement facilitySelect;
	
	public void performFacility() {
		Select select = new Select(facilitySelect);
		select.selectByIndex(1);
		checkBox.click();
		healthCareProgram.click();
	}
	@FindBy(xpath = "//input[@id=\"chk_hospotal_readmission\"]")
	private WebElement checkBox;
	@FindBy(xpath = "//input[@id=\"radio_program_medicaid\"]")
	private WebElement healthCareProgram;
	
	@FindBy(xpath = "//span[@class=\"glyphicon glyphicon-calendar\"]")
	private WebElement calenderPerform;
	@FindBy(xpath = "//td[@class=\"day\"][normalize-space()=\"1\"]")
	private WebElement selectedDate;
	@FindBy(xpath = "//textarea[@id=\"txt_comment\"]")
	private WebElement textArea;
	@FindBy(xpath = "//button[@id=\"btn-book-appointment\"]")
	private WebElement Submit;
	public void performCalender() {
		calenderPerform.click();
		selectedDate.click();
	}
	public void performTextArea(String text) {
		textArea.sendKeys(text);
		Submit.click();
	}
	
	
	
	
	
}
