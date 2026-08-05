package stepDefs.uiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ui_framework.pages.LoginPage;
import ui_framework.pages.NavigationPage;
import utils.ConfigReader;
import utils.PageObjectManager;

public class LoginSteps {

    private LoginPage loginPage;
    private NavigationPage navigationPage;
    private String passwordBeforeToggle;

    @Given("the user opens the EazyGrade login page")
    public void openLoginPage() {
        PageObjectManager pageObjectManager = new PageObjectManager();
        loginPage = pageObjectManager.getLoginPage();
        navigationPage = pageObjectManager.getNavigationPage();
        navigationPage.openLoginPage();
    }

    @Then("the login page is displayed")
    public void verifyLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "Expected the EazyGrade login form to be displayed");
    }

    @When("the user enters User ID {string}")
    public void enterUserId(String userId) {
        loginPage.enterUserId(userId);
    }

    @When("the user enters Password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks Login")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @When("the user submits invalid login credentials")
    public void submitInvalidCredentials() {
        loginPage.login("invalid_user", "invalid_password");
    }

    @Then("a login error is displayed")
    public void verifyLoginError() {
        Assert.assertFalse(loginPage.getAlertMessage().isBlank(),
                "Expected an error alert for invalid credentials");
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "User should remain on the login page after invalid login");
    }

    @Then("User ID required validation is displayed")
    public void verifyUserIdRequiredValidation() {
        Assert.assertTrue(loginPage.hasUserIdRequiredValidation(),
                "Expected required validation for User ID");
    }

    @Then("Password required validation is displayed")
    public void verifyPasswordRequiredValidation() {
        Assert.assertTrue(loginPage.hasPasswordRequiredValidation(),
                "Expected required validation for Password");
    }

    @Then("the password is masked")
    public void verifyPasswordMasked() {
        Assert.assertTrue(loginPage.isPasswordMasked(),
                "Expected password input to be masked");
    }

    @When("the user records the password and toggles its visibility")
    public void togglePasswordVisibility() {
        passwordBeforeToggle = loginPage.getPasswordValue();
        loginPage.togglePasswordVisibility();
    }

    @Then("the password is visible and unchanged")
    public void verifyPasswordVisibleAndUnchanged() {
        Assert.assertFalse(loginPage.isPasswordMasked(),
                "Expected password input to be visible");
        Assert.assertEquals(loginPage.getPasswordValue(), passwordBeforeToggle,
                "Password value changed while toggling visibility");
    }

    @When("the user logs in with configured valid credentials")
    public void loginWithConfiguredCredentials() {
        loginPage.login(requiredConfig("eazyGradeUserId"), requiredConfig("eazyGradePassword"));
    }

    @When("the user submits configured valid credentials using Enter")
    public void loginWithEnter() {
        loginPage.enterUserId(requiredConfig("eazyGradeUserId"));
        loginPage.enterPassword(requiredConfig("eazyGradePassword"));
        loginPage.submitUsingEnter();
    }

    @Then("the user is redirected to the dashboard")
    public void verifyDashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed(),
                "Expected successful login to redirect to /dashboard");
    }

    private String requiredConfig(String propertyName) {
        String value = ConfigReader.getConfigReader().getProperty(propertyName);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing required test configuration: " + propertyName);
        }
        return value;
    }
}
