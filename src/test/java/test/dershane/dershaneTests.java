package test.dershane;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.annotations.Test;
import page.dershane.dershanePage;

public class dershaneTests {
    dershanePage dp = new dershanePage();

    @Test
    public void loginOlTest() {
        dp.loginOl();
    }


    @Test
    public void negatifSenaryoLoginOlTest() {
        dp.negativeDatalarlaLoginOl();

    }

    @Test
    public void derslerClickTest() {
        dp.loginOl();
        dp.derslerClick();
    }



    @Test
    public void nameVerifyTest() {
        dp.loginOl();
        dp.nameVerify();
    }

    @Test
    public void nameVerifyTest01() {
        dp.loginOl();
        dp.nameVerify_Cikis();
    }


    @Test
    public void konuClickTest() {
        dp.loginOl();
        ReusableMethods.clickButtonWithJSE(dp.derslerButton, Driver.getDriver());
        dp.konuClick();
    }

}
