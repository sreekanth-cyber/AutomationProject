package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import resources.base;

public class SignUp extends base{

	WebDriver driver;
	
	By FirstName = By.xpath("//input[@placeholder='First Name']");
	By LastName = By.xpath("//input[@placeholder='Last Name']");
	By MobileNumber = By.xpath("//input[@placeholder='Mobile Number']");
	By Email = By.xpath("//input[@placeholder='Email']");
	By Password = By.xpath("//input[@placeholder='Password']");
	By ConfirmPassword = By.xpath("//input[@placeholder='Confirm Password']");
	By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By btn = By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']");
	By msg = By.xpath("//h3[@class='text-align-left']");
	
	public SignUp(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void RegistrationPage() throws Exception
	{
		properties();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		driver.findElement(FirstName).sendKeys(prop.getProperty("Fname"));
		driver.findElement(LastName).sendKeys(prop.getProperty("Lname"));
		driver.findElement(MobileNumber).sendKeys(prop.getProperty("mobile_no"));
		driver.findElement(Email).sendKeys(prop.getProperty("email"));
		driver.findElement(Password).sendKeys(prop.getProperty("password"));
		driver.findElement(ConfirmPassword).sendKeys(prop.getProperty("cnf_password"));
		
		js.executeScript("window.scrollBy(0,100)");
		driver.findElement(btn).click();
		Assert.assertEquals("Hi, "+prop.getProperty("Fname")+" "+prop.getProperty("Lname")+"",driver.findElement(msg).getText());
	}	
}
