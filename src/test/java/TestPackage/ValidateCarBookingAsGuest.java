package TestPackage;

import java.io.IOException;

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
	public void BookAsGuest() throws IOException
	{
		CarSearch c = new CarSearch(driver);
		c.Search();
		CarBookingAsGuest guest = new CarBookingAsGuest(driver);
		guest.BookTheCar();
		
		log1.info("Successfully verified CarBookingAsGuest Page");
		driver.close();
	}
}
