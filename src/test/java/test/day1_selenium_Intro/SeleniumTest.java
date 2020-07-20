package test.day1_selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        // 1- setup the webDriver
        WebDriverManager.chromedriver().setup();
        // 2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 3- test if driver is working
        driver.get("https://www.google.com");

        System.out.println("driver.getTitle() --> "+driver.getTitle());
        System.out.println("driver.getCurrentUrl --> "+driver.getCurrentUrl());

        // BROWSER NAVIGATION
        // this line will take user to the previous page
        Thread.sleep(2000); // this line adds 2000 milliseconds of wait = 2 seconds
        driver.navigate().back();

        // Thread.sleep is being added just to be able to see selenium movements
        Thread.sleep(2000);
        driver.navigate().forward(); // This line will go to next page

        Thread.sleep(2000);
        driver.navigate().refresh(); // This line will refresh the page

        driver.navigate().to("https://www.facebook.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getPageSource());






    }
}

