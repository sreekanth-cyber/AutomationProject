package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut {

	WebDriver driver;
	
	By Account = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]");
	By LogOut = By.xpath("//li[@class='open']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Logout')]");
	By ReturnHome = By.xpath("//a[@class='navbar-brand go-right']//img");
	
	public LogOut(WebDriver driver)
	{
		this.driver = driver;
	}
	public void BackToHomePage()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(Account).click();
		driver.findElement(LogOut).click();
		driver.findElement(ReturnHome).click();
		
		driver.close();
	}
}
