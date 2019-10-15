package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.base;

public class HotelSearch extends base{
	
	Properties prop;
	WebDriver driver;
	
	By Hotel = By.xpath("//a[@title='Hotels']");
	By Name = By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']");
	By CheckIn = By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']");
	By ChechOut = By.xpath("//input[@placeholder='Check out']");
	By People = By.xpath("//input[@id='htravellersInput']");
	By AdultPlus = By.xpath("//button[@id='hadultPlusBtn']");
	By AdultMinus = By.xpath("//button[@id='hadultMinusBtn']");
	By ChildPlus = By.xpath("//button[@id='hchildPlusBtn']");
	By ChildMinus = By.xpath("//button[@id='hchildMinusBtn']");
	By Search = By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']");
	By Cookie = By.cssSelector("button[id='cookyGotItBtn']");

	public HotelSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Search() throws IOException, InterruptedException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\sree\\MyProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(Hotel).click();
		driver.findElement(Name).click();
		driver.findElement(Name).sendKeys("bang");
		driver.findElement(By.xpath("//div[contains(text(),'alore, India')]")).click();
		driver.findElement(CheckIn).click();
		
		while(!driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[2]")).getText().contains(prop.getProperty("Pick_up_month")))
		{
			driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[3]")).click();
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
				
		driver.findElement(ChechOut).click();
		
		int j=0;
		while(!driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText().contains(prop.getProperty("drop_up_month")))
		{
			driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[3]")).click();
			j++;
			if(j>5) break;
		}
		
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equals(prop.getProperty("drop_up_date")))
			{
				driver.findElements(By.className("day")).get(i).click();
			}
		}
		driver.findElement(People).click();
		driver.findElement(AdultPlus).click();
		driver.findElement(ChildPlus).click();
		driver.findElement(Search).click();
	}
	
}
