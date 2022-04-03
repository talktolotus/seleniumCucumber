package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonLibrary;

public class HomePage{
    //createa constructor
    public HomePage(WebDriver driver)
    {
        PageFactory.initElements();
    }


  //  driver.
    @FindBy(id=" ")
    public WebElement searchField;
@FindBy(xpath = " ")
public WebElement myAccountLink;

    @FindBy(xpath = " ")
    public WebElement flagContainer;

    public void searchAnItem(String Keyword){
        searchField.sendKeys(Keyword);
    }

    public void clickMyAccountLink()
    {
        myAccountLink.click();

    }

    public void clickOnCookie()
    {
        clickOnCookie.
    }


}
