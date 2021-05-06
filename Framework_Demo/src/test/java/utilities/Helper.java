package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	//get screenshots, alert,windows,syncissue,javascript executor
	 
		//first we manage screenshot
		public static String CaptureScreenshot(WebDriver ldriver)
		{
			String ScrennshotPath=System.getProperty("user.dir")+"/Screenshots/Framework_Screenshot_"+getCurrentDateTime()+".png";
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE );
		try {
			FileHandler.copy(src, new File(ScrennshotPath));
			System.out.println("Screenshot captured");
		} catch (Exception e) {
			System.out.println("Unable to take screenshot"+e.getMessage());
		}
		return ScrennshotPath;
		}
		
		public static String getCurrentDateTime()
		{   
			DateFormat currentformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			Date currentDate=new Date();
			return currentformat.format(currentDate);
		}
}
