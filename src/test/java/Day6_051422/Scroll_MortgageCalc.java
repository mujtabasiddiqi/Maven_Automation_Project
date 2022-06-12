package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_MortgageCalc {
    public static void main(String[] args) throws InterruptedException {
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
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver();
        //navigate to mortgage calculator site
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
        //declare java script executor variable
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll to pixel 400 on mortgage calc website
        jse.executeScript("scroll(0,800)");
        //wait a bit for website to load
        Thread.sleep(2000);
        //declare a webelement variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));
        //scroll into share this location button
        jse.executeScript("arguments[0].scrollIntoView(true)", shareButton);
        Thread.sleep(2000);
        //click on share this calculation button
        shareButton.click();
        Thread.sleep(2000);
        //scroll back up
        jse.executeScript("scroll(0,-800)");
        Thread.sleep(2000);

        //quit the driver
        driver.quit();


    }//end of main
}//end of class
