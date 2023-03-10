package StepsDefinition;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
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
    public void a_user_is_on_the_home_page() {

        initializeWebDriver();

        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();


        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Vutomi.Mashele\\Desktop\\BDD_Final\\Reports\\report.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        test = report.createTest("Login");
        test.log(Status.PASS, "The browser is opened successfully");
        test.log(Status.PASS, "The browser is maximized");

    }

    @When("A user navigates to the Login page using {string}")
    public void a_user_navigates_to_the_login_page_using(String sUrl) {
        getDriver().get(sUrl);
        test.log(Status.PASS, "The Adactin webiste is opened");
    }

    @And("A user enter {string} and {string}")
    public void a_user_enter_and(String sUsername, String sPassword) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.id("username")).sendKeys(sUsername);
        getDriver().findElement(By.id("password")).sendKeys(sPassword);
        test.log(Status.PASS, "User Fills in Login credentials");

    }

    @And("A user clicks the login button")
    public void a_user_clicks_the_login_button() {
        getDriver().findElement(By.id("login")).click();
    }

    @Then("A user has login successfully")
    public void a_user_has_login_successfully() throws InterruptedException {
        Thread.sleep(5000);
        String welcomeMsg = getDriver().findElement(By.id("username_show")).getAttribute("value");
        System.out.println(welcomeMsg);


        if (!getDriver().findElement(By.id("location")).isDisplayed()) {
            test.fail("Login is unsuccessful", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
            test.addScreenCaptureFromPath("screenshot.png");
            test.assignDevice("Mac");
            test.assignAuthor("Vutomi");
            Assert.fail();
        } else {
            test.assignDevice("Windows");
            test.assignAuthor("Vutomi");
            test.pass("login is successful");
        }


        //driver.close();
        report.flush();
    }


}
