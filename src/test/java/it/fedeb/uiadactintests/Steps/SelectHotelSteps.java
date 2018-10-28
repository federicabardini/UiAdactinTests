package it.fedeb.uiadactintests.Steps;

import it.fedeb.uiadactintests.DriverFactory;
import it.fedeb.uiadactintests.Pages.SelectHotelPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

    @And("^I check the data in the page are correct$")
    public void check_hotel_list_results() {
        //TODO
    }

}
