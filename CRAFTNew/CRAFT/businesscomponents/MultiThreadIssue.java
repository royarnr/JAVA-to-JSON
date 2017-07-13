package businesscomponents;

import java.util.concurrent.TimeUnit;

import com.cognizant.framework.Status;

import componentgroups.SamplePage;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class MultiThreadIssue extends ReusableLibrary {

	public MultiThreadIssue(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}
	
	
	public void launchSFDC()
	{
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		sleep(5);
		report.updateTestLog("Test Case SFDC", "SFDC Launch", Status.PASS);
	}
	
	public void launchGoogle()
	{
		driver.get("https://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		sleep(5);
		report.updateTestLog("Test Case Google", "Google Launch", Status.PASS);
		
	}
	
	public void launchYahoo()
	{
		driver.get("https://www.cleartrip.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		sleep(5);
		report.updateTestLog("Test Case CT", "CT Launch", Status.FAIL);
	}
	
	public void launchTM3()
	{
		driver.get("https://qat-mlc-qat.cs41.force.com/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		sleep(5);
		report.updateTestLog("Test Case TM3", "TM3 Launch", Status.FAIL);
	}
	
	public void launchMLC()
	{
		driver.get("https://www.manulife.ca");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		sleep(5);
		report.updateTestLog("Test Case MLC", "MLC Launch", Status.PASS);
	}
	

	
	public void pageSFDC()
	{
		SamplePage sfdcpage = new SamplePage(scriptHelper);
		sfdcpage.logintoSFDC();
		report.updateTestLog("Login", "Login", Status.PASS);
	}
	

}
