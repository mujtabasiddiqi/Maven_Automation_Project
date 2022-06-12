package Day11_052922;

import ReuseableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Google_Search_HTML_Report {

    //declare the local variable outside so it can be reusable outside with other annotation method
    WebDriver driver;
    //declare the logger
    ExtentTest logger;
    //declare the report
    ExtentReports reports;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html",true);
    }//end of before suite

    @Test(priority = 1)
    public void SearchForKeyWord(){
        logger = reports.startTest("Search for a keyword");
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit the go button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");
        //end the logger per test
        reports.endTest(logger);
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
        //end the logger
        reports.endTest(logger);

    }//end of test 2

    @AfterSuite
    public void QuitSession(){
        //quit the driver
        driver.quit();
        reports.flush();
    }//end of after suite





}//end of class
