package it.fedeb.uiadactintests.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import it.fedeb.uiadactintests.helpers.DriverFactory;
import it.fedeb.uiadactintests.helpers.ScreenShotHelper;
import it.fedeb.uiadactintests.pages.PagesFactory;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotHelper.getScreenshot(scenario);
        }

        DriverFactory.destroyDriver();
        PagesFactory.destroyAllPages();
    }
}