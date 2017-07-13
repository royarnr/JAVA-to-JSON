package businesscomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class ManulifeCA extends ReusableLibrary{

	public ManulifeCA(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	public void invokeManulifeCA()
	{
		driver.get(dataTable.getData("General_Data", "Link URL"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		report.updateTestLog("Manulife CA application", "Laucnhed", Status.DONE);
	}

	public void clickbusiness()
	{
		driver.findElement(By.xpath("//a[text()[contains(.,'For business')]]")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		try {

			WebElement manulifeLogo = driver.findElement(By.xpath("(//img[@alt='Manulife Logo'])[2]"));
			if (manulifeLogo.isDisplayed())
			{
				report.updateTestLog("Verify Manulife Logo", "Present", Status.PASS);
			}
			else
			{
				report.updateTestLog("Verify Manulife Logo", "Absent", Status.FAIL);
			}
		} catch (NoSuchElementException e) {

			System.out.println("Element not found");
		}


	}

}
