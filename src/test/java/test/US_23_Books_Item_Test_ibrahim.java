package test;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.BooksPage_ibrahim;
import java.io.IOException;


public class US_23_Books_Item_Test_ibrahim extends BooksPage_ibrahim {

    @Test
    public void test01_ScrollDownAndVerify() throws InterruptedException {

        gotoBooksPage();
        ReusableMethods.waitFor(3);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        boolean end = (boolean) jse.executeScript("return (window.innerHeight + window.scrollY) <= document.body.offsetHeight;");

        while (end) {
            for (int i = 0; i < 100; i++) {
                jse.executeScript("window.scrollBy(0,100);");
                Thread.sleep(50);
            }
            break;
        }

        //sayfasonu doğrulaması
        Assert.assertTrue(end);

        boolean start = (boolean) jse.executeScript("return (window.innerHeight + window.scrollY) == 0");

        while (!start) {
            for (int i = 0; i < 100; i++) {
                jse.executeScript("window.scrollBy(0,-100);");
                Thread.sleep(50);
            }
            break;
        }
        //code sorunsuz sonlanınca sayfa başındayız demektir.
    }

    @Parameters("smoke")
    @Test
    public void test02_ProductDetail() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        String firstProductTitleStr = firstProductTitle.getText();
        firstProductTitle.click();

        ReusableMethods.waitFor(2);

        Assert.assertTrue(firstProductDetailTitle.getText().contains(firstProductTitleStr));

    }

    @Test
    public void test03_ProductTitleVerify() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        String firstProductTitleStr = firstProductTitle.getText();
        firstProductTitle.click();
        ReusableMethods.waitFor(2);

        Assert.assertTrue(firstProductDetailTitle.getText().contains(firstProductTitleStr));

    }

    @Test
    public void test04_PriceVerify() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        String firstProductPriceStr = firstProductPrice.getText();
        firstProductTitle.click();
        ReusableMethods.waitFor(1);

        Assert.assertEquals(firstProductDetailPrice.getText(), firstProductPriceStr);

    }

    @Test
    public void test05_SeeMoreButtonVerify() throws IOException {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        firstProductTitle.click();
        ReusableMethods.waitFor(2);
        seeMoreButton.click();
        ReusableMethods.waitFor(2);

        //sayfasonu(See more) doğrulaması
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        boolean end = (boolean) jsExecutor.executeScript("return (window.innerHeight + window.scrollY) <= document.body.offsetHeight;");

        Assert.assertTrue(end);


        //See Less yok. SS alıyoruz.
        ReusableMethods.getScreenshot(Driver.getDriver(),"_BUG_US_23_SeeLessButonuYok_ibrahim_");


    }

    @Test
    public void test06_ProductQuantity() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        firstProductTitle.click();

        ReusableMethods.waitFor(2);
        int firstProductQuantityInt = Integer.parseInt(firstProductQuantity.getText());
        positiveButton.click();
        ReusableMethods.waitFor(1);
        int thenPressPositiveButtonInt = Integer.parseInt(thenPressPositiveButton.getText());
        Assert.assertEquals(thenPressPositiveButtonInt, firstProductQuantityInt + 1);

        negativeButton.click();
        int thenPressNegativeButtonInt = Integer.parseInt(this.thenPressNegativeButtonInt.getText());
        Assert.assertEquals(thenPressNegativeButtonInt, 1);

    }

    @Test
    public void test07_AddToCartOrderProduct() {


        gotoBooksPage();
        ReusableMethods.waitFor(3);
        firstProductTitle.click();

        loginOl();
        ReusableMethods.waitFor(1);
        addToCartButton.click();
        Item1.click();
        ReusableMethods.waitFor(1);
        checkoutButton.click();
        ReusableMethods.waitFor(1);
        checkAvailabilityButton.click();
        ReusableMethods.waitFor(3);
        cashOnDeliveryButton.click();

        avatarButton.click();
        myOrdersButton.click();
        ReusableMethods.waitFor(3);


        Assert.assertTrue(ordersDetails.isDisplayed());

    }

    @Test
    public void test08_HeartButton() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        firstProductTitle.click();
        ReusableMethods.waitFor(2);

        try {
            joinButton.isDisplayed();
            loginOl();

            ReusableMethods.waitFor(2);
            heartButton.click();
            ReusableMethods.waitFor(2);

            Assert.assertTrue(fullHeart.isDisplayed());

            ReusableMethods.waitFor(2);
            fullHeart.click();
            ReusableMethods.waitFor(2);
            Assert.assertTrue(emptyHeart.isDisplayed());

        } catch (Exception e) {

            ReusableMethods.waitFor(2);
            heartButton.click();
            ReusableMethods.waitFor(2);

            Assert.assertTrue(fullHeart.isDisplayed());

            ReusableMethods.waitFor(2);
            fullHeart.click();
            ReusableMethods.waitFor(3);
            Assert.assertTrue(emptyHeart.isDisplayed());

        }
    }

    @Test
    public void test09_ScrollBar() throws InterruptedException {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        firstProductTitle.click();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        boolean end = (boolean) jse.executeScript("return (window.innerHeight + window.scrollY) <= document.body.offsetHeight;");

        while (end) {
            for (int i = 0; i < 50; i++) {
                jse.executeScript("window.scrollBy(0,100);");
                Thread.sleep(50);
            }
            break;
        }

        //  Details başlığı doğrulanması
        Assert.assertTrue(details.isDisplayed());

        boolean start = (boolean) jse.executeScript("return (window.innerHeight + window.scrollY) == 0");

        while (!start) {
            for (int i = 0; i < 50; i++) {
                jse.executeScript("window.scrollBy(0,-100);");
                Thread.sleep(50);
            }
            break;
        }
    }

    @Test
    public void test10_Recent() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        firstProductTitle.click();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", recent);
        ReusableMethods.waitFor(1);
        recent.click();
        ratingsLowtoHigh.click();

        ReusableMethods.waitFor(3);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://shop-pickbazar-rest.vercel.app/products/the-sifi-third-part?orderBy=rating&sortedBy=ASC");

    }

    @Test
    public void test11_AllStar() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        firstProductTitle.click();
        ReusableMethods.waitFor(2);
        allStar.click();
        ReusableMethods.waitFor(1);
        star5.click();
        ReusableMethods.waitFor(1);

    }
        @Test
        public void test12_AskSellerButton () {

            gotoBooksPage();
            ReusableMethods.waitFor(3);
            firstProductTitle.click();
            ReusableMethods.waitFor(2);
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView()", askSellerButton);
            ReusableMethods.waitFor(3);

            try {

                joinButton.isDisplayed();
                loginOl();

                ReusableMethods.waitFor(2);
                askSellerButton.click();
                ReusableMethods.waitFor(2);
                Assert.assertTrue(askSellerText.isDisplayed());


            } catch (Exception e) {
                ReusableMethods.waitFor(2);
                askSellerButton.click();
                ReusableMethods.waitFor(2);
                Assert.assertTrue(askSellerText.isDisplayed());
            }

            Driver.getDriver().close();
            Driver.getDriver().quit();
        }

    }
