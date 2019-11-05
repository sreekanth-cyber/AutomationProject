package TestPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CarBookingAsGuest;
import PageObjects.CarSearch;
import resources.base;

public class ValidateCarBookingAsGuest extends base{

	@BeforeTest
	public void preConditions() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void BookAsGuest() throws Exception
	{
		CarSearch c = new CarSearch(driver);
		c.Search();
		log.info("Successfully verified CarSearch Page");
		CarBookingAsGuest guest = new CarBookingAsGuest(driver);
		guest.BookTheCar();
		log.info("Successfully verified CarBookingAsGuest Page");
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
