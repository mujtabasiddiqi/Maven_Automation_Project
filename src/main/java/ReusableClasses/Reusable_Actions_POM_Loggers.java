package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Reusable_Actions_POM_Loggers {
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
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"successfully able to perform " + elementName);
        } catch (Exception e) {
            System.out.println("unable to hover on element " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of mouse hover

    //create a click method
    public static void clickAction(WebDriver driver,WebElement xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            logger.log(LogStatus.PASS,"Successfully able to click " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to click on element " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of clickAction

    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver,WebElement xpath, String userValue,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to click on element " + elementName);
            getScreenShot(driver,elementName,logger);
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
            getScreenShot(driver,elementName,logger);
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
            getScreenShot(driver,elementName,logger);
        }//end of capture text exception
    }//end of captureTextMethod

    //create a submit method
    public static void submitAction(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of submit


    //create a getText method
    public static String getTextAction(WebDriver driver,WebElement xpath,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            result = element.getText();
            logger.log(LogStatus.PASS,"successfully able to get the text of user value " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to capture text of element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
        return result;
    }//end of getTextAction method

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method



}//end of class




