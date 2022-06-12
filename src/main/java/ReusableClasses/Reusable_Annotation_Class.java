package ReusableClasses;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Reusable_Annotation_Class {
    //set all global variables here with public static
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    //Set Before suite for report path and set driver
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions_Loggers.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html",true);
    }//end of before suite annotation

    //set Before method to capture test name for each @test, so it can be added to the html report later
    @BeforeMethod
    public void getTestName(Method testName){
        logger = reports.startTest(testName.getName());

    }//end of before method

    //set after method to end the logger for each @test in your test class
    @AfterMethod
    public void endLogger(){
        reports.endTest(logger);
    }//end of after method

    //after suite to flush the report and quit the driver
    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite

}//end of class
