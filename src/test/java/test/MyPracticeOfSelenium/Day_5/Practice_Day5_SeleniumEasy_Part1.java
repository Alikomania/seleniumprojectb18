package test.MyPracticeOfSelenium.Day_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Practice_Day5_SeleniumEasy_Part1 {
    /*
    TC	#2:	SeleniumEasy	Checkbox	Verification	–	Section	1
    1. Open	Chrome	browser
    2. Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    3. Verify	“Success	–	Check	box	is	checked”	message	is	NOT	displayed.
    4. Click	to	checkbox	under	“Single	Checkbox	Demo”	section
    5. Verify	“Success	–	Check	box	is	checked”	message	is	displayed.

     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement successCheckBox = driver.findElement(By.xpath("//*[@id=\"isAgeSelected\"]"));
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"txtAge\"]"));

        if (! (successCheckBox.isSelected() && successMessage.isDisplayed())){
            System.out.println("Default value verification PASSED!");
        } else {
            System.out.println("Default value verification FAILED!!");
        }

        Thread.sleep(1000);
        successCheckBox.click();

        if (successCheckBox.isSelected() && successMessage.isDisplayed()){
            System.out.println("Success message is displayed! PASS!");
        } else {
            System.out.println("Success message is NOT displayed! FAILED!");
        }



    }





}
