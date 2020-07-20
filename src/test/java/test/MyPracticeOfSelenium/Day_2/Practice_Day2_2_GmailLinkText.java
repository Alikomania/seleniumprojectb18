package test.MyPracticeOfSelenium.Day_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Day2_2_GmailLinkText {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.linkText("Gmail")).click();

        String actualGmailTitle = driver.getTitle();
        String expectedInTitle = "Gmail";

        if (actualGmailTitle.contains(expectedInTitle)){
            System.out.println("Gmail title verification is PASSED!");
        } else {
            System.out.println("Gmail title verification is FAILED!!");
        }

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().refresh();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Google title verification is PASSED!");
        } else {
            System.out.println("Google title verification is FAILED!!");
        }

        Thread.sleep(3000);
        driver.close();




    }
}
