package test.MyPracticeOfSelenium.Day_1;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice_Day1_3_Cybertek {
    /*
    TC	#2:	Cybertek	verifications
    1.Open	Chrome	browser
    2.Go	to	https://practice.cybertekschool.com
    3.Verify	URL	containsExpected:	cybertekschool
    4.Verify	title:	Expected:	Practice
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.firefox.com");

        Thread.sleep(2000);

        driver.navigate().to("https://practice.cybertekschool.com");

        String currentUrl = driver.getCurrentUrl();
        String expectedURL = "cybertekschool";

        if (currentUrl.contains(expectedURL)){
            System.out.println("URL verification is PASSED");
        } else {
            System.out.println("URL verification is FAILED!!");
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Cybertek verification is PASSED");
        } else {
            System.out.println("Cybertek verification is FAILED!!");
        }

        Thread.sleep(5000);
        driver.close();




    }
}
