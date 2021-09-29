package new_reusable;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Reusable {

    public static  WebDriver driver=null;

    
    //Browser launch
	public static void browserLaunch(Object[]input_parameter)
	{
		
		String browsername=(String) input_parameter[0];
		String webDriverExePath=(String) input_parameter[1];
     
		  if(browsername.equalsIgnoreCase("Chrome"))
		  {
		  System.setProperty("webdriver.chrome.driver", webDriverExePath);
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  
		  }
		  else if(browsername.equalsIgnoreCase("Firefox"))
		  {
			  System.setProperty("webdriver.gecko.driver", webDriverExePath);
			  driver=new FirefoxDriver();
			  driver.manage().window().maximize();
			  
			  }
		
	}
	
	// Open application
	
	public static void openApp(Object []input_parameter) throws InterruptedException 
	{
	
Thread.sleep(5000);
		String strURL=(String) input_parameter[0];
		driver.get(strURL);
	
		}
	
	public static Hashtable<String,Object> sendkeys(Object []input_parameter) throws InterruptedException
	{
		Thread.sleep(3000);
		String xpath=(String) input_parameter[0];
		String enter_text=(String) input_parameter[1];
		
		WebElement total=driver.findElement(By.xpath(xpath));
		total.clear();
		total.sendKeys(enter_text);
		Hashtable<String, Object> outputParameters = new Hashtable<String, Object>();
		
		  outputParameters.put("STATUS", "PASS");
		  	 outputParameters.put("MESSAGE", "Action:sendkeys,Input Given: " +input_parameter[0].toString() );
		  

		return outputParameters;
		
		
	}
	
	//Click
	public static void click(Object[]input_parameter)
	{
		 
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		String xpath=(String) input_parameter[0];
		
		WebElement total=driver.findElement(By.xpath(xpath));
		//total.clear();
		total.click();
		
		
	}
	
	public static void valid(Object[]input6)
	{
		
		
		try {
			String given=(String) input6[0];
			String data= (String) input6[1];
			   String Actual=driver.findElement(By.xpath(data)).getText();
				if(given.equals(Actual))
				{
					System.out.println("Test Case Is Pass");
					
				}
				else
				{
					
					System.out.println("Test Case Is Fail");
				}
			}
			catch(Exception e)
			{
				
				System.out.println("Test case is fail");
				
			}

		}


	
	
	public static void invalid(Object[]input1)
	{
		
		
		 String given1=(String)input1[0];
		 String data=(String) input1[1];
		 
		    String actual=driver.findElement(By.xpath(data)).getText();
		    if(given1.equals(actual))
		    {
		    	System.out.println("Test Case Is Pass");
		    }
		    else
		    {
		    	
		    	System.out.println("Test Case Is Fail");
		    }

			
	}
	

	// Dropdown 
	
	public static void dropDown(Object[]input_parameter)
	{
		
		String xpath=(String) input_parameter[0];
		String value=(String) input_parameter[1];
		Select s=new Select(driver.findElement(By.xpath(xpath)));
		s.selectByVisibleText(value);
		
	}
	
	public static void valid_reg()
	{
		
		String given="Thank you for registering";
		String actual="Email:";
		if(given.equals(actual))
		{
			System.out.println("Test case is Fail");
			
		}
		else
		{
			
			System.out.println("Test case is Pass");
		}
		
		
	}
	public static void close()
	{
		driver.close();
		driver.quit();
		
	}
	

	
}
