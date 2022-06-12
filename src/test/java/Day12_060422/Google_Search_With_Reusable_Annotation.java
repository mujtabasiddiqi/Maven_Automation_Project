package Day12_060422;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotation_Class;
import ReuseableLibraries.Reusable_Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Google_Search_With_Reusable_Annotation extends Reusable_Annotation_Class {

    @Test(priority = 1)
    public void SearchForKeyWord(){
        logger = reports.startTest("Search for a keyword");
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit the go button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");
    }//end of test 1

    /*
    depends on method is used when the following test is dependant on previous @Test method. If the first test fails
    the dependent test will skip
    */


    @Test(dependsOnMethods = "SearchForKeyWord")
    public void CaptureSearchNumber(){
        logger = reports.startTest("Capture search result");
        //capture search result
        String result = Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"my search number is " + arrayResult[1]);

    }//end of test 2

}//end of class
