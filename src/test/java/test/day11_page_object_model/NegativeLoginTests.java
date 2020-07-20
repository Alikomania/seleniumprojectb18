package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import sun.rmi.runtime.Log;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTests {

    LoginPage loginPage;

    @Ignore
    @Test
    public void negative_login_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));

        String username = ConfigurationReader.getProperty("storemanager_username");
        usernameInput.sendKeys(username);

        passwordInput.sendKeys("ladfukjaf;akjf");

        loginButton.click();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        Assert.assertTrue(errorMessage.isDisplayed(), "Assert message is NOT displayed");

    }

    @Test
    public void negative_login_test_with_page_object(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();

        // sending username
        String username = ConfigurationReader.getProperty("storemanager_username");
        loginPage.usernameInput.sendKeys(username);


        // send our incorrect password
       loginPage.passwordInput.sendKeys("ladficdlkajflk");
    // => correct password =>  String password = ConfigurationReader.getProperty("storemanager_password");

        loginPage.loginButton.click();

        //asserting error message IS DISPLAYED
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        // asserting the TEXT VALUE of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void tc31_wrong_username_test(){
        /*
        public void login(String username, String password){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
}
         */

        // TC#31 : Vytrack negative login test à Wrong Username Test
        //1. Go to https://qa3.vytrack.com
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        //2. Enter incorrect username
        loginPage = new LoginPage();

        String username = "something";

        //3. Enter correct password
        String password = ConfigurationReader.getProperty("storemanager_password");

        loginPage.login(username, password);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);









        //4. Verify error message text is as expected
        //Expected: “Invalid user name or password.”
        //Note: Follow Page Object Model design pattern

    }






}
