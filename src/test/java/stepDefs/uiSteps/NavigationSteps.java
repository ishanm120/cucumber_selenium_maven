package stepDefs.uiSteps;

import io.cucumber.java.en.When;
import ui_framework.pages.NavigationPage;
import utils.PageObjectManager;

public class NavigationSteps {

    private NavigationPage navigationPage;

    private PageObjectManager pageObjectManager;


    @When("user opens home page")
    public void openHomePage(){
        pageObjectManager = new PageObjectManager();
        navigationPage = pageObjectManager.getNavigationPage();
        navigationPage.openHomePage();
    }
}

