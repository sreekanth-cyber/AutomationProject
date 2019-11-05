package TestPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CarSearch;
import resources.base;

public class ValidateCarSearch extends base{

	@BeforeTest
	public void preConditions() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void CheckCarSearch() throws Exception
	{
		CarSearch c = new CarSearch(driver);
		c.Search();
		log.info("Successfully verified CarSearch Page");
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
