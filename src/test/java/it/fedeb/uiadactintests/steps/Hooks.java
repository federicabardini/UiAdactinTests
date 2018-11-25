package it.fedeb.uiadactintests.steps;

import cucumber.api.java.After;
import it.fedeb.uiadactintests.DriverFactory;
import it.fedeb.uiadactintests.pages.LoginPage;
import it.fedeb.uiadactintests.pages.SearchHotelPage;
import it.fedeb.uiadactintests.pages.SelectHotelPage;

public class Hooks {


    @After
    public void afterScenario() {
        DriverFactory.destroyDriver();
        LoginPage.destroyPage();
        SearchHotelPage.destroyPage();
        SelectHotelPage.destroyPage();
        //TODO: avoid destroying pages after every scenario execution - not nice to maintain
    }
}