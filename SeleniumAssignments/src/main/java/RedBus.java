import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class RedBus extends data {
    public static void main(String[] args) throws InterruptedException, IOException {

        OpenBrowser();
        FromAndToSelected();
        VerifyFromAndTo();
        ViewSeats();
        SelectSeats();
        SelectLocations();
        PersonalDetails();
        PaymentPage();

    }

    public static void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        implicitlyWait(20);
        String a = driver.getTitle();
        System.out.println(a);
    }

    public static void FromAndToSelected() {
        //From location
        WebElement from = driver.findElement(fromPath);
        if (from.isDisplayed()) {
            System.out.println("From is enabled");
        }
        from.sendKeys("Chennai");
        implicitlyWait(2);
        WebElement fromLocation = driver.findElement(fromLocationPath);
        fromLocation.click();

        //to location
        WebElement to = driver.findElement(toPath);
        if (to.isDisplayed())
            System.out.println("From is enabled");
        to.sendKeys("Madurai");
        implicitlyWait(2);
        WebElement toLocation = driver.findElement(toLocationPath);
        toLocation.click();

        //Date selection from calendar
        WebElement dateField = driver.findElement(dataFieldPath);
        dateField.click();
        WebElement date = driver.findElement(datePath);
        date.click();
        implicitlyWait(2);

        // Search button
        WebElement searchButton = driver.findElement(searchBtn);
        searchButton.click();
    }

    public static void VerifyFromAndTo() throws IOException, InterruptedException {
        sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        if (title.contains("Chennai to Madurai Bus Tickets Booking")) {
            System.out.println("Title is verified");
        } else {
            System.out.println("Wrong Title");
        }
        screenShot("FromAndTo");
    }

    public static void ViewSeats() throws IOException, InterruptedException {

        //Handling Popup
        sleep(5000);
        driver.findElement(popUp).click();

        //Selecting view seats
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement viewSeats = wait.until(ExpectedConditions.visibilityOfElementLocated(viewSeatBtn));
        screenShot("ViewSeat");
        viewSeats.click();
        implicitlyWait(5);

    }

    public static void SelectSeats() throws InterruptedException, IOException {

        //selecting the seat
        sleep(4000);

        //explicitWait(lowerDeck, 20);
        WebElement canvas = driver.findElement(canvasPath);
        Actions actions = new Actions(driver);
        int flag = 0;
        for (int i = 30; i < 75 && flag != 1; i = i + 2) {
            for (int j = 30; j < 75 && flag != 1; j = j + 2) {
                actions.moveToElement(canvas, i, j).click().build().perform();
                if (!(canvas.getAttribute("class").equals(""))) {
                    flag = 1;
                }
            }
        }
        screenShot("selectedSeat");
    }

    public static void SelectLocations() throws IOException {


        implicitlyWait(2);
        driver.findElement(Cmbt).click();
        implicitlyWait(2);
        driver.findElement(Madurai).click();
        implicitlyWait(2);
        screenShot("selectedLocation");
        driver.findElement(selectedBtn).click();
    }

    public static void PersonalDetails() throws IOException {
        explicitWait(namePath, 7);
        driver.findElement(Name).sendKeys(name);
        driver.findElement(genderBtn).click();
        driver.findElement(Age).sendKeys(age);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Phone).sendKeys(phone);
        screenShot("PersonalDetails");
        driver.findElement(noInsuranceOpt).click();


    }

    public static void PaymentPage() throws IOException, InterruptedException {
        driver.findElement(proceedBtn).click();
        sleep(3000);
        screenShot("paymentDetails");
    }



}
