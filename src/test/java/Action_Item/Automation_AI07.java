package Action_Item;

import ReuseableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Automation_AI07 {

    //define the driver outside so it can be reusable with other annotation methods
    WebDriver driver;
    //declare the logger
    ExtentTest logger;
    //declare the report
    ExtentReports reports;

    //before suite will set the driver we are going to use
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_AI07",true);
    }//end of before suite annotation


    @Test(priority = 1)
    public void ClickShopForplans(){
    //Use Case; To be able to click on find a doctor
    logger = reports.startTest("Shop For Plans");
    driver.navigate().to("https://www.humana.com");
    //click on shop for plans
    Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Shop for Plans']",logger,"Shop for Plans");
    

    }//end of test 1


}//end of class
