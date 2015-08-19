package WebDriverTest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
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
	  public boolean checkElementPresent(String xpath)
	  {
		  try 
		  {
			  System.out.println("checking elem presence");
			  driver.findElement(By.id(xpath)).isDisplayed();
		  }
		  catch (NoSuchElementException e)
		  {
			  System.out.println("catch");
		        return false;
		  }
		  return true;
		  
	  }
	 
	  @Test
	  public void xtvPortalLogin() throws Exception
	  {
		 
		  driver.findElement(By.id("login-username")).sendKeys("phila15");
		  driver.findElement(By.id("login-password")).sendKeys("CakeCard7");
		  driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		  driver.findElement(By.xpath("//a[contains(.,'Yes')]")).click();
		  driver.findElement(By.xpath("//label[contains(.,'Enter a name')]")).sendKeys("FreedomWest");
		  driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
          Thread.sleep(10000);
          WebElement guideMenu = driver.findElement(By.xpath("//div[@id='x2-header-container']/div/nav/ol/li[1]/a"));
          guideMenu.click();
          guideMenu.findElement(By.xpath("id('primary_nav-1-menuitem-0-0')")).click();
          WebElement programCells=driver.findElement(By.xpath("//div[@id='content']/div/ol/li[7]/ol/li[1]/div/a"));
          programCells.click();
          driver.findElement(By.xpath("//div[@id='content']/div/ol/li[7]/div/div/div/div[2]/ol/li[2]/a")).click();
          WebElement elem=driver.findElement(By.xpath("//div[@id='modal']/div/div/div/div/ol/li/a"));
         
          if(elem.isDisplayed()==true)   
          {
        	  elem.click();
        	  
          }
          driver.findElement(By.xpath("//div[@id='modal']/div/div/div/ol/li/a")).click();
           
          WebElement savedMenu = driver.findElement(By.xpath("//div[@id='x2-header-container']/div/nav/ol/li[2]/a"));
          savedMenu.click();
          savedMenu.findElement(By.xpath("id('primary_nav-1-menuitem-1-1')")).click();
          WebElement recTab =  driver.findElement(By.xpath("//div[@id='content']/div/ol/li[1]"));
          recTab.click();
          List<WebElement> recordingsCount=driver.findElements(By.xpath("//div[@id='content']/div/ol/li"));
          for(int i=1;i<recordingsCount.size();i++)
          {
        	 
        	  String Xpath="//div[@id='content']/div/ol/li["+i+"]/div/div/div[2]/p";
        	//  driver.findElement(By.xpath("//div[@id='content']/div/ol/li["+i+"]/div/div/div[2]/p"));
        	  boolean elemPresent=checkElementPresent(Xpath);
        	  if(elemPresent ==true)
        	  {
        		  System.out.println("Inprogress recording");
        	  }
        	  else
        	  {
        		  System.out.println("Completed recording");
        	  }
          }
          Iterator<WebElement> recordingIter=recordingsCount.iterator();
          while(recordingIter.hasNext())
          {
        	  WebElement rec=recordingIter.next();
        	  System.out.println(rec.getText());
          }
          
         /* WebElement inProRec=driver.findElement(By.xpath("//div[@id='content']/div/ol/li[1]/div/div/div[2]/p"));
          if(inProRec.isDisplayed()==true)
          {
        	  
          }*/
          ///html/body/section[1]/div[1]/div/ol/li[1]/div/div/div[2]/p
         
          
//id('primary_nav-1-menuitem-1-1')
         /*  Iterator<WebElement> iter = anchors.iterator();
		//  outerloop:
		  while(iter.hasNext()) 
		  {
		     WebElement we = iter.next();
		     System.out.println(we.getText());
		   }
		  need to modify the code
		  List<WebElement> channelList = driver.findElements(By.xpath("//div[@id='content']/div/ol/li/h3/a/span"));
		  System.out.println(channelList.size());
		  List <List<WebElement>> programListList=new ArrayList<List<WebElement>> ();
		  
		  List<WebElement> programList =null;
		  
		 for(int i=1;i<5;i++)
		 {
			 programList= driver.findElements(By.xpath("//div[@id='content']/div/ol/li["+i+"]/ol/li[1]/div/a"));
		     
		 }
		 for(int i=0;i<programListList.size();i++)
		 {
			 System.out.println(programListList.get(i));
			 
		 }
		  
		  */
		  
		  
		  //programList= driver.findElements(By.xpath("//div[@id='x2-header-container']/div/nav/ol/li/a/div/ol/li/a"));
		//  driver.findElement(By.xpath("//div[@id='content']/div/ol/li[1]/ol/li[1]/div/a")).click();
	  }
	  
	  @AfterTest
	  public void afterMethod()
	  {
		
	  }
	  
	


}
