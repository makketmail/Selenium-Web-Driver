package WebDriverTest;

import org.testng.annotations.Test;


import com.thoughtworks.selenium.ScreenshotListener;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;*/
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;

public class FireFoxTest {
	
  public WebDriver driver;
  public ScreenshotListener screenshotHelper;
 
  @BeforeTest
  public void beforeTest() throws IOException
  {
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://www.gmail.com");
	  driver.manage().window().maximize();
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrFile, new File("C:\\Users\\AnupamaB\\gmail_launch.jpg"));

	
  }
	
  @Test
  public void testGmailSignin() throws Exception
  {
	  WebElement elem=null;
	  driver.findElement(By.id("Email")).sendKeys("makketmail");
	  driver.findElement(By.id("next")).click();

	  driver.findElement(By.id("Passwd")).sendKeys("123abcdD");
	
	  driver.findElement(By.id("signIn")).click();
      
      System.out.println("Page title is: " + driver.getTitle());
      
      
      driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();

      Thread.sleep(5000);
      driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("subin.s.sugunan@gmail.com;makketmail@gmail.com");

      driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Mail using Selenium");
      File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrFile2, new File("C:\\Users\\AnupamaB\\gmail_compose.jpg"));
      
      Thread.sleep(5000);

      elem = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
      elem.click();
      elem.sendKeys("Hi Subin");
      
      WebElement elem1=null;
        
      elem1=driver.findElement(By.xpath("//div[class='T-I J-J5-Ji Bq nS T-I-KE L3']//div"));
      elem1.click();
   
      Thread.sleep(3000);
/*
      String expected = "Gmail";
      String actual = driver.getTitle();
      Assert.assertEquals(actual, expected);

      (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>()
      {
          public Boolean apply(WebDriver d)
          {
              return d.getTitle().toLowerCase().startsWith("java");
          }
      });*/

      System.out.println("Page title is: " + driver.getTitle());
  }

  
  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

 
}
