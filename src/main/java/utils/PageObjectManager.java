package utils;

import DriverPackage.DriverFactory;
import DriverPackage.DriverManager;
import org.openqa.selenium.support.PageFactory;
import pages.CommunityPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NavigationPage;

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
