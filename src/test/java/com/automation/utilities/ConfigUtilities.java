package com.automation.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class ConfigUtilities {

	public String readProperty(String key)  
	{
		String value="";
		try {
			System.out.println(System.getProperty("user.dir"));
			FileReader f=new FileReader(System.getProperty("user.dir")+"/config.properties");
			Properties pt= new Properties();
			pt.load(f);
			value= pt.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return value;
	}

}
