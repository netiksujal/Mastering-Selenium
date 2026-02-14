package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromProperties {

	public static void main(String[] args) throws IOException {
		//step 1: get the java representation object of the physical file
		FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
		
		//step2: load all the keys by using load(fis) method of properties class
		Properties pobj= new Properties();
		pobj.load(fis);
		
		//step3: get the values by giving keys, in the getProperty(key) method
		String Browser =pobj.getProperty("bro");	
		String URL =pobj.getProperty("url");	
		String UserName =pobj.getProperty("un");	
		String Password =pobj.getProperty("pwd");	
		
		
		System.out.println(Browser);
	    System.out.println(URL);
	    System.out.println(UserName);
	    System.out.println(Password);
	    
	    
	}

}
