package basicFunctions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;

public class Common
{
	public static WebDriver driver;
	//browser launch
	
	public void browser_launch(String browser)
	{
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\rakesh\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "D:\\rakesh\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	else if(browser.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver","D:\\rakesh\\drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	else
	{
		System.out.println("enter the browser ");
	}
	}

	
	// url
	
	public void url(String url_name)
	{
		driver.get(url_name);
	}
	
	// verify title
	
	public boolean verify_title(String title)
	{
		if(driver.getTitle().equals(title))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	// find element
	
	public WebElement findElement(String identifier,String Locator)
	{
		WebElement element = null;
		
		switch(identifier)
		{
		case "name":
			element=driver.findElement(By.name(Locator));
			break;
		case "id":
			element=driver.findElement(By.id(Locator));
			break;
		case "classname":
			element=driver.findElement(By.className(Locator));
			break;
		case "linktext":
			element=driver.findElement(By.linkText(Locator));
			break;
		case "partiallinktext":
			element=driver.findElement(By.partialLinkText(Locator));
			break;
		case "css":
			element=driver.findElement(By.cssSelector(Locator));
			break;
		case "tagname":
			element=driver.findElement(By.tagName(Locator));
			break;
		case "xpath":
			element=driver.findElement(By.xpath(Locator));
			break;
		default:
			System.out.println("enter identifier and locator");
			break;
			
		}
		return element;
		
	}
	
	
	//element presence
	
	public void element_presence(String identifier,String Locator)
	{
		WebElement element=findElement(identifier, Locator);
		
		if(element.isDisplayed())
		{
			assertTrue(true);
			
		}
		else
		{
			assertTrue(false);
			
			
		}
	}
	
	
	// sendkeys
	
	public void send_values(String identifier,String Locator,String text)
	{
		WebElement element=findElement(identifier, Locator);
		element.sendKeys(text);
	}
	
	// clear
	public void clear(String identifier,String Locator)
	{
		WebElement element=findElement(identifier, Locator);
		element.clear();
	}
	
	//click
	public void click(String identifier,String Locator)
	{
		WebElement element=findElement(identifier, Locator);
		element.click();
	}
	
	// verify text
	public boolean verify_text(String identifier,String Locator,String message)
	{
		WebElement element=findElement(identifier, Locator);
		String e=element.getText();
		if(e.equals(message))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	// close
	
	public void close()
	{
		driver.close();
	}
	
	
	//quit
	
	public void quit()
	{
		driver.quit();
	}
	
	
	
}
