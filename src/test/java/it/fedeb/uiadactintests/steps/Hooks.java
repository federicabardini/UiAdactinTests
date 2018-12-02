package it.fedeb.uiadactintests.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import it.fedeb.uiadactintests.helpers.DriverFactory;
import it.fedeb.uiadactintests.helpers.ScreenShotHelper;
import it.fedeb.uiadactintests.pages.PagesFactory;

public class Hooks {



    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotHelper.getScreenshot(scenario);
        }

        DriverFactory.destroyDriver();
        PagesFactory.destroyAllPages();
    }
}