package Com.StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Com.CucumberRunner.EstyRunner;
import Com.Maven_Project.Base_All;
import Com.POM.SelectProduct;
import Com.PropertyFileReader.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EstyStepDefinition extends Base_All {
	
	public static WebDriver driver = EstyRunner.driver;
	SelectProduct sp = new SelectProduct(driver);
	
	
	@Given("user launch the application")
	public void user_launch_the_application() throws IOException {
		
		urlLaunch(new ConfigReader().getUrl());
		maximize();
	    waitImplicit(20);
	    screenShotMethod("HomePage");
	    
	    //Accept cookies
	    clickMethod( sp.getAccept());
	    
	}
	@When("user moves to Jewellery and Accessories")
	public void user_moves_to_jewellery_and_accessories() throws IOException {
		
		 actionMethods("movetoelement", sp.getJewellery());
		    screenShotMethod("Bag");
	    
	}
	@When("user moves to  Bags and Purses")
	public void user_moves_to_bags_and_purses() {
		 //select bags
	    clickMethod(sp.getBags());
	   
	}
	@When("user clicks Shoulder Bags")
	public void user_clicks_shoulder_bags() {
		//Select ShoulderBags
	    clickMethod(sp.getShoulderBags());
	    
	}
	@When("user clicks Minimalist")
	public void user_clicks_minimalist() throws IOException {
		//Select Minimalist
	    clickMethod(sp.getMinimalist());
	    screenShotMethod("ListBags");
	    
	    
	}
	@Then("user clicks Black Crossbody Linen bag")
	public void user_clicks_black_crossbody_linen_bag() {
		//Select the bag by name
	    clickMethod(sp.getBagName());
	    
	}


}
