package page;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage_ibrahim {

    public HomePage_ibrahim() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='whitespace-nowrap'])[1]")
    public WebElement groceryButton;
    @FindBy(xpath = "//span[.='Makeup']")
    public WebElement makeUp;

    @FindBy(xpath = "//input[@id='search']")
    public WebElement search;
    @FindBy(xpath = "(//*[@class='mb-2 truncate text-sm font-semibold text-heading'])[3]")
    public WebElement firstProductName;
    @FindBy(xpath = "(//*[@class='mb-2 truncate text-sm font-semibold text-heading'])[1]")
    public WebElement firstProductNameAfter;


    public void gotoPickbazar() {
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
    }

}
