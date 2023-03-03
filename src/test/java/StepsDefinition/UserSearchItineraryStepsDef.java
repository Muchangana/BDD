package StepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserSearchItineraryStepsDef {
    @And("A user clicks on search hotel")
    public void aUserClicksOnSearchHotel() {


        Actions a = new Actions(Const.getDriver());

        // WebDriverStepsDef.getDriver().findElement(By.id("order_no")).click();
        // a.keyDown(Keys.CONTROL);
        //  a.keyDown("a");
        // a.keyUp(Keys.CONTROL);
        //a.build().perform();

        Actions action = new Actions(Const.getDriver());
        WebElement btn = Const.getDriver().findElement(By.id("order_no"));
        action.doubleClick(btn).perform();

        //a.keyDown(Keys.CONTROL);
        // a.keyDown("c");
        // a.keyUp(Keys.CONTROL);
        // a.build().perform();

        String CopyText = Const.getDriver().findElement(By.id("order_no")).getText();


        Const.getDriver().findElement(By.id("my_itinerary")).click();

        Const.getDriver().findElement(By.id("order_id_text")).sendKeys(CopyText);
        // a.keyDown(Keys.CONTROL);
        //  a.keyDown("v");
        //  a.keyUp(Keys.CONTROL);
        //  a.build().perform();

    }

    @And("A user enter order number and click on the go button")
    public void aUserEnterOrderNumberAndClickOnTheGoButton() {
        Const.getDriver().findElement(By.id("search_hotel_id")).click();
    }

    @Then("The search is successful")
    public void theSearchIsSuccessful() {
        if(!Const.getDriver().findElement(By.id("search_result_error")).isDisplayed())
            Assert.fail();

        Const.getDriver().findElement(By.id("logout")).click();
    }
}
