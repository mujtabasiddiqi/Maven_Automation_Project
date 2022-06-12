package Day10_052822;

import ReuseableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Example {
    //declare the local variable outside so it can be reusable outside with other annotation method
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite

    @Test(priority = 1)
    public void SearchForKeyWord(){
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        Reusable_Actions.sendKeysAction(driver,"//*[@name='q']","BMW","Search Field");
        //submit the go button
        Reusable_Actions.submitAction(driver,"//*[@name='btnK']","Google Search Button");
    }//end of test 1

    /*
    depends on method is used when the following test is dependant on previous @Test method. If the first test fails
    the dependent test will skip
    */



    @Test(dependsOnMethods = "SearchForKeyWord")
    public void CaptureSearchNumber(){
        //capture search result
        String result = Reusable_Actions.getTextAction(driver,"//*[@id='result-stats']","Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    }//end of test 2

    @AfterSuite
    public void QuitSession(){
        //quit the driver
        driver.quit();
    }//end of after suite





}//end of class
