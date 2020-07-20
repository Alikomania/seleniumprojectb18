package test.MyPracticeOfSelenium.Day_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Day2_3_GoogleTitle {
    //TC #4: Google search
    //1- Open a chrome browser
    //2- Go to: https://google.com
    //3- Write “apple” in search box
    //4- Click google search button
    //5- Verify title:
    //Expected: Title should start with “apple” word

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("apple" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "apple";

        if (actualTitle.startsWith(expectedTitle)){
            System.out.println("Apple title verification is PASSED!");
        } else {
            System.out.println("Apple title verification is FAILED!!");
        }




    }
}
