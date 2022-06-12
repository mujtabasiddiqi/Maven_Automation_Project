package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptions_GoogleSearch {
        public static void main(String[] args) throws InterruptedException {

            //setup your chromedriver with webdriver manager
            WebDriverManager.chromedriver().setup();
            //set chrome options arguments
            ChromeOptions options = new ChromeOptions();
            //set the condition to incognito mode
            options.addArguments("incognito");
            //set the condition to maximize/fullscreen your driver
            options.addArguments("start-maximized");
            //setting your driver as headless(running on background)
            options.addArguments("headless");
            //for mac use full screen
            options.addArguments("start-fullscreen");
            //define the webdriver I am going to use
            WebDriver driver = new ChromeDriver();

            //go to google home page
            driver.navigate().to("https://www.google.com");
            Thread.sleep(3000);
            //maximize the driver
            driver.manage().window().maximize();
            //locate element for search field and type keyword 'cars'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
            //submit on google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            //capture the google search and print it
            String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //System.out.println("result is " + searchResult);
            //extract out the number and print the search number only
            String[] arrayResult = searchResult.split(" ");
            String replaceParanth = arrayResult[3].replace("(","").replace("(","");
            System.out.println("My search num is " + arrayResult[1]);

            //quit the driver
            driver.quit();

    }//end of main
}//end of java class
