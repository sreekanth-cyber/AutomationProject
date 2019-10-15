package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
public WebDriver driver;
	
	By MyAccount = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')] ");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement MyAccount() 
	{
		return driver.findElement(MyAccount);
	}
}
