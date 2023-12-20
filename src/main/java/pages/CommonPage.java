package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    public CommonPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

}
