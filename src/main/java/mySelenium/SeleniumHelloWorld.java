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
    	driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    
    }
}
