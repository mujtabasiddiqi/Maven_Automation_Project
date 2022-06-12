package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Exception_MortgageCalc {
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

        //navigate to mortgage calculator
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(3000);

        //handle exception for purchase price
        try{
            WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
            pPrice.clear();
            pPrice.sendKeys("450000");
        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate purchase price " + e);
        }//end of purchase price exception

        //handle exception for show advance option button
        try{
            driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate Show Advance Options button " + e);
        }//end of Show advanced options exception

        //handle exception for start month drop down
        try{
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select dropdown = new Select(startMonth);
            dropdown.selectByVisibleText("Jun");
        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate Start Month dropdown " + e);
        }//end of start month exception


        //handle exception for calculate button
        try{
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();
        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate Calculate button " + e);
        }//end of calculate exception

        Thread.sleep(3000);
        //handle exception for monthly payment
        try{
            String mntPayment = driver.findElements(By.xpath("//div[@style='font-size: 32px']")).get(0).getText();
            System.out.println("Monthly payment is " + mntPayment);
        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate monthly payment text " + e);
        }//end of monthly payment exception




    }//end of main
}//end of class
