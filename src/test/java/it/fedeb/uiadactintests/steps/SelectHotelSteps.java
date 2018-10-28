package it.fedeb.uiadactintests.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import it.fedeb.uiadactintests.DriverFactory;
import it.fedeb.uiadactintests.pages.SelectHotelPage;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class SelectHotelSteps {

    private WebDriver driver;
    private SelectHotelPage page;


    @Before
    public void setup() {
        this.driver = DriverFactory.getDriver();
        page = new SelectHotelPage(driver);
    }

    @After
    public void teardown() {
        DriverFactory.destroyDriver();
    }


    @Then("^Select Hotel page is displayed$")
    public void select_hotel_page_displayed() {
        boolean isSelectHotelPage = page.isSelectHotelDisplayed();
        assertThat("I am arrived in Select Hotel Page", isSelectHotelPage, equalTo(true));
    }

    @And("^I check that there are more than one result displayed$")
    public void check_hotel_list_results() {
        int resultHotelCount = page.countHotelRowsListed();
        assertThat("There is more than one result displayed", resultHotelCount, greaterThan(1));
    }

}
