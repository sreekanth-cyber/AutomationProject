package TestPackage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LogOut;
import PageObjects.LoginUser;
import resources.base;

public class ValidateLoginPage extends base{

	By MyAccount = By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']");
	By Login = By.xpath("//a[@class='dropdown-item active tr']");
	
	
	@BeforeTest
	public void preConditions() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void CheckLoginPage() throws Exception
	{
		LoginUser l = new LoginUser(driver);
		driver.findElement(MyAccount).click();
		driver.findElement(Login).click();
		l.LoginPage();
		
		log.info("Successfully Logged in");
		Thread.sleep(3000);
		LogOut lo = new LogOut(driver);
		lo.BackToHomePage();
		log.info("Successfully verified LogOut Page");
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
