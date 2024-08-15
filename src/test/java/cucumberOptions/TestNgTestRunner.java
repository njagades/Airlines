package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\featureFiles\\flight.feature",
glue="stepDefinitions",monochrome=true,dryRun=false,tags="@Auto_Suggestive or @Check_box ")
class TestNgTestRunner extends AbstractTestNGCucumberTests{
}