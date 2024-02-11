package test;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BooksPage_ibrahim;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class US_25_BooksManufactors_Test_ibrahim extends BooksPage_ibrahim {

    @Test
    public void test01_TopManufactors() {
        gotoBooksPage();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(topManufactorsTitle.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @Test
    public void test02_Swipe() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        String topManufactorsFirstElementStr = topManufactorsFirstElement.getText();
        actions.moveToElement(nextButton).click().perform();
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(topManufactorsFirstElementStr, topManufactorsFirstElement.getText());

        ReusableMethods.waitFor(2);

    }

    @Test
    public void test03_NumberOfProducer() {

        Dimension windowSize = new Dimension(1280, 691);
        Driver.getDriver().manage().window().setSize(windowSize);
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
        ReusableMethods.waitFor(3);
        grocery.click();
        books.click();
        ReusableMethods.waitFor(2);

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//*[@class='relative flex cursor-pointer items-center rounded border border-gray-200 bg-white p-5 shadow-md']"));
        ReusableMethods.waitFor(2);
        Iterator<WebElement> iterator = elements.iterator();
        ReusableMethods.waitFor(2);

        int count = 0;
        while (iterator.hasNext()) {
            WebElement element = iterator.next();
            if (element.isDisplayed()) {
                count++;
                ReusableMethods.waitFor(1);
            }
        }
        System.out.println("count = " + count);

        Assert.assertEquals(count, 4);

        ReusableMethods.waitFor(2);

    }

    @Test
    public void test04_SeeAll() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        seeAllAuthorsButton.click();
        ReusableMethods.waitFor(2);
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//*[@class='group relative flex cursor-pointer flex-col items-center bg-light text-center']"));
        Iterator<WebElement> iterator = elements.iterator();
        int count = 0;
        ReusableMethods.waitFor(1);
        while (iterator.hasNext()) {
            WebElement element = iterator.next();
            if (element.isDisplayed()) {
                count++;
            }
        }

        //See all a tıkladıktan sonra 11 tane (hepsi) yazar gözüktüğünün doğrulanması;
        Assert.assertEquals(count, 11);

        ReusableMethods.waitFor(2);
    }

    @Test
    public void test05_SearchManufactor() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        seeAllManufacturersButton.click();
        ReusableMethods.waitFor(2);
        String firstManufacturTextStr = firstManufacturText.getText();
        ReusableMethods.waitFor(2);
        searchInput.sendKeys(firstManufacturTextStr + Keys.ENTER);
        ReusableMethods.waitFor(3);
        firstManufacturText.click();
        ReusableMethods.waitFor(2);
        String afterClickFirstManufacturTextStr = afterClickFirstManufacturText.getText();
        ReusableMethods.waitFor(1);
        Assert.assertEquals(afterClickFirstManufacturTextStr, firstManufacturTextStr);
        ReusableMethods.waitFor(2);

    }

    @Test
    public void test06_Filter() throws IOException {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        seeAllManufacturersButton.click();
        ReusableMethods.waitFor(2);
        firstManufacturText.click();
        ReusableMethods.waitFor(2);

        // search tag ı seçebilmeli;
        searchTag.click();
        ReusableMethods.waitFor(2);
        searchTag.click();
        Assert.assertTrue(afterSearchTagClick.isEnabled());


        //  Slider hareket edebilmeli.
        actions.clickAndHold(sliderButton).moveByOffset(500, 0).release().perform();


        //BUG : Slider max= 2000
        int sMax = Integer.parseInt(sliderMax.getText());
        Assert.assertEquals(sMax, 2000);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", thrillerCheckBox);

        //Slider 1950 değil. 2000. Bug var SS oluşturuyoruz..
        ReusableMethods.getScreenshot(Driver.getDriver(), "_BUG_US_25_SliderMax=2000_ibrahim_");


        //categories te Science ve children seçildi.
        actions.moveToElement(scienceFictionCheckBox).click().release().perform();
        actions.moveToElement(childrensLiteratureCheckBox).click().release().perform();

        //seçimler clear lendi..
        clearAllButton.click();
        String afterClearUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(afterClearUrl, "https://shop-pickbazar-rest.vercel.app/manufacturers/too-cool-publication");

        //ürün yoksa "Sorry, No Product Found" yazısı doğrulanmalı

        actions.clickAndHold(sliderButton).moveByOffset(-200, 0).release().perform();
        ReusableMethods.waitForVisibility(sorryNoFoundText, 10);
        Assert.assertTrue(sorryNoFoundText.isDisplayed());

        ReusableMethods.waitFor(2);
    }


    @Test
    public void test07_Checkbox() {

        gotoBooksPage();
        ReusableMethods.waitFor(3);
        topManufactorsFirstElement.click();


        //SORT

        String afterPressAttribute = "h-[18px] w-[18px] rounded-full bg-white ltr:mr-3 rtl:ml-3 border-[5px] border-gray-800";

        // Tıklanan AssertTrue. Tıklanmayanlar AssertFalse.
        ReusableMethods.waitFor(2);
        sortByLowToHigh.click();
        Assert.assertEquals(afterPressAttribute, sortByLowToHigh.getAttribute("class"));
        Assert.assertNotEquals(afterPressAttribute, newReleased.getAttribute("class"));
        Assert.assertNotEquals(afterPressAttribute, sortByHighToLow.getAttribute("class"));

        // Tıklanan AssertTrue. Tıklanmayanlar AssertFalse.
        sortByHighToLow.click();
        Assert.assertEquals(afterPressAttribute, sortByHighToLow.getAttribute("class"));
        Assert.assertNotEquals(afterPressAttribute, newReleased.getAttribute("class"));
        Assert.assertNotEquals(afterPressAttribute, sortByLowToHigh.getAttribute("class"));

        // Tıklanan AssertTrue. Tıklanmayanlar AssertFalse.
        newReleased.click();
        Assert.assertEquals(afterPressAttribute, newReleased.getAttribute("class"));
        Assert.assertNotEquals(afterPressAttribute, sortByHighToLow.getAttribute("class"));
        Assert.assertNotEquals(afterPressAttribute, sortByLowToHigh.getAttribute("class"));


        //CATEGORİES

        Assert.assertFalse(scienceFictionCheckBox.isSelected());
        actions.moveToElement(scienceFictionCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(scienceFictionCheckBox.isSelected());

        Assert.assertFalse(literatureCheckBox.isSelected());
        actions.moveToElement(literatureCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(literatureCheckBox.isSelected());

        Assert.assertFalse(childrensLiteratureCheckBox.isSelected());
        actions.moveToElement(childrensLiteratureCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(childrensLiteratureCheckBox.isSelected());

        Assert.assertFalse(comicBooksCheckBox.isSelected());
        actions.moveToElement(comicBooksCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(comicBooksCheckBox.isSelected());

        Assert.assertFalse(horrorFictionCheckBox.isSelected());
        actions.moveToElement(horrorFictionCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(horrorFictionCheckBox.isSelected());

        Assert.assertFalse(novelsCheckBox.isSelected());
        actions.moveToElement(novelsCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(novelsCheckBox.isSelected());

        Assert.assertFalse(romanticPoetryCheckBox.isSelected());
        actions.moveToElement(romanticPoetryCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(romanticPoetryCheckBox.isSelected());

        Assert.assertFalse(thrillerCheckBox.isSelected());
        actions.moveToElement(thrillerCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(thrillerCheckBox.isSelected());

        //TAGS

        Assert.assertFalse(firstEditionCheckBox.isSelected());
        actions.moveToElement(firstEditionCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(firstEditionCheckBox.isSelected());

        Assert.assertFalse(secondEditionCheckBox.isSelected());
        actions.moveToElement(secondEditionCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(secondEditionCheckBox.isSelected());

        Assert.assertFalse(thirdEditionCheckBox.isSelected());
        actions.moveToElement(thirdEditionCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(thirdEditionCheckBox.isSelected());

        Assert.assertFalse(latestEditionCheckBox.isSelected());
        actions.moveToElement(latestEditionCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(latestEditionCheckBox.isSelected());

        Assert.assertFalse(specialEditionCheckBox.isSelected());
        actions.moveToElement(specialEditionCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(specialEditionCheckBox.isSelected());

        Assert.assertFalse(cerebralCheckBox.isSelected());
        actions.moveToElement(cerebralCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(cerebralCheckBox.isSelected());

        Assert.assertFalse(suspenseCheckBox.isSelected());
        actions.moveToElement(suspenseCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(suspenseCheckBox.isSelected());

        Assert.assertFalse(gothicCheckBox.isSelected());
        actions.moveToElement(gothicCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(gothicCheckBox.isSelected());

        Assert.assertFalse(disturbingCheckBox.isSelected());
        actions.moveToElement(disturbingCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(disturbingCheckBox.isSelected());

        Assert.assertFalse(romanceCheckBox.isSelected());
        actions.moveToElement(romanceCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(romanceCheckBox.isSelected());

        Assert.assertFalse(loveCheckBox.isSelected());
        actions.moveToElement(loveCheckBox).click().perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(loveCheckBox.isSelected());


        //Bu ksımdan sonrakiler JavascriptExecutor ile tıklanabiliyor.

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", momentCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(momentCheckBox.isSelected());


        Assert.assertFalse(awardWinningCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", awardWinningCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(awardWinningCheckBox.isSelected());

        Assert.assertFalse(scaryCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", scaryCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(scaryCheckBox.isSelected());

        Assert.assertFalse(devilCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", devilCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(devilCheckBox.isSelected());

        Assert.assertFalse(cartoonCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", cartoonCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(cartoonCheckBox.isSelected());


        Assert.assertFalse(childrenCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", childrenCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(childrenCheckBox.isSelected());

        Assert.assertFalse(superHeroCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", superHeroCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(superHeroCheckBox.isSelected());

        Assert.assertFalse(comedyCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", comedyCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(comedyCheckBox.isSelected());

        Assert.assertFalse(kidsStoryCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", kidsStoryCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(kidsStoryCheckBox.isSelected());

        Assert.assertFalse(sadCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", sadCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(sadCheckBox.isSelected());

        Assert.assertFalse(tearCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", tearCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(tearCheckBox.isSelected());

        Assert.assertFalse(spaceCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", spaceCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(spaceCheckBox.isSelected());

        Assert.assertFalse(fantasyCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", fantasyCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(fantasyCheckBox.isSelected());

        Assert.assertFalse(touchingCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", touchingCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(touchingCheckBox.isSelected());

        Assert.assertFalse(comboCheckBox.isSelected());
        jse.executeScript("arguments[0].click();", comboCheckBox);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(comboCheckBox.isSelected());

        Driver.getDriver().close();
        Driver.getDriver().quit();
    }

}
