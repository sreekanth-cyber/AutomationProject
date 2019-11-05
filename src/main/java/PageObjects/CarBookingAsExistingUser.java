package PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import resources.base;

public class CarBookingAsExistingUser extends base{

	WebDriver driver;	
	public CarBookingAsExistingUser(WebDriver driver)
	{
		this.driver = driver;
	}

	By FirstName = By.xpath("//input[@placeholder='First Name']");
	By LastName = By.xpath("//input[@placeholder='Last Name']");
	By Email1 = By.xpath("//div[@class='col-md-6 col-12 o2']//input[@placeholder='Email']");
	By ConfirmEmail = By.xpath("//input[@placeholder='Confirm Email']");
	By SignIn = By.xpath("//a[@id='signintab']");
	By Email2 = By.xpath("//input[@id='username']");
	By Password = By.xpath("//input[@id='password']");
	By Extra_ChildSeat = By.xpath("//tr[2]//td[4]//label[1]");
	By Extra_GPS = By.xpath("//tr[3]//td[4]//label[1]");
	By ConfirmBook = By.xpath("//button[@name='guest']");
	
	public void BookTheCar() throws IOException
	{
		properties();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(FirstName).sendKeys(prop.getProperty("Fname"));
		driver.findElement(LastName).sendKeys(prop.getProperty("Lname"));
		driver.findElement(Email1).sendKeys(prop.getProperty("email"));
		driver.findElement(ConfirmEmail).sendKeys(prop.getProperty("email"));
		driver.findElement(SignIn).click();
		driver.findElement(Email2).sendKeys(prop.getProperty("email"));
		driver.findElement(Password).sendKeys(prop.getProperty("password"));
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(Extra_ChildSeat).click();
		driver.findElement(Extra_GPS).click();
		js.executeScript("window.scrollBy(0,500)");
		Assert.assertTrue(driver.findElement(ConfirmBook).isDisplayed());
		driver.findElement(ConfirmBook).click();
		
	}
}
