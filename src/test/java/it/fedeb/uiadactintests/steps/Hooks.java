package it.fedeb.uiadactintests.steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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