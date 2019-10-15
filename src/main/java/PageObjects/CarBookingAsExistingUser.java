package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarBookingAsExistingUser {

	WebDriver driver;
	Properties prop;
	
	public CarBookingAsExistingUser(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By Cookie = By.cssSelector("button[id='cookyGotItBtn']");
	By SignIn = By.xpath("//a[@id='signintab']");
	By Email = By.xpath("//input[@id='username']");
	By Password = By.xpath("//input[@id='password']");
	By ConfirnBook = By.xpath("//button[@name='login']");
	
	public void BookTheCar() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\sree\\MyProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(SignIn).click();
		driver.findElement(Email).sendKeys(prop.getProperty("email"));
		driver.findElement(Password).sendKeys(prop.getProperty("password"));
		driver.findElement(ConfirnBook).click();
		
	}
}
