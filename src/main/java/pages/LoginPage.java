package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    // Constructor
    public LoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }


}
