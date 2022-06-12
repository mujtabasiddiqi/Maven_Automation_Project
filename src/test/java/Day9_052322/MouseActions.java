package Day9_052322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //navigate to usps websitbe
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);

        //declare and define mouse actions
        Actions mouseActions = new Actions(driver);

        //hover to send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        //click on tracking using mouse actions
        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();
        Thread.sleep(3000);

        //type an invalid tracking number using sendkeys with some mouse actions
        WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingField).click().sendKeys("111234243242").perform();

    }//end of main
}//end of class
