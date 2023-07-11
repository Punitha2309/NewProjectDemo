package Com.PropertyFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties p;
	
    public ConfigReader() throws IOException {
    	
    	File f = new File("C:\\Users\\punit\\eclipse-workspace\\Maven-Project\\PropertyFile\\Userdata.properties");
    	
    	FileInputStream fis = new FileInputStream(f);
    	p = new Properties();
    	p.load(fis);
    	
    }
    
    public String getUrl() {
    	String url = p.getProperty("url");
    	System.out.println(url);
    	return url;
    }
	

}
