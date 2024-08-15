package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\featureFiles\\flight.feature",
glue="stepDefinitions",monochrome=true,dryRun=false,tags="@Static_dropdown_Two",
plugin= {"html:target/cucumber.html","json:target/cucumber.json"})
class TestNgTestRunner extends AbstractTestNGCucumberTests{
}
