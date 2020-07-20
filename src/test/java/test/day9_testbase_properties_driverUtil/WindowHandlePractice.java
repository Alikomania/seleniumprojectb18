package test.day9_testbase_properties_driverUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlePractice extends TestBase {


    @Test
    public void multiple_window_test(){
        // TC-WarmUp # : Window Handle practice
        //1. Create a new class called: WindowHandleWarmup
        // 2. Create new test and make set ups
        // 3. Go to : https://www.amazon.com
        // 4. Copy paste the lines from below into your class
        // 5. Create a logic to switch to the tab where Etsy.com is open
        // 6. Assert: Title contains “Etsy”
        //Lines to be pasted:
        // ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        // ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        // ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        //These lines will simple open new tabs using something called JavaScriptExecut and get those pages.
        // We will learn JavaScriptExecutor later as well.

        driver.get("https://www.amazon.com");

        String mainHandle = driver.getWindowHandle();
        System.out.println("Main handle: "+ mainHandle);

        // we are downCasting our driver to JavascriptExecutor to be able to use its methods.
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
         ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
         ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //5. Create a logic to switch to the tab where Etsy.com is open
        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles){
            driver.switchTo().window(each);
            System.out.println("Current title: " + driver.getTitle());

            if (driver.getCurrentUrl().contains("etsy")){

                // 6. Assert: Title contains “Etsy”
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }



    }


}
