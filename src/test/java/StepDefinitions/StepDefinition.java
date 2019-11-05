package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import resources.base;

import org.junit.runner.RunWith;

import PageObjects.CarBookingAsGuest;
import PageObjects.CarSearch;

@RunWith(Cucumber.class)
public class StepDefinition extends base{

	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
    }

	 @And("^Navigate to \"([^\"]*)\" site$")
	    public void navigate_to_something_site(String strArg1) throws Throwable {
		 driver.get(strArg1);
		 driver.manage().window().maximize();
	    }
	 
    @When("^Search for the car$")
    public void search_for_the_car() throws Throwable {
    	CarSearch c = new CarSearch(driver);
    	c.Search();
    }

    @Then("^Book the car as per requirements$")
    public void book_the_car_as_per_requirements() throws Throwable {
    	CarBookingAsGuest cb = new CarBookingAsGuest(driver);
    	cb.BookTheCar();
    }

}