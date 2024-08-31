package stepDefinitions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.pageobjects.QAClickJetLandingPage;
import project.testComponents.TestContextSetup;

public class QAClickJet {

	public TestContextSetup testContextSetup;
	List<WebElement> country;
	String text;
	String selCur1;
	WebDriverWait wait;
	QAClickJetLandingPage landingpage;

	public QAClickJet(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingpage = testContextSetup.pageObjectManager.getQAClickJetLandingPage();
	}

	@Given("User is on the QAClickJet landing Page")
	public void user_is_on_the_qa_click_jet_landing_page() {
//    	URL already declared in global propertie file
	}

	@When("enter the country name partially<{string}>")
	public void enter_the_country_name_partially(String string) {
		country = landingpage.getCountryName(string);
	}

	@When("the user select the country name")
	public void the_user_select_the_country_name() {
		for (int i = 0; i < country.size(); i++) {
			String cou = country.get(i).getText();
			if (cou.equalsIgnoreCase("india")) {
				WebElement coun = country.get(i);
				text = coun.getText();
				coun.click();
				break;
			}
		}
	}

	@Then("the selected country should be displayed in the field.")
	public void the_selected_country_should_be_displayed_in_the_field() {
		landingpage.getSelectedCountryName();
	}

	@When("the user click the check box")
	public void the_user_click_the_check_box() {
		landingpage.getPress();
	}

	@Then("the UI should change accordingly.")
	public void the_ui_should_change_accordingly() {
		landingpage.getText();
	}

	@When("the user open currency dropdown and select the currency")
	public void the_user_open_currency_dropdown_and_select_the_currency() {
	   selCur1 = landingpage.getSelectDropDown();
	}

	@Then("the selected currency should be displayed in the currency filed<{string}>.")
	public void the_selected_currency_should_be_displayed_in_the_currency_filed(String selCur) {
		Assert.assertEquals(selCur, selCur1);
	}

	@When("the user open passengers dropdown and adds {int} adults")
	public void the_user_open_passengers_dropdown_and_adds_adults(Integer int1) {
		landingpage.getAdults(int1);
	}

	@When("the user clicks on the Done button")
	public void the_user_clicks_on_the_done_button() {
		landingpage.getbtnclosepaxoption();
	}

	@Then("the number of added adults should be displayed in the passengers filed.")
	public void the_number_of_added_adults_should_be_displayed_in_the_passengers_filed() {
		landingpage.divpaxinfo();
	}

	@When("click on date on date feild")
	public void click_on_date_on_date_feild() {
		//testContextSetup.driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
		landingpage.click_on_date_on_date_feild();
		//testContextSetup.genericUtils.waitForElementToAppear(//a[text()='16']);
		wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='16']")));
		testContextSetup.driver.findElement(By.xpath("//a[text()='16']")).click();
	}

	@Then("Date selected date will be displayed on date feild")
	public void date_selected_date_will_be_displayed_on_date_feild() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$mainContent$view_date1")));
		String selDate = testContextSetup.driver.findElement(By.name("ctl00$mainContent$view_date1")).getText();
		System.out.println(selDate);
	}

}
