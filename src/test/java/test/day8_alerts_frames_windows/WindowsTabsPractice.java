package test.day8_alerts_frames_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {

    WebDriver driver;


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @BeforeMethod
    public void setUp() {

       // TC	#	:	Window	Handle	practice
        //1. Create	a	new	class	called:	WindowHandlePractice
        // 2. Create	new	test	and	make	set	ups
        // 3. Go	to	:	http://practice.cybertekschool.com/windows

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void p5_window_handle_practice(){
        // 4. Assert:	Title	is	“Practice”
        // 5. Click	to:	“Click	Here”	text
        // 6. Switch	to	new	Window.
        // 7. Assert:	Title	is	“New	Window

        String currentWindowHandle = driver.getWindowHandle();

        System.out.println("currentWindowHandle: " + currentWindowHandle);

        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
                                                //  (By.linkText("Click Here"));
        System.out.println("BEFORE CLICKING: " + driver.getTitle());

        clickHereLink.click();

        System.out.println("AFTER CLICKING: " + driver.getTitle());

        // driver.getWindowHandles() => returns us A SET of String

        Set<String> windowHandles = driver.getWindowHandles();


        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println(driver.getTitle());
            }

        }






    }


