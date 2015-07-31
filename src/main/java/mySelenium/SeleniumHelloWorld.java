package mySelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumHelloWorld implements FireFoxWebDriver
{
	 public SeleniumHelloWorld()
	    {
	        // TODO Auto-generated constructor stub
	    }

	    @Test
	    public void testGoogleTitle() 
	    {
	        WebDriver driver = new FirefoxDriver();
	        driver.get("http://www.google.com");
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

	        driver.quit();

	    }
	
	
    public static void main(String[] args)
    {
    	SeleniumHelloWorld Sel=new SeleniumHelloWorld();
    	
    	Sel.testGoogleTitle();
  
 
    	
    
    
    }
}
