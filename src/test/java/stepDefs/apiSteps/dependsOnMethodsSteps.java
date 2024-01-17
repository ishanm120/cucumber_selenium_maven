package stepDefs.apiSteps;

import api_framework.api.AssertableResponse;
import api_framework.objects.responsePOJO.FacilityDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class dependsOnMethodsSteps extends BaseTest{

    @Given("create user")
    public void create_user() {
        System.out.println("create new user");
        //throw new RuntimeException("user not created");
    }
    @When("login with created user")
    public void login_with_created_user() {
        System.out.println("logging with recently created user");
    }
    @When("upload image")
    public void upload_image() {
        System.out.println("user is uploading image");
    }
    @Then("verify image uploaded")
    public void verify_image_uploaded() {
        System.out.println("verify image is uploaded");
        Assert.assertTrue(true);
    }

    @Then("verify profile page")
    public void verify_profile_page() {
        System.out.println("verify profile page is created");
        Assert.assertTrue(true);
    }

    @When("replace the current photo")
    public void replace_the_current_photo() {
        System.out.println("user is replacing photo");
    }
    @Then("verify photo is changed")
    public void verify_photo_is_changed() {
        System.out.println("verify photo is changed");
        Assert.assertTrue(true);
    }

    @When("enter user credentials")
    public void enter_user_credentials() {
        System.out.println("enter user credentials for login");
    }
    @When("click on submit button")
    public void click_on_submit_button() {
        System.out.println("user clicks on submit button");
    }
    @Then("verify user is logged in")
    public void user_is_logged_in() {
        System.out.println("verify user is successfully logged in");
        Assert.assertTrue(true);
    }

    @Given("open application")
    public void open_application() {
        System.out.println("user is launching application");
    }
    @When("search for dress")
    public void search_for_dress() {
        System.out.println("user is searching dress");
    }
    @Then("verify search result page")
    public void verify_search_result_page() {
        System.out.println("verify correct search page is opened");
        Assert.assertTrue(true);
    }

    @Given("user is on search result page")
    public void user_is_on_search_result_page() {
        System.out.println("user is already on search result page");
    }
    @Then("verify listing on page")
    public void verify_listing_on_page() {
        System.out.println("verify listing on page is correct");
        Assert.assertTrue(true);
    }

    @Then("verify login page")
    public void verify_login_page() {
        System.out.println("verify login page is correct");
        Assert.assertTrue(true);
    }

}
