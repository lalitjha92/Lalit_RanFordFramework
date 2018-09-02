package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;





public class Base {
	
	static Properties p;
	
	public static Logger log = Logger.getLogger(Base.class);
	
	public static void loadproperty1() {
		try {
			File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\configuration\\testdata.properties");
			FileReader fr = new FileReader(f);
			p = new Properties();
			p.load(fr);
		} catch (FileNotFoundException  e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}  
	
	public static String read_testdata(String key) {
		loadproperty1();
		String x = p.getProperty(key);
		return x;
	}

	public static void loadproperty2() {
		try {
			File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\configuration\\OR.properties");
			FileReader fr = new FileReader(f);
			p = new Properties();
			p.load(fr);
		} catch (FileNotFoundException  e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public static String read_OR(String key) {
		loadproperty2();
		String x = p.getProperty(key);
		return x;
	}
	public static By getlocator(String key)
	{
		loadproperty2();
		
		By loc =null;
		String elename =p.getProperty(key);
		String loctype = elename.split(":")[0];
		String locval= elename.split(":")[1];
		
		switch(loctype)
		{
		case "id":
			
			loc= By.id(locval);
			break;
			
		case "name":
			
			loc = By.name(locval);		
			break;
			
		case "xpath":
			
			loc = By.xpath(locval);
			break;
			
		case "linkText":
			
			loc= By.linkText(locval);
			break;
		}
		
		
		return loc;
	}
}
