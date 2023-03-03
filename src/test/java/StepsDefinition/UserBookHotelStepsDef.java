package StepsDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static StepsDefinition.Const.*;

public class UserBookHotelStepsDef {

    static ExtentTest test;
    static ExtentReports report;
    @Given("A user enters {string}, {string}, {string},{string},{string},{string},{string},{string}")
    public void aUserEnters(String sLocation, String sHotel, String sRoom_type, String sNo_room, String sCheck_in, String sCheck_out, String sAdult, String sChildren) throws InterruptedException {

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
    public void aUserEnters(String sFirstname, String sLastname, String sBill, String sCard_no, String sCvv) throws InterruptedException {

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
    public void theHotelWasBookedSuccessfully()  {

        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\ilabadmin\\Desktop\\BDD_Final\\Reports\\reports.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        ExtentTest test2 = report.createTest("Booking");

        WebDriverWait objWait = new WebDriverWait(Const.getDriver(), 5);
        objWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_no")));

        if (!Const.getDriver().findElement(By.id("order_no")).isDisplayed()) {
            test2.fail("Booking was unsuccessful");
            Assert.fail();
        }else{
            test2.pass("Booking was successful");
            System.out.println(Const.getDriver().findElement(By.id("order_no")).getText());
        }
        driver.quit();
        report.flush();
    }


}
