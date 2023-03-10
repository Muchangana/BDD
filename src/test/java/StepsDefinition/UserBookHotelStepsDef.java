package StepsDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static StepsDefinition.Const.*;

public class UserBookHotelStepsDef {

    static ExtentTest test;
    static ExtentReports report;

    @Given("A user enters {string}, {string}, {string},{string},{string},{string},{string},{string}")
    public void a_user_enters(String sLocation, String sHotel, String sRoom_type, String sNo_room, String sCheck_in, String sCheck_out, String sAdult, String sChildren) throws InterruptedException {


        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Vutomi.Mashele\\Desktop\\BDD_Final\\Reports\\report.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        test = report.createTest("Booking");
        test.info("Desired hotel search displaying");


        Select dropdown = new Select(Const.getDriver().findElement(By.id("location")));
        dropdown.selectByVisibleText(sLocation);

        Select dropdown1 = new Select(Const.getDriver().findElement(By.id("hotels")));
        dropdown1.selectByVisibleText(sHotel);

        Select dropdown2 = new Select(Const.getDriver().findElement(By.id("room_type")));
        dropdown2.selectByVisibleText(sRoom_type);

        Select dropdown3 = new Select(Const.getDriver().findElement(By.id("room_nos")));
        dropdown3.selectByValue(sNo_room);


        Const.getDriver().findElement(By.id("datepick_in")).clear();
        Const.getDriver().findElement(By.id("datepick_in")).sendKeys(sCheck_in);
        Const.getDriver().findElement(By.id("datepick_out")).clear();
        Const.getDriver().findElement(By.id("datepick_out")).sendKeys(sCheck_out);


        Select dropdown4 = new Select(Const.getDriver().findElement(By.id("adult_room")));
        dropdown4.selectByValue(sAdult);

        Select dropdown5 = new Select(Const.getDriver().findElement(By.id("child_room")));
        dropdown5.selectByValue(sChildren);


        Thread.sleep(1000);
        Const.getDriver().findElement(By.id("Submit")).click();
        Thread.sleep(2000);
        Const.getDriver().findElement(By.id("radiobutton_0")).click();
        Const.getDriver().findElement(By.id("continue")).click();
    }

    @And("A user enters {string}, {string}, {string}, {string}, {string}")
    public void a_user_enters(String sFirstname, String sLastname, String sBill, String sCard_no, String sCvv) throws InterruptedException {


        test.log(Status.PASS, "User Fills in billing details successful");
        Const.getDriver().findElement(By.id("first_name")).sendKeys(sFirstname);
        Const.getDriver().findElement(By.id("last_name")).sendKeys(sLastname);
        Const.getDriver().findElement(By.id("address")).sendKeys(sBill);
        Const.getDriver().findElement(By.id("cc_num")).sendKeys(sCard_no);


        Select dropdown = new Select(Const.getDriver().findElement(By.id("cc_type")));
        dropdown.selectByValue("VISA");

        Select dropdown1 = new Select(Const.getDriver().findElement(By.id("cc_exp_month")));
        dropdown1.selectByValue("7");


        Select dropdown2 = new Select(Const.getDriver().findElement(By.id("cc_exp_year")));
        dropdown2.selectByValue("2022");


        Const.getDriver().findElement(By.id("cc_cvv")).sendKeys(sCvv);
        Const.getDriver().findElement(By.id("book_now")).click();

        Thread.sleep(5000);


    }

    @Then("The hotel was booked successfully")
    public void the_Hotel_Was_Booked_Successfully() {


        WebDriverWait objWait = new WebDriverWait(Const.getDriver(), 5);
        objWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_no")));

        if (!Const.getDriver().findElement(By.id("order_no")).isDisplayed()) {
            test.fail("Hotel booking was unsuccessful");
            Assert.fail();
        } else {
            test.pass("Hotel booking was successful");
            System.out.println(Const.getDriver().findElement(By.id("order_no")).getText());
        }

        report.flush();
    }


}
