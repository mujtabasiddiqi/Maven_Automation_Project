package Day9_052322;

import ReuseableLibraries.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ReuseableLibraries.Reusable_Actions.clickAction;

public class USPS_reusable_concepts {
    public static void main(String[] args) {

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //hovering to the quick tools
        Reusable_Actions.mouseHover(driver,"//*[text()='Quick Tools']","Quick Tools");

        //hover to send tab
        Reusable_Actions.mouseHover(driver,"//*[@id='mail-ship-width']","Send Tab");

        //click on calculate a price
        clickAction(driver,"//*[@class='tool-calc']","Calculate a Price");

        //enter the zip code
        Reusable_Actions.sendKeysAction(driver,"//*[@id='Origin']","11218","Zip Code");

        //print out header text info

    }//end of main
}//end of class
