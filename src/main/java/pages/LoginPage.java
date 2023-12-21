package pages;

import DriverPackage.DriverFactory;
import DriverPackage.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    // Constructor
    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriverManager().getWebDriver(), this);
    }


}
