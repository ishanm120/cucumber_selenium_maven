package pages;

import DriverManager.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class NavigationPage {

    public NavigationPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public void openHomePage(){
        logger.info("open application url");
        DriverFactory.getDriver().get(ConfigReader.getConfigReader().getProperty("baseUrl"));
    }

}
