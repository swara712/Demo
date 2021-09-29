package map;



import java.net.UnknownHostException;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Node.ScenarioOutline;
import utility.HTMLReportGenerator;

public class Hookable 
{
	
	
	   @io.cucumber.java.Before
	   public void before(ScenarioOutline scenario) throws UnknownHostException
	   {
		   HTMLReportGenerator.TestSuiteStart("E:\\report\\primusbank.html", "Flipkart");
		   
		   HTMLReportGenerator.TestCaseStart(scenario.getName(), scenario.getStatus());
		   
		   System.out.println("--------------------------------Scenario start----------------------------------------");
	   }
	
	
	
	
	
       @After
	   public void after(Scenario scenario)
	   {
		   System.out.println("--------------------------------Scenario end----------------------------------------");
		   
		   HTMLReportGenerator.TestCaseEnd();
		   HTMLReportGenerator.TestSuiteEnd();
	   }
	
	
	
	
	
	
	

}
