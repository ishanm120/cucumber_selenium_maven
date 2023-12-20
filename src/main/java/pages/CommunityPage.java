package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommunityPage {


    // Constructor
    public CommunityPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='center-layout']//button[contains(text(),'Community')]")
    private WebElement communityTab;

    public boolean isCommunityPageOpened(){
        return communityTab.isDisplayed();
    }


}
