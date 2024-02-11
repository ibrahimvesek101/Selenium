package page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class HomePageBase {

    public HomePageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a/span[text()]")
    List<WebElement> categories;
    @FindBy(tagName = "button")
    WebElement categoryButton;
    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    public WebElement searchBar;
    @FindBy(xpath = "//a[.='FAQ']")
    public WebElement faqButton;
    @FindBy(xpath = "//a[.='Shops']")
    public WebElement shopsButton;
    @FindBy(xpath = "//a[.='Offers']")
    public WebElement offersButton;
    @FindBy(xpath = "//a[.='Contact']")
    public WebElement contactButton;
    @FindBy(xpath = "//a[.='Become a Seller']")
    public WebElement becomeSellerButton;
    @FindBy(xpath = "//button[.='user avatar']")
    public WebElement profileButton;
    @FindBy(xpath = "(//ul)[2]//li/button")
    public List<WebElement> userMenu;

    public void click(WebElement element){
        ReusableMethods.waitFor(2);
        ReusableMethods.waitToBeClickable(element,15).click();
    }

    public void navigateToUserMenu(String section) {
        ReusableMethods.waitForVisibility(profileButton, 3).click();
        for (WebElement menuSection : userMenu) {
            if (menuSection.getText().equalsIgnoreCase(section)) {
                ReusableMethods.waitToBeClickable(menuSection, 2).click();
                ReusableMethods.waitFor(2);
                break;
            }
        }

    }
    public void navigateToCategory(String section) {

        ReusableMethods.waitForVisibility(categoryButton, 3).click();
        for (WebElement category : categories) {
            if (category.getText().equalsIgnoreCase(section)) {
                ReusableMethods.waitToBeClickable(category, 2).click();
                ReusableMethods.waitFor(2);
                break;
            }
        }
    }

    public void waitClickOnButton(WebElement element) {
        ReusableMethods.waitToBeClickable(element, 15).click();

    }


}



