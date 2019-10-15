package TestPackage;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LogOut;
import PageObjects.SignUp;

import junit.framework.Assert;
import resources.base;

public class ValidateSignUpPage extends base{

	By MyAccount = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')] ");
	By SignUp = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]");
	
	@BeforeTest
	public void preConditions() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void CheckSignUpPage() throws Exception
	{
		SignUp su = new SignUp(driver);
		HomePage v = new HomePage(driver);
		Assert.assertTrue(v.MyAccount().isDisplayed());
		driver.findElement(MyAccount).click();
		driver.findElement(SignUp).click();
		su.RegistrationPage();
		Thread.sleep(6000);
		LogOut l = new LogOut(driver);
		l.BackToHomePage();
		
		log1.info("Successfully verified SignUp Page");
		
		driver.close();
	}

}
