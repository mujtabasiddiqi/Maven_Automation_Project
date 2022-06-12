package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) {

        //setup your chromedriver with webdriver manager
        WebDriverManager.chromedriver().setup();
        //define the webDriver I am going to use
        WebDriver driver = new ChromeDriver();

        //go to Google home page
        driver.navigate().to("https://www.google.com");
        //maximize the driver
        driver.manage().window().maximize();
        //locate element for search field and type keyword 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        //submit on Google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        //capture the Google search and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //System.out.println("Result is " + searchResult);
        //extract out the number and print the search number only
        String[] arrayResult = searchResult.split(" ");
        String replaceParanth = arrayResult[3].replace("(","").replace(")","");
        System.out.println("My search number is " + arrayResult[1]);






        //quit the driver
        driver.quit();
    }//end of main

}//end of java class
