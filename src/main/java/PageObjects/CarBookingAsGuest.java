package PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import resources.base;

public class CarBookingAsGuest extends base{

	WebDriver driver;
	
	By Guest = By.xpath("//a[@id='guesttab']");
	By FirstName = By.xpath("//input[@placeholder='First Name']");
	By LastName = By.xpath("//input[@placeholder='Last Name']");
	By MobileNumber = By.xpath("//input[@placeholder='Contact Number']");
	By Email = By.xpath("//div[@class='col-md-6 col-12 o2']//input[@placeholder='Email']");
	By ConfirmEmail = By.xpath("//input[@placeholder='Confirm Email']");
	By Address = By.xpath("//input[@placeholder='Address']");
	By Country = By.xpath("//div[@class='chosen-container chosen-container-single']");
	By Extra_ChildSeat = By.xpath("//tr[2]//td[4]//label[1]");
	By Extra_GPS = By.xpath("//tr[3]//td[4]//label[1]");
	By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By ConfirmBook = By.xpath("//button[@name='guest']");
	
	public CarBookingAsGuest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void BookTheCar() throws IOException
	{
		properties();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(Guest).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(FirstName).sendKeys(prop.getProperty("Guest_Fname"));
		driver.findElement(LastName).sendKeys(prop.getProperty("Guest_Lname"));
		driver.findElement(Email).sendKeys(prop.getProperty("Guest_Email"));
		driver.findElement(ConfirmEmail).sendKeys(prop.getProperty("Guest_ConfirmEmail"));
		driver.findElement(MobileNumber).sendKeys(prop.getProperty("Guest_Mobile_no"));
		driver.findElement(Address).sendKeys(prop.getProperty("Guest_Address"));
		driver.findElement(Country).click();
		driver.findElement(By.xpath("//input[@class='chosen-search-input']")).sendKeys("United Kingdom");
		driver.findElement(By.xpath("//input[@class='chosen-search-input']")).sendKeys(Keys.ENTER);
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(Extra_ChildSeat).click();
		driver.findElement(Extra_GPS).click();	
		js.executeScript("window.scrollBy(0,600)");
		Assert.assertTrue(driver.findElement(ConfirmBook).isDisplayed());
		driver.findElement(ConfirmBook).click();
	}
}
