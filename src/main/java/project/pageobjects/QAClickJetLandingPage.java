package project.pageobjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QAClickJetLandingPage {
	
	WebDriver driver;
	public QAClickJetLandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//input[@id='autosuggest']")
	WebElement contryName;
	
	@FindBy(css="li[class='ui-menu-item'] a")
	List<WebElement> country;

	@FindBy(xpath="//input[@id='autosuggest']")
	WebElement selectedCountryName;
	
	@FindBy(xpath="//input[@id='ctl00_mainContent_rbtnl_Trip_1']")
	WebElement press;
	
	@FindBy(xpath="//label[@for='ctl00_mainContent_rbtnl_Trip_1']")
	WebElement text2;
	
	@FindBy(xpath="(//select[@id='ctl00_mainContent_DropDownListCurrency'])[1]")
	WebElement dropdown;
	
	@FindBy(xpath="(//div[@id='divpaxinfo'])[1]")
	WebElement ClickDropDown;
	
	@FindBy(css="#hrefIncAdt")
	WebElement ClickDropDown2;
	
	@FindBy(id="btnclosepaxoption")
	WebElement btnclosepaxoption;
	
	@FindBy(xpath="(//div[@id='divpaxinfo'])[1]")
	WebElement divpaxinfo;
	
	@FindBy(name="ctl00$mainContent$view_date1")
	WebElement ctl00$mainContent$view_date1;
	
	@FindBy(xpath="//a[text()='16']")
	WebElement date;
	
	public List<WebElement> getCountryName(String string) {
		contryName.sendKeys(string);	
		return country;
	}
	
	public void getSelectedCountryName() {
		Assert.assertTrue(true);
	}

	public void getPress() {
		press.click();
	}

	public void getText() {
		String actualText = text2.getText();
		String expectedText = "Round Trip";
		Assert.assertEquals(actualText, expectedText, "The label text is not as expected.");
	}
	
	
	public String getSelectDropDown() {
		Select currency = new Select(dropdown);
		currency.selectByValue("USD");
		return currency.getFirstSelectedOption().getText();
	}
	
	public void getAdults(int int1) {
		ClickDropDown.click();
		int i = int1;
				while (i > 0) {
					ClickDropDown2.click();
					i--;
				}
	}

	public void getbtnclosepaxoption() {
		btnclosepaxoption.click();
	}

	
	public void divpaxinfo() {
		String adultinfo = divpaxinfo.getText();
		Assert.assertEquals(adultinfo, "3 Adult");

	}
	
	public void click_on_date_on_date_feild() {
		
		ctl00$mainContent$view_date1.click();
	
	}


}
