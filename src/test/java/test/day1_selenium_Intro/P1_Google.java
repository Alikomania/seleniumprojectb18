package test.day1_selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class P1_Google {
    /*
    TC	#1:	Google	Title	Verification
    1.Open	Chrome	browser
    Set up my webDriver
    WebDriverManager.chromedriver().setup();
    2.Go	to	https://www.google.com
    3.Verify	title:	Expected:	Google

    TC	#2:	Cybertek	verifications
    1.Open	Chrome	browser
    2.Go	to	https://practice.cybertekschool.com
    3.Verify	URL	containsExpected:	cybertekschool
    4.Verify	title:	Expected:	Practice
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification PASSED!");
        } else {
            System.out.println("Google title verification FAILED!!!");
        }



    }
}

