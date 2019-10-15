package TestPackage;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LogOut;
import PageObjects.LoginUser;
import junit.framework.Assert;
import resources.base;

public class ValidateLoginPage extends base{

	By MyAccount = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')] ");
	By Login = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]");
	
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
		HomePage v = new HomePage(driver);
		LoginUser l = new LoginUser(driver);
		Assert.assertTrue(v.MyAccount().isDisplayed());
		driver.findElement(MyAccount).click();
		driver.findElement(Login).click();
		l.LoginPage();
		Thread.sleep(6000);
		LogOut lo = new LogOut(driver);
		lo.BackToHomePage();
		
		log1.info("Successfully verified Login Page");
	}
}
