package it.fedeb.uiadactintests.steps;

import cucumber.api.java.After;
import it.fedeb.uiadactintests.DriverFactory;

public class Hooks {

    @After
    public void afterScenario() {
        DriverFactory.destroyDriver();
    }
}