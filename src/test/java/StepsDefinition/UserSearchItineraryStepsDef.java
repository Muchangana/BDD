package StepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserSearchItineraryStepsDef extends Const {
    @And("A user clicks on search hotel")
    public void a_user_clicks_on_search_hotel() {


        Actions action = new Actions(Const.getDriver());
        WebElement btn = Const.getDriver().findElement(By.id("order_no"));
        action.doubleClick(btn).perform();

        String CopyText = Const.getDriver().findElement(By.id("order_no")).getText();


        Const.getDriver().findElement(By.id("my_itinerary")).click();

        Const.getDriver().findElement(By.id("order_id_text")).sendKeys(CopyText);

    }

    @And("A user enter order number and click on the go button")
    public void a_user_enter_order_number_and_click_on_the_go_button() {
        Const.getDriver().findElement(By.id("search_hotel_id")).click();
    }

    @Then("The search is successful")
    public void the_search_is_successful() {
        if (!Const.getDriver().findElement(By.id("search_result_error")).isDisplayed())
            Assert.fail();

        Const.getDriver().findElement(By.id("logout")).click();
    }


}
