package TestPackage;

import org.testng.annotations.AfterTest;
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
	public void BookAsExistingUser() throws Exception
	{
		CarSearch c = new CarSearch(driver);
		c.Search();
		log.info("Successfully verified CarSearch Page");
		CarBookingAsExistingUser user = new CarBookingAsExistingUser(driver);
		user.BookTheCar();
		log.info("Successfully verified CarBookingAsExistingUser Page");
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
