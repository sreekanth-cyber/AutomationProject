package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarBookingAsGuest {

	WebDriver driver;
	Properties prop;
	
	By Guest = By.xpath("//a[@id='guesttab']");
	By FirstName = By.xpath("//input[@placeholder='First Name']");
	By LastName = By.xpath("//input[@placeholder='Last Name']");
	By MobileNumber = By.xpath("//input[@placeholder='Contact Number']");
	By Email = By.xpath("//div[@class='col-md-5 col-xs-12']//input[@placeholder='Email']");
	By ConfirmEmail = By.xpath("//input[@placeholder='Confirm Email']");
	By Address = By.xpath("//input[@placeholder='Address']");
	By Country = By.xpath("//a[@class='select2-choice']");
	By Location = By.xpath("//div[contains(text(),'United Kingdom')]");
	By Extra_ChildSeat = By.xpath("//tr[1]//td[4]//label[1]//input[1]");
	By Extra_GPS = By.xpath("//tr[1]//td[4]//label[1]//span[1]//span[1]");
	By Cookie = By.cssSelector("button[id='cookyGotItBtn']");
	By ConfirmBook = By.xpath("//button[@name='guest']");
	
	public CarBookingAsGuest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void BookTheCar() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\sree\\MyProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		driver.findElement(Guest).click();
		//driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(FirstName).sendKeys(prop.getProperty("Guest_Fname"));
		driver.findElement(LastName).sendKeys(prop.getProperty("Guest_Lname"));
		driver.findElement(Email).sendKeys(prop.getProperty("Guest_Email"));
		driver.findElement(ConfirmEmail).sendKeys(prop.getProperty("Guest_ConfirmEmail"));
		driver.findElement(MobileNumber).sendKeys(prop.getProperty("Guest_Mobile_no"));
		driver.findElement(Address).sendKeys(prop.getProperty("Guest_Address"));
		driver.findElement(Country).click();
		driver.findElement(Location).click();
		//driver.findElement(Extra_ChildSeat).click();
		//driver.findElement(Extra_GPS).click();*/
		driver.findElement(ConfirmBook).click();
		
	}
}
