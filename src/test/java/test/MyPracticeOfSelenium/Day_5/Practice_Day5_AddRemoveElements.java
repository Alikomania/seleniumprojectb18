package test.MyPracticeOfSelenium.Day_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Practice_Day5_AddRemoveElements {
    /*
    XPATH PRACTICES DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.
5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
Hint: Need to use findElements method.
   */

    public static void main(String[] args) throws InterruptedException {

        // 1 & 2 =>
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        Thread.sleep(2000);

        // 3 =>
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 1; i <= 50; i++){
            addElementButton.click();
        } // <button onclick="addElement()">Add Element</button>


        // 4 =>
        WebElement DeleteButton = driver.findElement(By.id("elements"));

            int count = 1;
                for (int i = 1; i <= 50; i++) {
                    DeleteButton.isDisplayed();
                    count++;
                }

             if (count == 50){
                 System.out.println("All delete button is displayed. PASSED!!");
            } else {
                System.out.println("All delete button is NOT displayed. FAILED!!");
            }

             // 5 =>
             for (int z = 50; z > 0; z--){
                 DeleteButton.click();
             }

             // 6 =>
             if (!DeleteButton.isDisplayed()){
                 System.out.println("Any delete button is NOT displayed. PASSED!");
             } else {
                 System.out.println("One or more delete button is displayed. FAILED!!");
             }




















        }






    }


