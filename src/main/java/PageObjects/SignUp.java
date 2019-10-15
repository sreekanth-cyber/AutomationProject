package PageObjects;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {

	WebDriver driver;
	Properties prop;
	
	By FirstName = By.xpath("/html[1]/body[1]/div[6]/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[3]/input[1]");
	By LastName = By.xpath("/html[1]/body[1]/div[6]/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[4]/input[1]");
	By MobileNumber = By.xpath("/html[1]/body[1]/div[6]/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[5]/input[1]");
	By Email = By.xpath("/html[1]/body[1]/div[6]/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[6]/input[1]");
	By Password = By.xpath("//input[@placeholder='Password']");
	By ConfirmPassword = By.xpath("//input[@placeholder='Confirm Password']");
	By Cookie = By.cssSelector("button[id='cookyGotItBtn']");
	By btn = By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");
	
	
	public SignUp(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void RegistrationPage() throws Exception
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\sree\\MyProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		driver.findElement(FirstName).sendKeys(prop.getProperty("Fname"));
		driver.findElement(LastName).sendKeys(prop.getProperty("Lname"));
		driver.findElement(MobileNumber).sendKeys(prop.getProperty("mobile_no"));
		driver.findElement(Email).sendKeys(prop.getProperty("email"));
		driver.findElement(Password).sendKeys(prop.getProperty("password"));
		driver.findElement(ConfirmPassword).sendKeys(prop.getProperty("cnf_password"));
		driver.findElement(btn).click();
		
	}	
}
