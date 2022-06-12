package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;

public class FindElementsExample {
    public static void main(String[] args) throws InterruptedException {

        //go to bing, click on the second element of links by using class and index

        //setup your chromedriver with webdriver manager
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
        WebDriver driver = new ChromeDriver();

        //Navigate to Bing home page
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(2000);
        //click on Images using class property with index 1
        //to ignore white space in property value we can use contains command in xpath
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();

    }//end of main
}//end of class
