package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.CommunityPage;
import pages.LoginPage;
import utils.PageObjectManager;

public class CommunityPageSteps {

    private CommunityPage communityPage;
    private PageObjectManager pageObjectManager;

    @When("verify user is on community page")
    public void verifyCommunityPage(){
        pageObjectManager = new PageObjectManager();
        communityPage = pageObjectManager.getCommunityPage();
        Assert.assertTrue(communityPage.isCommunityPageOpened(),"verify community page is opened");
    }

}

