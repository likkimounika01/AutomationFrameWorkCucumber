package com.automation.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonUtilities {
	
	public String readJson(String key)
	{
		String value="";
		JSONParser parser = new JSONParser();
		try {
			Object oj=parser.parse(new FileReader(System.getProperty("user.dir")+"/TestData/TestData.json"));
			JSONObject jsonObject =(JSONObject) oj;
			value = (String)jsonObject.get(key);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	}
	

}
