package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiguration {
	
	Properties prop;
	
	public ReadConfiguration()
	{
		File src=new File(System.getProperty("user.dir")+"\\ConfigFiles\\Config.Properties");
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(src);			
			prop.load(fis);			
			}
		catch(Exception e)
		{
			System.out.println("Execption is "+e.getMessage());
		}
	}

	public String getAppURL()
	{
		String URL=prop.getProperty("baseurl");
		return URL;
	}
	
	public String getUsername()
	{
		String Uname=prop.getProperty("username");
		return Uname;
	}
	public String getPassword()
	{
		String Uname=prop.getProperty("password");
		return Uname;
	}
	public String getChromePath()
	{
		String ChromePath=prop.getProperty("ChromePath");
		return ChromePath;
	}
	
	public String getFireFoxPath()
	{
		String FireFoxPath=prop.getProperty("FireFoxPath");
		return FireFoxPath;
	}
}
