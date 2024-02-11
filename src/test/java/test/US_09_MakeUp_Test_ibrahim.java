package test;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage_ibrahim;


public class US_09_MakeUp_Test_ibrahim extends HomePage_ibrahim {

    @Test
    public void MakeUpSearch() {
        gotoPickbazar();

        groceryButton.click();
        makeUp.click();
        ReusableMethods.waitFor(2);
        String firstProductNameStr = firstProductName.getText();
        search.sendKeys(firstProductNameStr + Keys.ENTER);
        ReusableMethods.waitFor(2);

        Assert.assertTrue(firstProductNameAfter.getText().contains(firstProductNameStr));

        Driver.getDriver().close();
        Driver.getDriver().quit();
    }
}
