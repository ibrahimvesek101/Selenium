package test.dershane;

import org.testng.annotations.Test;
import page.dershane.dershanePage;

public class test {
    dershanePage dp = new dershanePage();
    @Test
    public void loginOlTest() {
        dp.loginOl();
    }
}