package Action_Item;

import ReuseableLibraries.Reusable_Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Automation_AI06 {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //navigate to uhc website
        driver.navigate().to("https://www.uhc.com");
        Thread.sleep(2000);

        //verify the title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Health insurance plans for individuals & families, employers, medicare | UnitedHealthcare";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass; My title matches");
        }else {
            System.out.println("Fail; Title doesn't match " + actualTitle);
        }

        //click on find a doctor
        try {
            WebElement  FindaDoctor = driver.findElement(By.xpath("//*[@href='/find-a-doctor']"));
            FindaDoctor.click();
        } catch (Exception e) {
            System.out.println("unable to click on it" + e);
        }//end of find a doctor exception

        //click on sign in
        try {
            WebElement signIn = driver.findElement(By.xpath("//*[@aria-label='Sign in menu']"));
            signIn.click();
        } catch (Exception e) {
            System.out.println("unable to click on it" + e);
        }//end of sign in exception

        //click on medicare plan?
        try {
            WebElement medicarePlan = driver.findElement(By.xpath("//*[text()='Medicare plan?']"));
            Thread.sleep(3000);
            medicarePlan.click();
        } catch (Exception e) {
            System.out.println("unable to click on it" + e);
        }//end of medicare plan exception

        //switch to the new tab
        try {
            //we store newly open tabs in an arrylis
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            //switch to new tab it should be at index 1
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);
            //click on register now
            WebElement RegisterNow = driver.findElement(By.xpath("//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']"));
            RegisterNow.click();
        } catch (Exception e) {
            System.out.println("unable to switch to new tab " + e);
        }//end of switch tab exception

        //enter first name
        try {
            //we use following syntax to define actions
            Actions mouseActions = new Actions(driver);
            //enter first name using sendkeys with some mouse actions
            WebElement firstName = driver.findElement(By.xpath("//*[@name='firstName']"));
            mouseActions.moveToElement(firstName).click().sendKeys("Shafaq").perform();
        } catch (Exception e) {
            System.out.println("unable to enter first name" + e);
        }//end of first name exception

        //enter last name
        try {
         //define actions
         Actions mouseActions = new Actions(driver);
         //enter last name using sendkeys with some mouse actions
         WebElement lastName = driver.findElement(By.xpath("//*[@name='lastName']"));
         mouseActions.moveToElement(lastName).click().sendKeys("Siddiqi").perform();
        } catch (Exception e) {
            System.out.println("unable to enter last name" + e);
        }//end of last name exception

        //enter birth month from drop down
        try {
            //enter birth month from drop down
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='dob_month']"));
            Select dropdown = new Select(startMonth);
            dropdown.selectByVisibleText("August");
        } catch (Exception e) {
            System.out.println("unable to enter birth month" + e);
        }//end of birth month exception

        //enter date of birth in the field
        try {
            //define actions
            Actions mouseActions = new Actions(driver);
            //enter date of birth  using send keys with some mouse actions
            WebElement dateofBirth = driver.findElement(By.xpath("//*[@name='dob_day']"));
            mouseActions.moveToElement(dateofBirth).click().sendKeys("01").perform();
        } catch (Exception e) {
            System.out.println("unable to print birth day" + e);
        }//end of birth Day exception

        //enter year of birth
        try {
            //perform mouse actions
            Actions mouseActions = new Actions(driver);
            //enter year of birth using sendkeys with some mouse actions
            WebElement birthYear = driver.findElement(By.xpath("//*[@name='dob_year']"));
            mouseActions.moveToElement(birthYear).click().sendKeys("1997").perform();
        } catch (Exception e) {
            System.out.println("unable to print birth year" + e);
        }//end of birth year exception

        //enter zipcode
        try {
            //perform some mouse actions
            Actions mouseActions = new Actions(driver);
            //enter zip code using sendkeys with some actions
            WebElement zipCode = driver.findElement(By.xpath("//*[@name='zipCode']"));
            mouseActions.moveToElement(zipCode).click().sendKeys("11746").perform();
        } catch (Exception e) {
            System.out.println("unable to enter zipcode" + e);
        }//end of zip code exception

        //enter member id
        try {
            //define mouse actions
            Actions mouseActions = new Actions(driver);
            //enter member id using sendkeys with some mouse actions
            WebElement memberId = driver.findElement(By.xpath("//*[@name='memberId']"));
            mouseActions.moveToElement(memberId).click().sendKeys("233567").perform();
        } catch (Exception e) {
            System.out.println("unable to enter member id" + e);
        }//end of member id exception

        //click on continue button
        try {
            WebElement clickOncintinue = driver.findElement(By.xpath("//*[@id='submitBtn']"));
            Thread.sleep(1000);
            clickOncintinue.click();
        } catch (Exception e) {
            System.out.println("unable to click on it" + e);
        }//end of click on continue exception

        //capture text for invalid member id
        try {
            //capture text for invalid code/error
            String captureText = driver.findElement(By.xpath("//*[@id='personalInfo_errors']")).getText();
            System.out.println("captured content is " + captureText);
        } catch (Exception e) {
            System.out.println("unable to capture it " + e);
        }//end of capture text exception

        //close the driver
        driver.close();

        //switch to default/parent tab
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
        } catch (Exception e) {
            System.out.println("unable to switch " + e);
        }//end of switch tab exception

    }//end of main
}//end of class
