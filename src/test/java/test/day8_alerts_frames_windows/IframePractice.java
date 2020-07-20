package test.day8_alerts_frames_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class IframePractice {

    WebDriver driver;


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @BeforeMethod
    public void setUp(){

        // TC #4 : Iframe practice
        //
        //1. Create a new class called: IframePractice
        // 2. Create new test and make set ups
        // 3. Go to: http://practice.cybertekschool.com/iframe

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //    SmartBearUtilities.login(driver);

    }

    @Test
    public void iframe_practice_test(){

        // 1st way: Locating iframe as web element then switching to it
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        //switching to iframe using webElement
        // driver.switchTo().frame(iframe);

        //switching to iframe using indexes
        // driver.switchTo().frame(0);

        // switching to iframe using name or id
        driver.switchTo().frame("mce_0_ifr");


        // 4. Assert: “Your content goes here.” Text is displayed.
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        // WE HAVE TO SWITCH BACK TO DEFAULT HTML TO BE ABLE TO LOCATE ANYTHING IN THERE
        driver.switchTo().parentFrame();

        // 5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        WebElement h3Text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(h3Text.isDisplayed());




    }

}
