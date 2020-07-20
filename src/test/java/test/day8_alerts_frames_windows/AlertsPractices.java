package test.day8_alerts_frames_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {

    WebDriver driver;


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @BeforeMethod
    public void setUp() {

        // TC #1: Information alert practice
        // 1. Open browser
        // 2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        // 3. Click to “Click for JS Alert” button
        // 4. Click to OK button from the alert
        // 5. Verify “You successfully clicked an alert” text is displayed.

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void p1_information_alert_test(){

        // 3. Click to “Click for JS Alert” button
      WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
      infoAlertButton.click();

      // 1- Create the alert instance and switch to it
        Alert alert = driver.switchTo().alert();

        // 2- Use "alert" to accept the alert
        alert.accept();

        // locating result web element
        WebElement resultText = driver.findElement(By.id("result"));
                                         // (By.xpath("//p[@id='result']"))

        // Asserting the result text is displayed
        Assert.assertTrue(resultText.isDisplayed());

    }



    @Test
    public void p2_confirmation_alert_test(){

        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement resultText = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText.isDisplayed());


    }


}

