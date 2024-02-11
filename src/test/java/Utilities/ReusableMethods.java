package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;


public class ReusableMethods {

    static Actions actions = new Actions(Driver.getDriver());

    //-----------------ACTIONS----------------//
    public static void actionClick(WebElement element) {
        actions.click(element).perform();
    }

    public static void copyText(WebElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a")); /*Select all */
        element.sendKeys(Keys.chord(Keys.CONTROL, "c")); /* Copy text*/
    }

    public static void pasteText(WebElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "v")+Keys.ENTER); // Paste
    }

    public static void moveToElement(WebElement element) {   /*Scroll to Element*/
        actions.moveToElement(element).perform();
    }

    public static void moveAndClick(WebElement element) {   /*Scroll & Click to Element*/
        actions.moveToElement(element).click().perform();
    }
    //--------------JSE--------------------//
    public static void clickButtonWithJSE(WebElement element, WebDriver driver){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void sendKeysWithJSE(WebElement element, WebDriver driver,String textToSend){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = arguments[1]", element, textToSend);
    }

    //------------------HARD WAIT------------------//
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //--------------Explicit Waits--------------//
    public static void waitForLoad(int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static List<WebElement> waitForVisibilityList(List<WebElement> element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static WebElement waitToBeClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        actions.moveToElement(element).perform();
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void enterTextAndWait(WebElement element, String text, int timeout) {
        element.clear();
        ReusableMethods.waitFor(timeout);
        element.sendKeys(text);
    }
    public static void waitToBeClickableBy(By seletor, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));

        wait.until(ExpectedConditions.elementToBeClickable(seletor)).click();
    }

    //-----------------SendKeys----------------//
    public static void sendData(WebElement element, String key) {
        element.clear();
        element.sendKeys(key + Keys.ENTER);

    }

    //--------------------SWITCH TO WINDOW----------------//
    public static void switchToNewWindow(WebDriver driver, WebElement element) {
        String mainWindow = driver.getWindowHandle();
        element.click();
        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    //--------------SCREENSHOT---------------//
    public static String getScreenshot(WebDriver driver, String name) throws IOException {
        waitFor(1);

        String date = formatCurrentDate("yyyy_MM_dd&hh_mm_ss");


        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);



        // Kaydedilecek dosyanin yolunu belirliyoruz

        String separator = System.getProperty("file.separator");
        String target = "."+separator+"test-output"+separator+"screenshots"+separator+"screenshot " + name + date + ".png";


        File targetFile = new File(target);

        FileUtils.copyFile(source, targetFile);

        return target;

    }

    //-----------------FORMATTER--------------//
    public static int formatNumber(String str){
        String str2 =str.replaceAll("\\..*", "");
      return Integer.parseInt(str2.replaceAll("\\D+", ""));
    }

    public static String formatCurrentDate(String pattern) {

        return new SimpleDateFormat(pattern).format(new Date());

    }

}
