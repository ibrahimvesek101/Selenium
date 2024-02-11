package page;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage_ibrahim {
    public BooksPage_ibrahim() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "(//*[.='Login'])[2]")
    public WebElement loginButton;

    @FindBy(xpath = "(//*[.='Grocery'])[4]")
    public WebElement grocery;
    @FindBy(xpath = "(//*[.='Books'])[3]")
    public WebElement books;
    @FindBy(xpath = "(//*[.='The Bedtime Stories Part One'])[1]")
    public WebElement firstProductTitle;
    @FindBy(xpath = "//*[@class='text-xl font-bold tracking-tight text-heading lg:text-2xl xl:text-3xl']")
    public WebElement firstProductDetailTitle;
    @FindBy(xpath = "(//*[@class='text-base font-semibold text-orange-500'])[1]")
    public WebElement firstProductPrice;
    @FindBy(xpath = "//*[@class='text-2xl font-bold text-heading no-underline md:text-3xl']")
    public WebElement firstProductDetailPrice;
    @FindBy(xpath = "//button[.='See more']")
    public WebElement seeMoreButton;

    @FindBy(xpath = "//*[.='1']")
    public WebElement firstProductQuantity;
    @FindBy(xpath = "//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 border border-gray-300 px-5 hover:border-accent hover:!bg-transparent ltr:rounded-l rtl:rounded-r']")
    public WebElement negativeButton;
    @FindBy(xpath = "//*[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 border border-gray-300 px-5 hover:border-accent hover:!bg-transparent hover:!text-accent ltr:rounded-r rtl:rounded-l']")
    public WebElement positiveButton;
    @FindBy(xpath = "//*[.='2']")
    public WebElement thenPressPositiveButton;
    @FindBy(xpath = "//*[.='1']")
    public WebElement thenPressNegativeButtonInt;
    @FindBy(xpath = "//*[.='Add to Cart']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//*[@class='product-cart fixed top-1/2 z-40 -mt-12 hidden flex-col items-center justify-center rounded bg-accent p-3 pt-3.5 text-sm font-semibold text-light shadow-900 transition-colors duration-200 hover:bg-accent-hover focus:outline-0 ltr:right-0 ltr:rounded-tr-none ltr:rounded-br-none rtl:left-0 rtl:rounded-tl-none rtl:rounded-bl-none lg:flex']")
    public WebElement Item1;
    @FindBy(xpath = "//*[@class='flex h-12 w-full justify-between rounded-full bg-accent p-1 text-sm font-bold shadow-700 transition-colors hover:bg-accent-hover focus:bg-accent-hover focus:outline-0 md:h-14']")
    public WebElement checkoutButton;
    @FindBy(xpath = "//*[.='Check Availability']")
    public WebElement checkAvailabilityButton;
    @FindBy(xpath = "(//*[.='Cash On Delivery'])[4]")
    public WebElement cashOnDeliveryButton;
    @FindBy(xpath = "//button[.='My Orders']")
    public WebElement myOrdersButton;
    @FindBy(xpath = "//*[@class='relative cursor-pointer overflow-hidden rounded-full border border-border-100 h-10 w-10']")
    public WebElement avatarButton;
    @FindBy(xpath = "//*[@class='flex mb-2 text-sm font-semibold text-heading md:text-lg']")
    public WebElement ordersDetails;


    @FindBy(xpath = "(//*[.='Join'])[2]")
    public WebElement joinButton;
    @FindBy(xpath = "//*[@class='w-5 h-5 text-accent']")
    public WebElement heartButton;
    @FindBy(xpath = "//button[@class='mt-0.5 flex h-10 w-10 shrink-0 items-center justify-center rounded-full border border-gray-300 transition-colors !border-accent']")
    public WebElement fullHeart;
    @FindBy(xpath = "//button[@class='mt-0.5 flex h-10 w-10 shrink-0 items-center justify-center rounded-full border border-gray-300 transition-colors']")
    public WebElement emptyHeart;


    @FindBy(xpath = "//*[.='Details']")
    public WebElement details;
    @FindBy(xpath = "//*[@class=' css-1fxaex9']")
    public WebElement recent;
    @FindBy(xpath = "//div[text()='Ratings: Low to High']")
    public WebElement ratingsLowtoHigh;


    @FindBy(xpath = "(//*[@class=' css-1ek5eys-singleValue'])[2]")
    public WebElement allStar;
    @FindBy(xpath = "//*[.='5 Star']")
    public WebElement star5;
    @FindBy(xpath = "(//*[.='Ask seller a question'])[1]")
    public WebElement askSellerButton;
    @FindBy(xpath = "(//*[.='Ask seller a question'])[2]")
    public WebElement askSellerText;


    //US_25_BOOKS MANUFACTORS KISMI BUNDAN SONRA BAŞLIYOR.

    @FindBy(xpath = "//*[.='Top Manufacturers']")
    public WebElement topManufactorsTitle;
    @FindBy(xpath = "(//*[@class='mb-2 truncate text-lg font-semibold text-heading transition-colors hover:text-orange-500'])[1]")
    public WebElement topManufactorsFirstElement;
    @FindBy(xpath = "(//*[@class='sr-only'])[8]")
    public WebElement nextButton;


    @FindBy(xpath = "(//*[@class='justify-end text-base font-semibold transition-colors hover:text-orange-500'])[1]")
    public WebElement seeAllAuthorsButton;
    @FindBy(xpath = "(//*[@class='justify-end text-base font-semibold transition-colors hover:text-orange-500'])[2]")
    public WebElement seeAllManufacturersButton;

    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchInput;
    @FindBy(xpath = "(//span[@class='mb-2 truncate text-lg font-semibold text-heading transition-colors hover:text-orange-500'])[1]")
    public WebElement firstManufacturText;
    @FindBy(xpath = "//*[@class='mt-5 w-full truncate text-center text-xl font-bold text-heading 2xl:text-2xl']")
    public WebElement afterClickFirstManufacturText;


    @FindBy(xpath = "(//button[@class='flex w-full items-center justify-between focus:outline-0 focus:ring-1 focus:ring-accent focus:ring-opacity-40'])[1]")
    public WebElement searchTag;
    @FindBy(xpath = "//*[@class='absolute flex h-full w-10 items-center justify-center text-body transition-colors duration-200 hover:text-accent-hover focus:text-accent-hover focus:outline-0 ltr:left-0 rtl:right-0 md:w-14']")
    public WebElement afterSearchTagClick;


    @FindBy(xpath = "//*[@class='rc-slider-handle rc-slider-handle-2']")
    public WebElement sliderButton;
    @FindBy(xpath = "(//*[@class='text-sm font-bold text-heading'])[2]")
    public WebElement sliderMax;
    @FindBy(xpath = "(//*[@class='flex w-full cursor-pointer items-center'])[1]/span")
    public WebElement newReleased;
    @FindBy(xpath = "(//*[@class='flex w-full cursor-pointer items-center'])[2]/span")
    public WebElement sortByLowToHigh;
    @FindBy(xpath = "(//*[@class='flex w-full cursor-pointer items-center'])[3]/span")
    public WebElement sortByHighToLow;


    @FindBy(xpath = "(//*[@class='checkbox'])[1]")
    public WebElement scienceFictionCheckBox;
    @FindBy(xpath = "(//*[@class='checkbox'])[2]")
    public WebElement literatureCheckBox;
    @FindBy(xpath = "(//*[@class='checkbox'])[3]")
    public WebElement childrensLiteratureCheckBox;
    @FindBy(xpath = "(//*[@class='checkbox'])[4]")
    public WebElement comicBooksCheckBox;
    @FindBy(xpath = "(//*[@class='checkbox'])[5]")
    public WebElement horrorFictionCheckBox;
    @FindBy(xpath = "(//*[@class='checkbox'])[6]")
    public WebElement novelsCheckBox;
    @FindBy(xpath = "(//*[@class='checkbox'])[7]")
    public WebElement romanticPoetryCheckBox;
    @FindBy(xpath = "(//*[@class='checkbox'])[8]")
    public WebElement thrillerCheckBox;


    @FindBy(xpath = "(//input[@class='checkbox'])[9]")
    public WebElement firstEditionCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[10]")
    public WebElement secondEditionCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[11]")
    public WebElement thirdEditionCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[12]")
    public WebElement latestEditionCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[13]")
    public WebElement specialEditionCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[14]")
    public WebElement cerebralCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[15]")
    public WebElement suspenseCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[16]")
    public WebElement gothicCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[17]")
    public WebElement disturbingCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[18]")
    public WebElement romanceCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[19]")
    public WebElement loveCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[20]")
    public WebElement momentCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[21]")
    public WebElement awardWinningCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[22]")
    public WebElement scaryCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[23]")
    public WebElement devilCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[24]")
    public WebElement cartoonCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[25]")
    public WebElement childrenCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[26]")
    public WebElement superHeroCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[27]")
    public WebElement comedyCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[28]")
    public WebElement kidsStoryCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[29]")
    public WebElement sadCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[30]")
    public WebElement tearCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[31]")
    public WebElement spaceCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[32]")
    public WebElement fantasyCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[33]")
    public WebElement touchingCheckBox;
    @FindBy(xpath = "(//input[@class='checkbox'])[34]")
    public WebElement comboCheckBox;

    @FindBy(xpath = "//button[@class='text-sm font-semibold text-body transition-colors hover:text-red-500 focus:text-red-500 focus:outline-0 lg:m-0']")
    public WebElement clearAllButton;
    @FindBy(xpath = "(//*[.='Sorry, No Product Found :('])[3]")
    public WebElement sorryNoFoundText;


    public static Actions actions = new Actions(Driver.getDriver());

    //sadece iki adet method create ettim..
    public void gotoBooksPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("alternative_Url"));
        grocery.click();
        books.click();
    }

    public void loginOl() {

        joinButton.click();
        email.clear();
        password.clear();
        email.sendKeys(ConfigurationReader.getProperty("customerMail1"));
        password.sendKeys(ConfigurationReader.getProperty("customerPassword1"));
        loginButton.click();
    }

}
