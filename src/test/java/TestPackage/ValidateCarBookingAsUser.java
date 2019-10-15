package TestPackage;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CarBookingAsExistingUser;
import PageObjects.CarSearch;
import resources.base;

public class ValidateCarBookingAsUser extends base{

	@BeforeTest
	public void preConditions() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void BookAsExistingUser() throws IOException
	{
		CarSearch c = new CarSearch(driver);
		c.Search();
		CarBookingAsExistingUser user = new CarBookingAsExistingUser(driver);
		user.BookTheCar();
		
		log1.info("Successfully verified CarBookingAsExistingUser Page");
		driver.close();
	}
}
