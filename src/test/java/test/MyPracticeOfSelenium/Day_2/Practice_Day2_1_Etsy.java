package test.MyPracticeOfSelenium.Day_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Day2_1_Etsy {
    // TC #1: EtsyTitle Verification
    // 1.Open Chrome browser
    // 2.Go to https://www.etsy.com
    // 3.Search for “wooden spoon”
    // 4.Verify title:
    // Expected: “Wooden spoon | Etsy”

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

    //    driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]")).sendKeys("wooden spoon" + Keys.ENTER);

    //    driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon");

        driver.findElement(By.name("search_query")).sendKeys("wooden spoon");
        driver.findElement(By.className("wt-input-btn-group__btn")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy";

        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Verification is PASSED!");
        } else {
            System.out.println("Verification is FAILED!!");
        }

        Thread.sleep(5000);
        driver.close();




    }

}
