package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {

    private HomePage homePage;


    @When("verify user is on homepage")
    public void verifyHomePage(){
        homePage = new HomePage();
        Assert.assertTrue(homePage.isHomePageOpened(),"verify home page is opened");
    }

    @And("user enters keyword {string} in search box")
    public void enterKeywordInSearchBox(String textToSearch){
        homePage.enterTextIntoSearchBox(textToSearch);
    }

    @And("user selects header option {string}")
    public void selectHeaderOption(String optionTOChoose){
        homePage = new HomePage();
        homePage.chooseHeaderOption(optionTOChoose);
    }

}

