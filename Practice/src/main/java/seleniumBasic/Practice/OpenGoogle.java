package seleniumBasic.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		String a = driver.getTitle();
		System.out.println(a);
		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.quit();

	}
}
