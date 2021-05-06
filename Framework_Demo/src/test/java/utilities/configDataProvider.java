package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {
	Properties pro;
	public configDataProvider()
	{
		File src=new File("./Configuration/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("File not loading"+e.getMessage());
		}
		
		
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser1");
		
	}
	public String getStartUpURL()
	{
		return pro.getProperty("StartAppUrl");
	}
	public String getDataFrmConfig(String key)
	{
		return pro.getProperty(key);
	}
}
