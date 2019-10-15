package TestPackage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HotelSearch;
import resources.base;

public class ValidateHotelSearch extends base{

	@BeforeTest
	public void preConditions() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void CheckHotelSearch() throws Exception
	{
		HotelSearch h = new HotelSearch(driver);
		h.Search();
		
		log1.info("Successfully verified HotelSearch Page");
		driver.close();
	}
}
