package businesscomponents;

import java.util.concurrent.TimeUnit;

import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class MailinatorCP extends ReusableLibrary {

	public MailinatorCP(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}
	
	public void launchMailinator()
	{
		driver.get("http://www.mailinator.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		report.updateTestLog("Mailinator Launched", "Mailinator launched", Status.DONE);
	}

	public void keyinemailID()
	{
		driver.findElement(By.cssSelector("#inboxfield")).sendKeys(dataTable.getData("General_Data", "Email"));
		driver.findElement(By.xpath("//button[text()[contains(.,'Go')]]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		report.updateTestLog("Email ID entered", "Email ID entered", Status.DONE);
	}
	
	public void clickemaillink()
	{
		driver.findElement(By.xpath("//div[text()[contains(.,\""+dataTable.getData("General_Data", "Subject")+"\")]]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		report.updateTestLog("Mail", "Mail opened", Status.DONE);
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("#publicshowmaildivcontent")));
		WebElement link = driver.findElement(By.xpath("//a[text()[contains(.,'"+dataTable.getData("General_Data", "ActivateLink")+"')]]"));
//		((JavascriptExecutor) driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", link);
		
		System.out.println(link.getAttribute("href"));
//		link.click();
		String linkURL = link.getAttribute("href");
		
		dataTable.putData("General_Data", "Link URL", linkURL);
//		driver.get(linkURL);
		report.updateTestLog("Link", "Link opened", Status.PASS);
		
	}
	
	public void clicktoactivateuser()
	{
		driver.get(dataTable.getData("General_Data", "Link URL"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		report.updateTestLog("Activate Link", "User activated", Status.PASS);

	}
}
