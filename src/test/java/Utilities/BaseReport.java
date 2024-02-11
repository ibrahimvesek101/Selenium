package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import page.HomePageBase;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class BaseReport extends HomePageBase implements ITestListener  {

    protected ExtentReports extentReports; //extent report'a ilk atamayi yapar.
    protected ExtentHtmlReporter extentHtmlReporter; // Html raporu duzenler
    protected ExtentTest extentTest;


    @BeforeSuite
    public void beforeSuite() {

        //Create extent report
        extentReports = new ExtentReports(); //

        // Report PATH
        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/report/" + currentDate + "test_report.html";

        //Attach
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        // Add custom information

        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("QA Engineer", "Team01");
        extentHtmlReporter.config().setDocumentTitle("Report");
        extentHtmlReporter.config().setReportName("TestNG Reports");
        extentHtmlReporter.config().setDocumentTitle(new SimpleDateFormat("dd_MM_yyyy&hh_mm_ss").format(new Date()));//test doc uzerinde tarih yazili olacak


    }



    @AfterMethod
    public void teardown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            String screenShotLocation = ReusableMethods.getScreenshot(Driver.getDriver(), result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenShotLocation);
            extentHtmlReporter.config().setDocumentTitle(screenShotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }

        Driver.getDriver().quit();
    }

    @AfterSuite
    public void afterSuite() {
        extentReports.flush();
    }
}
