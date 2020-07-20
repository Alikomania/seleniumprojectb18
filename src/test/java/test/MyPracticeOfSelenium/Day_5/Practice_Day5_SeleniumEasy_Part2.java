package test.MyPracticeOfSelenium.Day_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Practice_Day5_SeleniumEasy_Part2 {

    /*
    TC	#3:	SeleniumEasy	Checkbox	Verification	–	Section	2
    1. Open	Chrome	browser
    2. Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    3. Verify	“Check	All”	button	text	is	“Check	All”
    4. Click	to	“Check	All”	button
    5. Verify	all	check	boxes	are	checked
    6. Verify	button	text	changed	to	“Uncheck	All”
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement actualCheckAllButton = driver.findElement(By.xpath("//*[@id=\"check1\"]"));

        String expectedButtonText = "Check All";
        String actualButtonText = actualCheckAllButton.getAttribute("value");


        if (actualButtonText.equals(expectedButtonText)){
            System.out.println("Default Check All Button text PASSED!");
        } else {
            System.out.println("Default Check All Button text FAILED!!!");
        }

         actualCheckAllButton.click();

        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input"));
        WebElement checkBox3 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input"));
        WebElement checkBox4 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input"));

        if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()){
            System.out.println("All CheckBoxes are Selected PASSED!");
        } else {
            System.out.println("All CheckBoxes are Selected FAILED!!!");
        }

        WebElement UncheckedAllButton = driver.findElement(By.xpath("//*[@id=\"check1\"]"));

        String actualUncheckedText = UncheckedAllButton.getAttribute("value");
        String expectedUncheckedText = "Uncheck All";

        if (actualUncheckedText.equalsIgnoreCase(expectedUncheckedText)){
            System.out.println("Unchecked Button text is PASSED!");
        } else {
            System.out.println("Unchecked Button text is FAILED!!");
        }

        Thread.sleep(5000);
        driver.close();





    }

}
