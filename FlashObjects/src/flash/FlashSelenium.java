package flash;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Flash.FlashObjectWebDriver;

import org.openqa.selenium.JavascriptExecutor;

public class FlashSelenium {

	
	public static String iedriverpath = System.getProperty("user.dir")+File.separator+"IEDriverServer.exe";
	public static WebDriver driver;
	
	
	public static void main(String[] args) {

		System.setProperty("webdriver.ie.driver", iedriverpath);
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
//		FlashObjectWebDriver flash = new FlashObjectWebDriver(driver, "myFlashMovie");
		driver.get("http://demo.guru99.com/flash-testing.html");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
//		String javascript = "var obj = document.getElementById('arguments[0]');"+
//		"var source = [];"+
//		"for(var prop in obj){"+
//			  "var fx = obj[prop];"+
//			  "if(obj.hasOwnProperty(prop) && (typeof fx == 'function') && /eval\\(instance/.test(fx)){"+
//			    "console.log(prop)"+
//			  "source.push(prop)"+
//			  "}"+
//			  "}"+
//			"return source;"
//			  +"};";
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		List<?> functions = (List<?>)jse.executeScript(javascript, "myFlashMovie");
//		
//		for (Object string : functions) {
//			System.out.println(string);
//		}
		
//		flash.callFlashObject("click");
//		try {
//			Thread.sleep(10000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Screen screen = new Screen();
		Pattern typetext = new Pattern(System.getProperty("user.dir")+File.separator+"Images"+File.separator+"TypeText.PNG");
		try {
			screen.wait(typetext, 1);
			
			screen.click(typetext);
			
			screen.type("This is Sikuli!");
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}
