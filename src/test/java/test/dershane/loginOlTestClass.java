package test.dershane;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.annotations.Test;
import page.dershane.dershanePage;

public class loginOlTestClass {
    dershanePage dp = new dershanePage();

    @Test
    public void loginOlTest() {
        dp.loginOl();
        dp.dropdownButton.click();
        dp.cıkısButton.click();
    }

    @Test
    public void nameVerifyTest() {

        dp.nameVerifyAssert();
        dp.dropdownButton.click();
        dp.cıkısButton.click();
    }
}