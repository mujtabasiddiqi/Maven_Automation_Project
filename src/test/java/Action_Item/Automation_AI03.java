package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI03 {

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
        //options.addArguments("headless");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();

        //capture search number and print for following hobbies using arrayList and for loop
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("Walking");
        hobbies.add("Gardening");
        hobbies.add("Basketball");
        hobbies.add("Gaming");
        hobbies.add("Travelling");
        for (int i = 0; i < hobbies.size(); i++) {

            //go to google home page
            driver.navigate().to("https://www.bing.com");
            Thread.sleep(3000);
            //maximize the driver
            driver.manage().window().maximize();
            //locate element for search field and type keyword 'Hobbies'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies.get(i));
            //submit on Bing search button
            driver.findElement(By.xpath("//*[@name='q']")).submit();
            Thread.sleep(2000);
            //capture the Bing search and print it
            String searchResult = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();
            //System.out.println("result is " + searchResult);
            //extract out the number and print the search number only for each hobby
            String[] arrayResult = searchResult.split(" ");
            System.out.println("My search number for hobby " + hobbies.get(i) + " is " + arrayResult[0]);
        }//end of for loop

        //quit the driver
        driver.quit();




    }//end of main

}//end of class
