package StepsDefinition;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class UserLoginStepsDef extends Const {

    static ExtentTest test;
    static ExtentReports report;
    @Given("A user is on the home page")
    public void aUserIsOnTheHomePage() {

        initializeWebDriver();
        Reporter.log("The browser is opened now");
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        Reporter.log("The browser is maximized");

        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\ilabadmin\\Desktop\\BDD_Final\\Reports\\reports.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        test = report.createTest("Login");


    }

    @When("A user navigates to the Login page using {string}")
    public void aUserNavigatesToTheLoginPageUsing(String sUrl) {
        getDriver().get(sUrl);
        Reporter.log("The Adactin webiste is opened");
    }

    @And("A user enter {string} and {string}")
    public void aUserEnterUsernameAndPassword(String sUsername, String sPassword) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.id("username")).sendKeys(sUsername);
        getDriver().findElement(By.id("password")).sendKeys(sPassword);
    }

    @And("A user clicks the login button")
    public void aUserClicksTheLoginButton() {
        getDriver().findElement(By.id("login")).click();
    }

    @Then("A user has login successfully")
    public void aUserHasLoginSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        String welcomeMsg = getDriver().findElement(By.id("username_show")).getAttribute("value");
        System.out.println(welcomeMsg);

        if (!getDriver().findElement(By.id("location")).isDisplayed()){
            test.fail("Login unsuccessful");
            Assert.fail();
        }else{
            test.pass("login is successful");
        }
      driver.quit();
       report.flush();

    }
}
