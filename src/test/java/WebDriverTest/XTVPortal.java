package WebDriverTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.ScreenshotListener;

public class XTVPortal 
{
	public WebDriver driver;
	  public ScreenshotListener screenshotHelper;
	 
	  @BeforeTest
	  public void beforeTest() throws IOException
	  {
		  driver=new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://xtv.comcast.net/");
		  driver.manage().window().maximize();
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile, new File("C:\\Users\\AnupamaB\\xtvportal_launch.jpg"));

	  }
		
	  @Test
	  public void xtvPortalLogin() throws Exception
	  {
		 
		  driver.findElement(By.id("login-username")).sendKeys("phila23");
		  driver.findElement(By.id("login-password")).sendKeys("BoatClay3");
		  driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		  driver.findElement(By.xpath("//a[contains(.,'Yes')]")).click();
		  driver.findElement(By.xpath("//label[contains(.,'Enter a name')]")).sendKeys("FreedomWest");
		  driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		  driver.findElement(By.xpath("//a[contains(text(),'Guide')]")).findElement(By.xpath("//a[contains(text(),'TV Listing')]")).click();
	  }

	  
	  @AfterMethod
	  public void afterMethod()
	  {
		
	  }


}
