package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotation_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage extends Reusable_Annotation_Class {
    //Declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public GoogleSearchResultPage(WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotation_Class.logger;
    }//end of constructor


    //define all the webelements using @find by concept
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResult;


    public void CaptureSearchNumberAndPrintIt(){
        String result = Reusable_Actions_POM_Loggers.getTextAction(driver,searchResult,logger,"Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("My search number is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"My search number is " + arrayResult[1]);
    }//end of google search button

}//end of class




