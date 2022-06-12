package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Automation_AI05 {
    public static void main(String[] args) {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        options.addArguments("full-screen");
        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver(options);


        //navigate to hotels.com
        driver.navigate().to("https://www.hotels.com");

        //type destination in search field
        try {
            WebElement searchField = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
            searchField.click();
            //searchField.sendKeys("Miami");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("unable to click search field " + e);
        }//end of searchfield exception


        //enter in location in search field
        try {
            WebElement enterDestination = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
            enterDestination.click();
            enterDestination.sendKeys("Miami");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("unable to enter destination " + e);
        }//end of enter destination Exception


        //Enter check in date in check in field
        try {
            WebElement checkIndropDown = driver.findElement(By.xpath("//*[@id='d1-btn']"));
            checkIndropDown.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("unable to enter in check In date " + e);
        }//end of check In exception


        //enter exception for check in date
        try {
            WebElement checkIndate = driver.findElement(By.xpath("//*[@aria-label='Jun 14, 2022']"));
            checkIndate.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("unable to enter check in date " + e);
        }//end of check in exception




    }//end of main
}//end of java class