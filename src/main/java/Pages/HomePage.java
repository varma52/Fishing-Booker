package Pages;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.GenericMethods;

public class HomePage extends GenericMethods {
	
	
	
	public By loginbtn=By.xpath("//span[contains(text(),'Log in')]");
	
	public By loginclose=By.xpath("//button[@class='close']");
	
	public By destinationsearch=By.xpath("//input[@id='search-form-input']");
	
	public By searchClear=By.xpath("(//div[@id=\"remove-icon-wrapper\"])[1]//i");

    public By firstSearchEle=By.xpath("//div[contains(@class,'dataset-omnisearch')]/div[1]");
	
	public By SearchMultiple=By.xpath("//div[contains(@class,'dataset-omnisearch')]/div");
	
	public By dateicon=By.xpath("//input[@id='search_booking_date']");

	public By monthndyear=By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]/th[2]");
	
	public By nextBtn=By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]/th[3]");
	
	public By dates=By.xpath("//div[@class='datepicker-days']/table//tbody/tr/td");
	
	public By submit=By.xpath("(//input[@value='Check availability'])[2]");
	
	public By pricesort=By.xpath("//a[@id='price_asc']");
	

	
	public void loginbtn() {

		clickElement(loginbtn);
		clickElement(loginclose);
		screenshot("sample");
			
	}
	
	public void searchTest() {
		
        sendkeys(destinationsearch, "panama");
		delay(2);
		explicitWaitClick(firstSearchEle);
		datePicker("october 2023","15",dateicon,monthndyear,nextBtn,dates);
		clickElement(submit);
		DisplayElementAssert(pricesort);   


	}
	
}
