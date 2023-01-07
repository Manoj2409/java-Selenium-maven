package pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//click
//span[@id="nav-link-accountList-nav-line-1"]
public class LoginPage extends OpenPage {

public LoginPage() {
	sleep(2000);
	Properties properties=new Properties();
	try {
		properties.load(new FileInputStream("config.properties"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sleep(1000);
	WebElement signinbtn=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
	signinbtn.click();
	
	WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
	email.sendKeys(properties.getProperty("phoneNumber"));
	
	WebElement continebtm=driver.findElement(By.xpath("//input[@id='continue']"));
	continebtm.click();
	sleep(1000);
	
	
	WebElement Wpass=driver.findElement(By.xpath("//input[@type='password']"));
	Wpass.sendKeys(properties.getProperty("password"));
	
	
	WebElement password=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
	password.click();
	sleep(1000);
	
	System.out.println("The page is successfully logged in");
	
	
}
	

	

}
