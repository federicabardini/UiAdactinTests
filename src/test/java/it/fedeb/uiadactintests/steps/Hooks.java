package it.fedeb.uiadactintests.steps;

import cucumber.api.java.After;
import it.fedeb.uiadactintests.helpers.DriverFactory;
import it.fedeb.uiadactintests.pages.PagesFactory;

public class Hooks {


    @After
    public void afterScenario() {
        DriverFactory.destroyDriver();
        PagesFactory.destroyAllPages();
    }
}