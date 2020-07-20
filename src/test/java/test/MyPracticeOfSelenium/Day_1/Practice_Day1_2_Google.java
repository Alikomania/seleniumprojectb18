package test.MyPracticeOfSelenium.Day_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Day1_2_Google {
    /*
    TC	#1:	Google	Title	Verification
    1.Open	Chrome	browser
    Set up my webDriver
    WebDriverManager.chromedriver().setup();
    2.Go	to	https://www.google.com
    3.Verify	title:	Expected:	Google
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Google verification is PASSED");
        } else {
            System.out.println("Google verification is FAILED!!");
        }

        Thread.sleep(10000);

        driver.close();





    }

}
