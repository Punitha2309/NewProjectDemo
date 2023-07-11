package Com.CucumberRunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Com.Maven_Project.Base_All;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src\\test\\java\\Com\\FeatureFile\\EstyTestCase.feature",

glue = "Com.StepDefinition")

public class EstyRunner extends Base_All {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void driverLaunch()
	{
		driver = browserLaunch("Chrome");
	}

}
