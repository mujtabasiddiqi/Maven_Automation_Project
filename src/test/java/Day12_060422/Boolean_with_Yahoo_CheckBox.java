package Day12_060422;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotation_Class;
import ReuseableLibraries.Reusable_Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Boolean_with_Yahoo_CheckBox extends Reusable_Annotation_Class {

    @Test(priority = 2)
    public void Yahoo_Stay_Signed_In_Checkbox_Verification() {
        //navigate to usps
        driver.navigate().to("https://www.yahoo.com");
        //click on Sign in
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Sign in']",logger,"Sign In");
        //verify the stay signed in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver,10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        if (elementState == true){
            logger.log(LogStatus.PASS,"CheckBox is selected as expected");
        } else {
            logger.log(LogStatus.FAIL,"CheckBox is not selected");
        }
    }//end of test

    @Test(priority = 1)
    public void NavigatetoYahooHomePage(){
        //navigate to home page
        logger.log(LogStatus.INFO,"Navigating to home page");
        driver.navigate().to("https://www.yahoo.com");
    }
}//end of class
