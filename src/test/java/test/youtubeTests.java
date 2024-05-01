package test;

import Utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import page.dershane.dershanePage;


public class youtubeTests {

    @Test
    public void loginOlTest() throws InterruptedException {
        Driver.getDriver().get("https://www.youtube.com/watch?v=u2jJob5MBP4");
        Driver.getDriver().switchTo().frame(0);
        dershanePage.playButton.click();

    }
     @Test
    public void loginOlTest1() throws InterruptedException {
         Driver.getDriver().get("https://www.youtube.com/watch?v=u2jJob5MBP4");

         // Video tamamen yüklenene kadar birkaç saniye bekleyelim
         try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     }



}
