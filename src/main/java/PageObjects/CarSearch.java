package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarSearch {
	WebDriver driver;
	Properties prop;
	
	By BookNow = By.xpath("//button[@class='btn btn-block btn-action btn-lg']");
	By Details = By.xpath("//button[@class='btn btn-action loader loader btn-block br25']");
	By CarBtn = By.xpath("//a[@title='Cars']");
	By PickUp = By.xpath("//div[@id='s2id_carlocations']//a[@class='select2-choice']");
	By location = By.xpath("//div[contains(text(),'Manchester')]");
	By Cookie = By.cssSelector("button[id='cookyGotItBtn']");
	By Submit = By.xpath("//div[@class='bgfade col-md-2 form-group go-right col-xs-12 search-button']//button[@class='btn-primary btn btn-lg btn-block pfb0 loader'][contains(text(),'Search')]");
	
	public CarSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Search() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\sree\\MyProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
				
		driver.findElement(CarBtn).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(PickUp).click();
		driver.findElement(location).click();
		driver.findElement(By.xpath("//input[@id='departcar']")).click();
		
		while(!driver.findElement(By.xpath("//div[12]//div[1]//tr[1]//th[2]")).getText().contains(prop.getProperty("Pick_up_month")))
		{
			driver.findElement(By.xpath("//div[12]//div[1]//tr[1]//th[3]")).click();
		}
		
		int count = driver.findElements(By.className("day")).size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equals(prop.getProperty("Pick_up_date")))
			{
				driver.findElements(By.className("day")).get(i).click();
			}
		}
		
		driver.findElement(By.name("pickupTime")).click();
		
		Select drpdwn1 = new Select(driver.findElement(By.name("pickupTime")));
		drpdwn1.selectByVisibleText("09:00");
		
		driver.findElement(By.xpath("//input[@id='returncar']")).click();
		int j=0;
		while(!driver.findElement(By.xpath("//div[13]//div[1]//tr[1]//th[2]")).getText().contains(prop.getProperty("drop_up_month")))
		{
			driver.findElement(By.xpath("//div[13]//div[1]//tr[1]//th[3]")).click();
			j++;
			if(j>5) break;
		}
		while(!driver.findElement(By.xpath("//div[13]//div[1]//tr[1]//th[2]")).getText().contains("drop_up_month"))
		{
			driver.findElement(By.xpath("//div[13]//div[1]//tr[1]//th[1]")).click();
		}
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equals(prop.getProperty("drop_up_date")))
			{
				driver.findElements(By.className("day")).get(i).click();
			}
		}
		
		driver.findElement(By.name("dropoffTime")).click();
		
		Select drpdwn2 = new Select(driver.findElement(By.name("dropoffTime")));
		drpdwn2.selectByVisibleText("18:00");
		
		driver.findElement(Submit).click();
		
		driver.findElement(Details).click();

		driver.findElement(Cookie).click();
		driver.findElement(BookNow).click();
		
	}
}
