package page.dershane;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class dershanePage {
    public dershanePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @AfterClass
    public void bekleKapat() {
        ReusableMethods.waitFor(5);
        Driver.teardown();
    }

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userNameInput;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//*[@class='btn btn-primary btn-block']")
    public WebElement stoysButton;
    @FindBy(xpath = "//*[@class='user-name font-weight-bolder']")
    public WebElement dropdownButton;
    @FindBy(xpath = "(//*[@class='dropdown-item'])[6]")
    public WebElement cıkısButton;
    @FindBy(xpath = "//*[text()='Dersler']")
    public WebElement derslerButton;
    @FindBy(xpath = "//*[text()='Konu Materyali']")
    public WebElement konuButton;

    //youtube
    @FindBy(xpath = "//*[@class='ytp-play-button ytp-button']")
    public static WebElement playButton;


    public void loginOl() {
        Driver.getDriver().get(ConfigurationReader.getProperty("dershaneUrl"));
        userNameInput.sendKeys("ibrahim.vesek");
        passwordInput.sendKeys("Vesek.101");
        stoysButton.click();
    }


    public void nameVerify() {
        loginOl();
        if (dropdownButton.getText().equals("İBRAHİM VESEK")) {
            System.out.println("ibrahim vesek login oldu");
        } else {
            System.out.println("kullanıcı değiştirilecek.");
        }
    }

    public void nameVerify_Cikis() {
        loginOl();
        if (dropdownButton.getText().contains("İBRAHİM VESEK")) {
            dropdownButton.click();
            cıkısButton.click();
        } else {
            System.out.println("kullanıcı değiştirilecek.");
        }
    }

    public void derslerClick() {
        if (dropdownButton.getText().contains("İBRAHİM VESEK")) {
            ReusableMethods.clickButtonWithJSE(derslerButton, Driver.getDriver());
        } else {
            System.out.println("kullanıcı değiştirilecek.");
        }
    }

    public void konuClick() {
        if (dropdownButton.getText().contains("İBRAHİM VESEK")) {
            konuButton.click();
        } else {
            System.out.println("kullanıcı değiştirilecek.");
        }
    }

    public void negativeDatalarlaLoginOl() {
        Driver.getDriver().get(ConfigurationReader.getProperty("dershaneUrl"));
        userNameInput.sendKeys("ibrahim.vesek");
        passwordInput.sendKeys("Vesek");
        stoysButton.click();
        dropdownButton.getText().contains("İBRAHİM VESEK");
    }

    public void nameVerifyAssert() {
        Assert.assertTrue(dropdownButton.getText().contains("İBRAHİM VESEK"));
    }
}
