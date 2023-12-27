package ui_framework.pages;

import ui_framework.DriverPackage.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    // Constructor
    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriverManager().getWebDriver(), this);
    }


}
