package PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import resources.base;

public class LoginUser extends base{

	WebDriver driver;
	
	By Email = By.xpath("//input[@placeholder='Email']");
	By Password = By.xpath("//input[@placeholder='Password']");
	By Submit = By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']");
	By msg = By.xpath("//h3[@class='text-align-left']");
	
	public LoginUser(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void LoginPage() throws IOException
	{
		properties();
		
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		driver.findElement(Email).sendKeys(prop.getProperty("email"));
		driver.findElement(Password).sendKeys(prop.getProperty("password"));
		driver.findElement(Submit).click();
		Assert.assertEquals("Hi, "+prop.getProperty("Fname")+" "+prop.getProperty("Lname")+"",driver.findElement(msg).getText());
	}
}
