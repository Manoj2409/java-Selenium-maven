import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class data {
    static WebDriver driver;
    static String url="https://www.redbus.in/";

    static String name="Manoj";
    static String age="22";
    static String email="manojt2409@gmail.com";
    static String phone="9790914976";

    static By fromLocationPath=By.xpath("//li[contains(text(),'"+"Chennai"+"')]");
    static By fromPath=By.id("src");
    static By toPath=By.id("dest");
    static By toLocationPath=By.xpath("//li[contains(text(),'"+"Madurai"+"')]");
    static By dataFieldPath=By.id("onward_cal");
    static By datePath=By.xpath("//div[@id='rb-calendar_onward_cal']/table[@class='rb-monthTable first last']/tbody/tr[6]/td[1]");
    static By searchBtn=By.id("search_btn");
    static By popUp=By.xpath("//i[@class='icon icon-close']");
    static By lowerDeck=By.xpath("//div[text()='Lower Deck']");
    static By canvasPath=By.xpath("//*[@id='rt_23902073']/div/div/div/div[3]/div[3]/div[2]/canvas");
    static By viewSeatBtn=By.xpath("//*[@id='23902073']/div/div[2]/div[1]");
    static By Cmbt=By.xpath("//span[text()='Koyambedu']");
    static By Madurai=By.xpath("//span[text()='Karungalakudi(Madurai) Near Near Bus Stop']");
    static By selectedBtn=By.xpath("//button[@class='button continue inactive']");
    static By namePath=By.xpath("//input[@name='Name_0']");
    static By Name=By.xpath("//*[@name='Name_0']");
    static By genderBtn=By.xpath("//*[@class='gender_position_abs ']");
    static By Age=By.xpath("//*[@placeholder='Age']");
    static By Email=By.xpath("//*[@placeholder='Email ID']");
    static By Phone=By.xpath("//*[@placeholder='Phone']");
    static By noInsuranceOpt=By.xpath("//*[@id='insuranceNotOpted']");
    static By proceedBtn=By.xpath("//input[@value='Proceed to pay']");

    public static void explicitWait(By element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(namePath));
    }

    public static void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    public static void sleep(int milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }
    public static void screenShot(String ScreenshotName) throws IOException {
        try {
            File takeScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(takeScreenShot, new File(".//screenshot/" + ScreenshotName + ".jpg"));
        } catch (WebDriverException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
