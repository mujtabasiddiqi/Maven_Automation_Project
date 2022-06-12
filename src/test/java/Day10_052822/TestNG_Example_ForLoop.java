package Day10_052822;

import ReuseableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_Example_ForLoop {
    //set the local driver outside so it can be used with other annotation methods
    WebDriver driver;

    //set the driver we are going to use
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite

    @Test(priority = 1)
    public void SearchForKeyWord(){
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");
        for(int i = 0; i<cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            //enter a keyword on search field
            Reusable_Actions.sendKeysAction(driver, "//*[@name='q']", "BMW", "Search Field");
            //submit the go button
            Reusable_Actions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");
            //capture search result
            String result = Reusable_Actions.getTextAction(driver, "//*[@id='result-stats']", "Search Result Text");
            //split the result by single space and print out the search number
            String[] arrayResult = result.split(" ");
            System.out.println("Search number is " + arrayResult[1]);
        }//end of for loop
    }//end of test

    @AfterSuite
    public void QuitSession(){
        //quit the driver
        driver.quit();
    }//end of after suite


}//end of class
