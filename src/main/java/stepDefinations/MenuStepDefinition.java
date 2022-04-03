package stepDefinations;
//write actual test steps

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import utility.CommonLibrary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//consider given,when,and then as main
//aquiring the CommonLibrary class driver
public class MenuStepDefinition extends CommonLibrary {

HomePage homePage=
    @Given("I am on the homepage {string}")
    public void i_am_on_the_homepage(String url) throws IOException {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Assert the title, we need to keep the url
        String expectedUrl = getProperties("url");
        String actualUrl = driver.getCurrentUrl();//getting the url from the actual file
        Assert.assertEquals(expectedUrl, actualUrl);//always it starts with expectedUrl
        WebElement cookieButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookieButton.click();

    }

    @When("I hover over the menu option {string}")
    public void i_hover_over_the_menu_option(String menuText) {

        WebElement menu = driver.findElement(By.xpath("//span[text()='" + menuText + "']"));//more generic
        //creating new Action class obj to perform mouse hover
        Actions mouseHover = new Actions((driver));//pass the driver obj
        //except scroll we can do all mouse operations
        mouseHover.moveToElement(menu).build().perform();//pass a webelement.it will bring mouse focus and put it on the element we are passing that is menu
        //wait

    }

    @And("I click the link {string}")
    public void i_click_the_link(String menuText) throws IOException {
        WebElement menu = driver.findElement(By.xpath("//span[text()='" + menuText + "']"));
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        webDriverWait.until(ExpectedConditions.visibilityOf(menu));
        menu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//*[@id=\"NI3\"][@title='All Clothing']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String fileName = "/" + menuText + ".png";
        takeScreenshots(fileName);
    }

    @Then("I should navigate to the screen {string}")
    public void i_should_navigate_to_the_screen(String pageTitle) {
        String actualTitle = driver.getTitle();
        String expectedTitle = pageTitle;
        System.out.println("Actual title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


}
