package ui_framework.pages;

import ui_framework.DriverPackage.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    // Constructor
    public HomePage() {
        PageFactory.initElements(DriverManager.getWebDriverManager().getWebDriver(), this);
    }

    @FindBy(xpath = "//*[@id='example-applications']")
    private WebElement homePageTitle;

    @FindBy(xpath = "//input[@type= 'search']")
    private WebElement searchInputBox;
    private static final String HEADER_OPTION = "//*[@title='%s']";

    public boolean isHomePageOpened(){
        return homePageTitle.isDisplayed();
    }

    public void enterTextIntoSearchBox(String inputValue){
        searchInputBox.sendKeys(inputValue);
    }

    public void chooseHeaderOption(String inputValue){
        logger.info("adding webhook test connection");
        DriverManager.getWebDriverManager().getWebDriver().findElement(By.xpath(String.format(HEADER_OPTION,inputValue))).click();
    }

}
