package Day12_060422;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Annotation_Class;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends Reusable_Annotation_Class {

    @Test
    public void SearchForAKeywordOnGoogleHome(){
        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().searchUserValue("BMW");
        BaseClass.googleHomePage().submitOnGoogleSearch();
    }

    @Test(dependsOnMethods = "SearchForAKeywordOnGoogleHome")
    public void CaptureSearchNumberFromGoogle(){
        BaseClass.googleSearchResultPage().CaptureSearchNumberAndPrintIt();
    }





}//end of class
