package ui_framework.pages;

import ui_framework.DriverPackage.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    public CommonPage() {
        PageFactory.initElements(DriverManager.getWebDriverManager().getWebDriver(), this);
    }

}
