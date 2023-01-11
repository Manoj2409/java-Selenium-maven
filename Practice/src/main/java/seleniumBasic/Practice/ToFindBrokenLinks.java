package seleniumBasic.Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToFindBrokenLinks {
	static int invalid = 0;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://edition.cnn.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List<WebElement> webelements = driver.findElements(By.tagName("a"));
		System.out.println(webelements.size());
		for (WebElement webelement : webelements) {
			String link = webelement.getAttribute("href");
			BrokenLink(link);

		}
		System.out.println();
		System.out.println("The total number of invalid links are " + invalid);

		driver.quit();
	}

	public static void BrokenLink(String link) throws IOException {
		try {
			URL url = new URL(link);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			System.out.println();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.print(
						link + " - " + httpURLConnect.getResponseMessage() + " is a broken link" + " Response code : ");
				System.out.print(httpURLConnect.getResponseCode());
				invalid++;
			}

			else {
				System.out.print(link + " - " + httpURLConnect.getResponseMessage() + " Response code : ");
				System.out.print(httpURLConnect.getResponseCode());
			}
		} catch (Exception e) {
		}

	}

}
