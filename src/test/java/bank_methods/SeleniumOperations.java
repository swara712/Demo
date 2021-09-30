package bank_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumOperations 
{
    public static  WebDriver driver=null;
	//private static String[] input_parameter;
    
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
	
	public static void openApp(Object []input_parameter)
	{
		String strURL=(String) input_parameter[0];
		driver.get(strURL);
		
		}
	
	public static void sendkeys(Object []input_parameter)
	{
		
		String xpath=(String) input_parameter[0];
		String enter_text=(String) input_parameter[1];
		
		WebElement total=driver.findElement(By.xpath(xpath));
		total.clear();
		total.sendKeys(enter_text);
		
	}
	
	//Click
	public static void click(Object[]input_parameter)
	{
		
		try {
			Thread.sleep(3000);
		
		String xpath=(String) input_parameter[0];
		
		WebElement total=driver.findElement(By.xpath(xpath));
		total.clear();
		total.click();
		
	}
	 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 }	}
	
	// Dropdown 
	
	public static void dropDown(Object[]input_parameter)
	{
		
		String xpath=(String) input_parameter[0];
		String value=(String) input_parameter[1];
		Select s=new Select(driver.findElement(By.xpath(xpath)));
		s.selectByVisibleText(value);
		
	}
	
	
	public static void main(String[] args) 
	{
		
		//Launch Browser
		Object[] input=new Object[2];
		input[0]="Chrome";
		input[1]="E:\\Automation Support\\\\chromedriver.exe";
		SeleniumOperations.browserLaunch(input); 
		
		//Oprn application
		Object[] input1=new Object[1];
		input1[0]="htpps://primusbank.gedgetch.com";
		
		SeleniumOperations.openApp(input1); 
		
		//Username
		Object[]input2=new Object[2];
		input2[0]="//*[@type='text']";
		input2[1]="Admin";

		SeleniumOperations.sendkeys(input2);
		
		//password
		
		Object[]input3=new Object[2];
		input3[0]="//*[@type='text']";
		input3[1]="Admin";
		SeleniumOperations.sendkeys(input3);
		
		//click on login
		Object[] input4=new Object[1];
		input4[0]="//*[@name='login']";
		
		SeleniumOperations.click(input4);
		
		//click on branches
		Object[] input5=new Object[2];
		input5[0]="//*[@name='drlist']";
		SeleniumOperations.click(input5);
		
		//select country
		Object[] input6=new Object[2];
		input6[0]="//*[@name='lst_countryS']";
		input6[1]="INDIA";
		SeleniumOperations.dropDown(input6);
		
		
		//select state
				Object[] input7=new Object[2];
				input7[0]="//*[@name='lst_stateS']";
				input7[1]="MAHARASHTRA";
				SeleniumOperations.dropDown(input7);
				
				//select City
				Object[] input8=new Object[2];
				input8[0]="//*[@name='lst_cityS']";
				input8[1]="SHIRDI";
				SeleniumOperations.dropDown(input8);
				
				//click on search
				Object[] input9=new Object[1];
				input9[0]="//*[@name='btn_search']";
				SeleniumOperations.click(input9);
				
		
		
		
		
	}
	
	
	
}
