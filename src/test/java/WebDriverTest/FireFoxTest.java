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
	  driver.get("http://www.google.com");
	
  }
	
  @Test
  public void testGoogleTitle() throws Exception
  {
      WebElement element = driver.findElement(By.name("q"));
      element.sendKeys("Cheese!");
      element.submit();
      System.out.println("Page title is: " + driver.getTitle());

      String expected = "Google";
      String actual = driver.getTitle();
      Assert.assertEquals(actual, expected);

      (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>()
      {
          public Boolean apply(WebDriver d)
          {
              return d.getTitle().toLowerCase().startsWith("cheese!");
          }
      });

      System.out.println("Page title is: " + driver.getTitle());

      expected = "Cheese! - Google Search";
      actual = driver.getTitle();
      Assert.assertEquals(actual, expected);


  }

  
  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

 
}
