package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QAClickJet {
    WebDriver driver= new ChromeDriver();
    List<WebElement> country;
    Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    String text;
    String selCur;
	@Given("User is on the QAClickJet landing Page")
	public void user_is_on_the_qa_click_jet_landing_page() {		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	@When("enter the country name partially<{string}>")
	public void enter_the_country_name_partially(String string) {
    driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys(string);
    country = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	}
	
	@When("the user select the country name")
	public void the_user_select_the_country_name() {
	for(int i=0; i<country.size();i++) {
		String cou = country.get(i).getText();
		if(cou.equalsIgnoreCase("india")) {
		WebElement coun = country.get(i);
		coun.click();
		text = coun.getText();
		break;
		}
	}
	}
	
	@Then("the selected country should be displayed in the field.")
	public void the_selected_country_should_be_displayed_in_the_field() {
	String selectedCountryName = driver.findElement(By.xpath("//input[@id='autosuggest']")).getText();
	Assert.assertEquals(selectedCountryName, text);
	}
	
	
	@When("the user click  the check box")
	public void the_user_click_the_check_box() {
	    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
	}
	@Then("the UI should change accordingly.")
	public void the_ui_should_change_accordingly() {
		String text2 = driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_1']")).getText();
		System.out.println(text2);
	Assert.assertEquals(text2, "Round Trip");
	}
	
	@When("the user open currency dropdown and select the currency")
	public void the_user_open_currency_dropdown_and_select_the_currency() {
WebElement dropDown = driver.findElement(By.xpath("(//select[@id='ctl00_mainContent_DropDownListCurrency'])[1]"));
Select currency=new Select(dropDown);
currency.selectByValue("INR");
selCur = currency.getFirstSelectedOption().getText();

	}
	@Then("the selected currency should be displayed in the currency filed.")
	public void the_selected_currency_should_be_displayed_in_the_currency_filed() {
	    Assert.assertEquals(selCur, "INR");
	}
	
	
}
