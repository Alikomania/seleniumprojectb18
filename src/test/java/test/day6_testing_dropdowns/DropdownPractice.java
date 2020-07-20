package test.day6_testing_dropdowns;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.WebDriverFactory;

public class DropdownPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));

        select.selectByVisibleText("Option 1");

        Thread.sleep(1000);

        select.selectByIndex(2);

    //    select.getAllSelectedOptions();


        Thread.sleep(1500);
        driver.close();



    }




}
