package ui_framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_framework.DriverPackage.DriverManager;
import utils.ConfigReader;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private static final By USER_ID = By.cssSelector("input[placeholder='Enter your ID']");
    private static final By PASSWORD = By.cssSelector("input[placeholder='Enter password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[normalize-space()='Login']");
    private static final By PASSWORD_TOGGLE = By.cssSelector(
            "button[aria-label='Show password'], button[aria-label='Hide password']");
    private static final By ALERT = By.cssSelector(
            "[role='alert'], .chakra-alert, .chakra-toast");
    private static final By INVALID_CREDENTIALS_MESSAGE =
            By.xpath("//*[@role='alert']/div[last()]");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage() {
        driver = DriverManager.getWebDriverManager().getWebDriver();
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getConfigReader().getGlobalWait()));
    }

    public boolean isLoginPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(USER_ID)).isDisplayed()
                && driver.findElement(PASSWORD).isDisplayed()
                && driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public void enterUserId(String userId) {
        clearAndType(USER_ID, userId);
    }

    public void enterPassword(String password) {
        clearAndType(PASSWORD, password);
    }

    public void login(String userId, String password) {
        enterUserId(userId);
        enterPassword(password);
        clickLogin();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }

    public void submitUsingEnter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD))
                .sendKeys(Keys.ENTER);
    }

    public boolean isPasswordMasked() {
        return "password".equalsIgnoreCase(
                wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD))
                        .getAttribute("type"));
    }

    public String getPasswordValue() {
        return driver.findElement(PASSWORD).getAttribute("value");
    }

    public void togglePasswordVisibility() {
        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_TOGGLE)).click();
    }

    public boolean hasRequiredValidation(By field, String fieldName) {
        String nativeMessage = driver.findElement(field).getAttribute("validationMessage");
        if (nativeMessage != null && !nativeMessage.isBlank()) {
            return true;
        }

        String alertMessage = getAlertMessage();
        return alertMessage != null
                && alertMessage.toLowerCase().contains(fieldName.toLowerCase())
                && alertMessage.toLowerCase().contains("required");
    }

    public boolean hasUserIdRequiredValidation() {
        return hasRequiredValidation(USER_ID, "user");
    }

    public boolean hasPasswordRequiredValidation() {
        return hasRequiredValidation(PASSWORD, "password");
    }

    public String getAlertMessage() {
        try {
            return wait.until(driver -> {
                List<WebElement> messages =
                        driver.findElements(INVALID_CREDENTIALS_MESSAGE);

                return messages.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .map(String::trim)
                        .filter(text -> !text.isEmpty())
                        .findFirst()
                        .orElse(null);
            });
        } catch (TimeoutException e) {
            return "";
        }
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.urlContains("/dashboard"));
    }

    private void clearAndType(By locator, String value) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        field.clear();
        if (value != null && !value.isEmpty()) {
            field.sendKeys(value);
        }
    }
}
