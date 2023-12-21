package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CommunityPage;
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

    @And("sample step to fail")
    public void failTest(){
        Assert.assertTrue(false);
        }

    @And("sample step to pass")
    public void passTest(){
        Assert.assertTrue(true);
    }

}

