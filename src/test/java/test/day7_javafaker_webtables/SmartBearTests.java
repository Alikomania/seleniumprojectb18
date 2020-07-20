package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }



    @BeforeMethod
    public void setUp(){

        // TC #1: Smartbear software link verification
        // 1. Open browser
        // 2. Go to website:
        // http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        SmartBearUtilities.login(driver);

    }

    @Test
    public void p1_smartBear_login_test(){

        // 6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
    // List<WebElement> allLinks = driver.findElements(By.tagName("a")); => We can use this locator as well

    //    System.out.println("Number of the links: " + allLinks.size());

        int expectedNumberOfLinks = 6;
        int actualNumberOfLinks = allLinks.size();

        Assert.assertEquals(actualNumberOfLinks, expectedNumberOfLinks);

        // 7. Print out each link text on this page
        for (WebElement eachLink : allLinks){
            System.out.println(eachLink.getText());
        }

    }

    @Test
    public void p2_smartBear_order_placing() throws InterruptedException {
        //TC#2: Smartbear software order placing
        // 1. Open browser
        // 2. Go to website:
        // http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        // 3. Enter username: “Tester”
        // 4. Enter password: “test”
        // 5. Click on Login button


        // 6. Click on Order
       //WebElement orderLink = driver.findElements(By.xpath("//a[.='Order']"));
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        // 7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        Thread.sleep(1000);
        quantityInput.sendKeys(Keys.BACK_SPACE);

        quantityInput.sendKeys("2");

        // 8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        // 9. Fill address Info with JavaFaker • Generate:
        // name, street, city, state, zip code
        Faker faker = new Faker();

        //String firstName = faker.name().firstName();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().firstName());

        //String streetAddress = faker.address().streetAddress();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetAddress());

        //String city = faker.address().city();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());

        //String state = faker.address().state();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());

        String zipCode = faker.address().zipCode().replaceAll("-", "");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipCode);


        // 10. Click on “visa” radio button
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        // 11. Generate card number using JavaFaker
        String cardNumber = faker.finance().creditCard().replaceAll("-", "");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber);

     //   Date expireDate = faker.date().future(01/21, TimeUnit)

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/25");

        // 12. Click on “Process”
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        // 13. Verify success message “New order has been successfully added.”
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));

        Assert.assertTrue(successMessage.isDisplayed());

    }

    @Test
    public void p3_smartBear_order_verification(){
        // TC#3: Smartbear software order verification
        // 1. Open browser and login to Smartbear software
        // 2. Click on View all orders
        // 3. Verify Susan McLaren has order on date “01/05/2010”

        WebElement verifySusan = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate = "01/05/2010";
        String actualDate = verifySusan.getText();
        Assert.assertEquals(actualDate, expectedDate);

    //    Assert.assertTrue(verifySusan.getText().equals("01/05/2010"));

    }


}
