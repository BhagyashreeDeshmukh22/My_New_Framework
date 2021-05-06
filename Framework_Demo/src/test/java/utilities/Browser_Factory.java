package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Factory {
	public static WebDriver startApplication(WebDriver ldriver,String browser,String app_URL)
	{
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Workplaceseleniumclass\\Framework_demo\\Drivers\\chromedriver.exe");
			ldriver=new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Workplaceseleniumclass\\Framework_demo\\Drivers\\geckodriver.exe");
			ldriver=new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.edge.driver","D:\\Workplaceseleniumclass\\Framework_demo\\Drivers\\msedgedriver.exe");
	 ldriver=new EdgeDriver();
		}
		else
		{
			System.out.println("we didnot support this driver");
		}
		ldriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS );
		ldriver.manage().window().maximize();
		ldriver.get(app_URL);
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return ldriver;
}
	public static void quit_Browser(WebDriver ldriver)
	{
		ldriver.quit();
	}
}
