package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Actions_Loggers {
    //set a static timeout variable so it can cover all explicit for all methods
    static int timeout = 20;


    public static WebDriver setDriver(){
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("headless");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"successfully able to perform " + elementName);
        } catch (Exception e) {
            System.out.println("unable to hover on element " + elementName);
        }
    }//end of mouse hover

    //create a click method
    public static void clickAction(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully able to click " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to click on element " + e);
        }
    }//end of clickAction

    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to click on element " + elementName);
        }
    }//end of sendkeys method

    public static void sendKeysAction(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys();
            logger.log(LogStatus.PASS,"Successfully able to send " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of sendkeys method


    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS,"Successfully able to click " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickByIndexAction


    //create a verify title method
    public static void verifyTitleMethod(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            String Title = setDriver().getTitle();
        } catch (Exception e) {
            System.out.println("Unable to verify title " + elementName+ " " + e);
        }
    }//end of verifyTitleMethod

    //create a capture text method
    public static void captureTextMethod(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            String errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            System.out.println("The error message is " + errorMessage);
            logger.log(LogStatus.PASS,"successfully able to capture " + elementName);
        } catch (Exception e) {
            System.out.println("unable to catch it" + e);
        }//end of capture text exception
    }//end of captureTextMethod

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName);
        }//end of exception
    }//end of submit


    //create a getText method
    public static String getTextAction(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"successfully able to get the text of user value " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to capture text of element " + elementName + " " + e);
        }
        return result;
    }//end of getTextAction method



}//end of class


