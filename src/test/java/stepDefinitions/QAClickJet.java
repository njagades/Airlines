package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class QAClickJet {
    WebDriver driver;
    List<WebElement> country;
    String text;
    String selCur;
    WebDriverWait wait;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

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
		for (int i = 0; i < country.size(); i++) {
			String cou = country.get(i).getText();
			if (cou.equalsIgnoreCase("india")) {
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



    @When("the user click the check box")
    public void the_user_click_the_check_box() {
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']"));
        checkBox.click();
    }

    @Then("the UI should change accordingly.")
    public void the_ui_should_change_accordingly() {
        WebElement label = driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_1']"));
        String actualText = label.getText();
        String expectedText = "Round Trip";
        Assert.assertEquals(actualText, expectedText, "The label text is not as expected.");
    }
    @When("the user open currency dropdown and select the currency")
	public void the_user_open_currency_dropdown_and_select_the_currency() {
		WebElement dropDown = driver
				.findElement(By.xpath("(//select[@id='ctl00_mainContent_DropDownListCurrency'])[1]"));
		Select currency = new Select(dropDown);
		currency.selectByValue("INR");
		selCur = currency.getFirstSelectedOption().getText();

	}

	@Then("the selected currency should be displayed in the currency filed.")
	public void the_selected_currency_should_be_displayed_in_the_currency_filed() {
		Assert.assertEquals(selCur, "INR");
	}

	@When("the user open passengers dropdown and adds {int} adults")
	public void the_user_open_passengers_dropdown_and_adds_adults(Integer int1) {
		driver.findElement(By.xpath("(//div[@id='divpaxinfo'])[1]")).click();
		int i = 2;
		while (i > 0) {
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
			i--;
		}

	}

	@When("the user clicks on the Done button")
	public void the_user_clicks_on_the_done_button() {
		driver.findElement(By.id("btnclosepaxoption")).click();
	}

	@Then("the number of added adults should be displayed in the passengers filed.")
	public void the_number_of_added_adults_should_be_displayed_in_the_passengers_filed() {
		String  adultinfo = driver.findElement(By.xpath("(//div[@id='divpaxinfo'])[1]")).getText();
		Assert.assertEquals(adultinfo, "3 Adult");
	}
	
	@When("click on date on date feild")
	public void click_on_date_on_date_feild() {
	 driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
	wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='16']")));
	 driver.findElement(By.xpath("//a[text()='16']")).click();
	}
	@Then("Date selected date will be displayed on date feild")
	public void date_selected_date_will_be_displayed_on_date_feild() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$mainContent$view_date1")));
		String selDate = driver.findElement(By.name("ctl00$mainContent$view_date1")).getText();
		System.out.println(selDate);
		
	}

}

   
	




