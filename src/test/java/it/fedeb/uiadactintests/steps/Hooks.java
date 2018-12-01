package it.fedeb.uiadactintests.steps;

import cucumber.api.java.After;
import it.fedeb.uiadactintests.helpers.DriverFactory;
import it.fedeb.uiadactintests.helpers.ScreenShotHelper;
import it.fedeb.uiadactintests.pages.PagesFactory;

public class Hooks {



    @After
    public void afterScenario(cucumber.api.Scenario scenario) {
        ScreenShotHelper.onFailure(scenario);
        //TODO: TAKE THE SCREENSHOT ONLY ON FAILURES
        DriverFactory.destroyDriver();
        PagesFactory.destroyAllPages();
    }
}