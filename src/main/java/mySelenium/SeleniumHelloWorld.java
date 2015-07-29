package mySelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumHelloWorld
{
    public static void main(String[] args)
    {
 
    	WebDriver driver = new FirefoxDriver();
    	//WebDriver driver=new ChromeDriver();

        // And now use this to visit Google
        driver.get("http://xtv.comcast.net/");


        WebElement element = driver.findElement(By.id("login-username"));
        element.sendKeys("phila23");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        
        
        WebElement passwordElem=driver.findElement(By.id("login-password"));
        passwordElem.sendKeys("BoatClay3");
        passwordElem.submit();

        WebElement signinElem=driver.findElement(By.className("x2-ftue-action-button x2-ftue-continue-button"));
        signinElem.click();
        
        driver.close();
        

    
    }
}
