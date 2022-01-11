package com.rocketlab.stepDefinitions;

import com.rocketlab.pages.ConsultationPage;
import com.rocketlab.utilities.BrowserUtils;
import com.rocketlab.utilities.ConfigurationReader;
import com.rocketlab.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ConsultationStepDefinition {
    JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
    ConsultationPage consultationPage= new ConsultationPage();
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(5);

    }

    @Given("User clicks the free first Consultation")
    public void user_clicks_the_free_first_Consultation() {

        BrowserUtils.scrollToElement(consultationPage.scrollDown);
        BrowserUtils.waitForClickablility(consultationPage.consultation,5);
        BrowserUtils.waitFor(2);
        consultationPage.consultation.click();
    }

    @When("User can choose the choices on the next page")
    public void user_can_choose_the_choices_on_the_next_page() {

        String title= Driver.get().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("Get an estimate - Rocketlab . Professional QA & Testing Services"));


    }

    @Then("User can see {string} are correct")
    public void user_can_see_are_correct(String expected) {
        System.out.println("expected = " + expected);
        BrowserUtils.waitFor(2);
        List<WebElement> choices= Driver.get().findElements(By.cssSelector("span.image-choices-choice-text.input-label"));
        for (int i= 0; i<choices.size();i++){
            System.out.println("choices.get(i).getText() = " + choices.get(i).getText());
            Assert.assertEquals(expected,choices.get(i).getText());
        }

    }

}
