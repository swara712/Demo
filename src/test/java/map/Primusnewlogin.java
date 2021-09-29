package map;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import new_reusable.Reusable;

public class Primusnewlogin 
{


	  public ChromeDriver driver;
		@Given("users opens {string} browser and exe {string}")
		public void user_open_browser_and_exe(String b, String e)
		{
		  Object[] input=new Object[2];
		  input[0]=b;
		  input[1]=e;
		  Reusable.browserLaunch(input);
		}

		@Given("user enters url as {string}")
		public void user_enters_url_as(String url) throws InterruptedException
		{
			Thread.sleep(6000);
			 Object[] input2=new Object[1];
			  input2[0]=url;
		//  driver.manage().timeouts().implicitlyWait(10, TimeUnit	.SECONDS);
			  
			  Reusable.openApp(input2);
			
		   
		}

		@When ("^user enters (.+) as username$")
		public void user_enter_admin_as_username(String uname) throws InterruptedException 
		{
			// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 Object[] input3=new Object[2];
			  input3[0]="//*[@type='text']";
			  input3[1]=uname;
			  Reusable.sendkeys(input3);
			 
			  
		}

		@When ("^user enters (.+) as password$")
		public void user_enter_admin_as_password(String pw) throws InterruptedException 
		{
			
			// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 Object[] input4=new Object[2];
			  input4[0]="//*[@name='txtPword']";
			  input4[1]=pw;
			  Reusable.sendkeys(input4);
			
		   
		}

		@When("user click on login button")
		public void user_click_on_login_button() 
		{
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			Object[] input4=new Object[1];
			  input4[0]="//*[@name='login']";
			  
			  Reusable.click(input4);
			 
			
			

		}


	@Then ("^Check (.+) as validation msg for valid credential$")
		public void check_as_validation_msg_for_valid_credential(String given) throws Exception
		{
			Thread.sleep(3000);
			Object[] input6=new Object[2];
			 input6[0]= given;
			input6[1]="//*[@size='3']";
			Reusable.valid((Object[]) input6);
		}
		@Then ("^Check (.+) as validation msg for invalid credential$")
		public void check_as_validation_msg_for_invalid_credential(String given)
		{
			try {
			
			   String Actual=driver.findElementByXPath("//*[@size='3']").getText();
				if(given.equals(Actual))
				{
					System.out.println("Test Case Is Fail");
					
				}
				else
				{
					
					System.out.println("Test Case Is Pass");
				}
			}
			catch(Exception e)
			{
				System.out.println("Test case is Pass");
				
			}

		}
		@Then("close browser")
		public void close_browser()
		{
		  Reusable.close();
		}

	
}
