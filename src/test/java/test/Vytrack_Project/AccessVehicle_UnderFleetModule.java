package test.Vytrack_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class AccessVehicle_UnderFleetModule {


    @Test
    public void AccessVehicle() throws InterruptedException {


        Driver.getDriver().get("https://qa2.vytrack.com/user/login");

        WebElement enterUsername = Driver.getDriver().findElement(By.id("prependedInput"));
        enterUsername.sendKeys("user16");
        WebElement enterPassword = Driver.getDriver().findElement(By.id("prependedInput2"));
        enterPassword.sendKeys("UserUser123");

        WebElement clickLoginButton = Driver.getDriver().findElement(By.id("_submit"));
        clickLoginButton.click();

        WebElement clickFleetButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        clickFleetButton.click();

        /*
        WebElement clickVehicles = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span"));
        clickVehicles.click();

         */

        Actions actions = new Actions(Driver.getDriver());

        // locating the web element we want to scroll to
        WebElement VehiclesLink = Driver.getDriver().findElement(By.linkText("Vehicles"));

        Thread.sleep(2000);
        //using actions instance we use moveToElement method
        actions.moveToElement(VehiclesLink).click().perform();


    }

}
