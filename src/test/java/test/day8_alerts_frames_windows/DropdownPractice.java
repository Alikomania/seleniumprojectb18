package test.day8_alerts_frames_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractice {

    WebDriver driver;


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @BeforeClass
    public void setUp() {

        // TC#7: Cybertek “month” dropdown default value
        //    1. Open browser
        //    2. Go to website: http://practice.cybertekschool.com/dropdowns
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    /*

    3. Verify default value is always showing the current month
    o Expected: If currently in June, should show June selected.

     */

    @Test
    public void p7_month_dropdown_default_value_test(){
        // Location the dropdown
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
                                            // => //select[@id='month']
        // We need to create our actual and expected values
        String actualDropdown = monthDropdown.getFirstSelectedOption().getText();
        System.out.println("actualDropdown: " + actualDropdown);

        String expectedDropdown = LocalDateTime.now().getMonth().name();

        System.out.println("expectedDropdown: " + expectedDropdown);

        // 1st way
        Assert.assertEquals(actualDropdown.toLowerCase(), expectedDropdown.toLowerCase());

        // 2nd way
        Assert.assertTrue(actualDropdown.equalsIgnoreCase(expectedDropdown));

        System.out.println("==========================================");

        // PRACTICE #8:
        // 1. Do both verifications in the same test
        // 2. Verify list of months are correct as expected.
        // o Expected:
        // Options should contain all 12 months of the year.

        List<WebElement> actualDropdownOptions = monthDropdown.getOptions();

        List<String> expectedDropdownOptions = Arrays.asList("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December");


        List<String> actualMonthText = new ArrayList<>();

        for (WebElement each : actualDropdownOptions){
            actualMonthText.add(each.getText());
        }

        Assert.assertEquals(actualMonthText, expectedDropdownOptions );




    }

}
