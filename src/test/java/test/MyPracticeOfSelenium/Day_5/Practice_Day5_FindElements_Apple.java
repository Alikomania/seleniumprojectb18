package test.MyPracticeOfSelenium.Day_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class Practice_Day5_FindElements_Apple {
    /*
    #03: FINDELEMENTS_APPLE
    1.Open Chrome browser
    2.Go to https://www.apple.com
    3.Click to all of the headers one by one.
    Mac, iPad, iPhone, Watch, TV, Music, Support
    4.Printout how many links on each page with the titles of the pages
    5.Loop through all
    6.Print out how many link is missing textTOTAL
    7.Print out how many link has textTOTAL
    8.Print out how many total linkTOTAL
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");

        WebElement Mac = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
        Mac.click();


        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        int linksWithoutText = 0;
        int linksWithText = 0;
        for (WebElement each : allLinks){
            String textOfLinks = each.getText();
            System.out.println(textOfLinks);
            if(textOfLinks.isEmpty()){
                linksWithoutText++;
            }else{
                linksWithText++;
            }
        }
        //5. Print out how many link is missing text
        System.out.println("Number of links without texts ===> " + linksWithoutText);
        //6. Print out how many link has text
        System.out.println("Number of links with texts ===>" + linksWithText);
        //7. Print out how many total link
        System.out.println("Number of TOTAL LINKS ===> " + allLinks.size());

        driver.quit();
    }



    }

