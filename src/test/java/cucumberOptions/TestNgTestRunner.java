package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\featureFiles\\flight.feature",
glue="stepDefinitions",monochrome=true,dryRun=false,tags="@Check_box or @Auto_Suggestive or @Static_dropdown",
plugin= {"html:target/cucumber.html","json:target/cucumber.json"})
class TestNgTestRunner extends AbstractTestNGCucumberTests{
}
