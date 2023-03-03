package StepsDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Const {
    public static WebDriver driver;
    static ExtentTest test;
    static ExtentReports report;
    public static WebDriver getDriver() {
        return driver;
    }

    public WebDriver initializeWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
    public static ExtentReports getReportObject(){

        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\ilabadmin\\Desktop\\BDD_Final\\Reports\\reports.html");
        report = new ExtentReports();
        report.attachReporter(spark);

        return report;

    }


}
