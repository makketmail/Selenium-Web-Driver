package WebDriverTest;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FireFoxTest {
	
  public WebDriver driver;
 
  @BeforeTest
  public void beforeTest()
  {
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://www.gmail.com");
	  driver.manage().window().maximize();

	
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

      Thread.sleep(5000);

      elem = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
      elem.click();
      elem.sendKeys("Hi Subin");
      
      WebElement elem1=null;
        
      elem1=driver.findElement(By.xpath("//div[class='T-I J-J5-Ji Bq nS T-I-KE L3']//div"));
    //  elem1= driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji Bq nS T-I-KE L3']>b"));
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
