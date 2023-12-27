package utils;

import ui_framework.DriverPackage.DriverManager;
import org.openqa.selenium.support.PageFactory;
import ui_framework.pages.CommunityPage;
import ui_framework.pages.HomePage;
import ui_framework.pages.LoginPage;
import ui_framework.pages.NavigationPage;

public class PageObjectManager {
    public PageObjectManager() {
        PageFactory.initElements(DriverManager.getWebDriverManager().getWebDriver(), this);
    }

    private HomePage homePage;
    private CommunityPage communityPage;
    private LoginPage loginPage;

    private NavigationPage navigationPage;

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage() : homePage;
    }

    public CommunityPage getCommunityPage(){
        return (communityPage == null) ? communityPage = new CommunityPage() : communityPage;
    }

    public LoginPage getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }

    public NavigationPage getNavigationPage(){
        return (navigationPage == null) ? navigationPage = new NavigationPage() : navigationPage;
    }

}
