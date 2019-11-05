package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import resources.base;

public class CarSearch extends base{
	WebDriver driver;
	
	By CarBtn = By.xpath("//a[contains(text(),'Transfer')]");
	By PickUp = By.xpath("//div[@id='carlocations_chosen']");
	By PickUpTime = By.xpath("//div[@id='transfer']//div[3]//div[1]//div[1]//div[2]//div[1]//div[2]");
	By DropTime = By.xpath("//div[@id='transfer']//div[4]//div[1]//div[1]//div[2]//div[1]//div[2]");
	By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By Submit = By.xpath("//div[@class='col-md-2 col-xs-12']//button[@class='btn-primary btn btn-block'][contains(text(),'Search')]");
	By Details = By.xpath("//a[@class='btn btn-primary btn-sm btn-wide']");
	By BookNow = By.xpath("//button[@class='btn btn-secondary btn-block mt-20']");
	
	public CarSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Search() throws Exception
	{
		properties();
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(CarBtn).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,50)");
		driver.findElement(PickUp).click();
		driver.findElement(By.xpath("//li[contains(text(),'Manchester')]")).click();
		
		driver.findElement(By.xpath("//input[@id='dropdate']")).click();
		while(!driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/nav[1]/div[2]")).getText().contains(prop.getProperty("Pick_up_month")))
		{
			driver.findElement(By.xpath("//div[@id='datepickers-container']//div[3]//nav[1]//div[3]")).click();
		}
		
		int count = driver.findElements(By.xpath("//div[@class='datepicker--cell datepicker--cell-day']")).size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath("//div[@class='datepicker--cell datepicker--cell-day']")).get(i).getText();
			if(text.equals(prop.getProperty("Pick_up_date")))
			{
				driver.findElements(By.xpath("//div[@class='datepicker--cell datepicker--cell-day']")).get(i).click();
				break;
			}
		}
		
		driver.findElement(PickUpTime).click();
		driver.findElement(By.xpath("//div[@id='transfer']//div[3]//div[1]//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys("09:00");
		driver.findElement(By.xpath("//div[@id='transfer']//div[3]//div[1]//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@id='returndate']")).click();
		
		while(!driver.findElement(By.xpath("//div[4]//nav[1]//div[2]")).getText().contains(prop.getProperty("drop_up_month")))
		{
			driver.findElement(By.xpath("//div[4]//nav[1]//div[3]")).click();
		}
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath("//div[@class='datepicker--cell datepicker--cell-day']")).get(i).getText();
			if(text.equals(prop.getProperty("drop_up_date")))
			{
				driver.findElements(By.xpath("//div[@class='datepicker--cell datepicker--cell-day']")).get(i).click();
				break;
			}
		}
	
		driver.findElement(DropTime).click();
		driver.findElement(By.xpath("//div[@id='transfer']//div[4]//div[1]//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys("18:00");
		driver.findElement(By.xpath("//div[@id='transfer']//div[4]//div[1]//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys(Keys.ENTER);
		
		Assert.assertTrue(driver.findElement(Submit).isDisplayed());
		driver.findElement(Submit).click();
		
		driver.findElement(Details).click();
		
		js.executeScript("window.scrollBy(0,1500)");
		Assert.assertTrue(driver.findElement(BookNow).isDisplayed());
		driver.findElement(BookNow).click();
		
	}
}
