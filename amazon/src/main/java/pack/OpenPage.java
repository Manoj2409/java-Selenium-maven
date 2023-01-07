package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class OpenPage{
	static WebDriver driver =new ChromeDriver();
public OpenPage()  {	
	
	driver.manage().window().maximize();
	FileInputStream stream = null;
	try {
		stream = new FileInputStream("config.properties");
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Properties properties=new Properties();

	try {
		properties.load(stream);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	driver.get(properties.getProperty("url"));
	String a=driver.getTitle();
	System.out.println("The title of the Webpage :");
	System.out.println(a);
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void sleep(int seconds) {
	try {
		Thread.sleep(seconds);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
