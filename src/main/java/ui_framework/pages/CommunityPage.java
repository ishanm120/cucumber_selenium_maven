package ui_framework.pages;

import ui_framework.DriverPackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommunityPage {


    // Constructor
    public CommunityPage() {
        PageFactory.initElements(DriverManager.getWebDriverManager().getWebDriver(), this);
    }

    @FindBy(xpath = "//*[@class='center-layout']//button[contains(text(),'Community')]")
    private WebElement communityTab;

    public boolean isCommunityPageOpened(){
        return communityTab.isDisplayed();
    }


}
