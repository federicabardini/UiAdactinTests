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


    @And("^I check that all the results displayed have location \"([^\"]*)\", \"([^\"]*)\" booked, \"([^\"]*)\" stay$")
    public void check_location_rooms_stayduration(String location, String bookedRooms, String stayDuration) {
        boolean isSelectedLocationDisplayed = page.isSelectedLocation(location);
        assertThat("The location displayed for every result is the one selected in the Search Page", isSelectedLocationDisplayed, equalTo(true));

        boolean isSelectRoomsNumberDisplayed = page.isTheRightBookedRoomsNumber(bookedRooms);
        assertThat("The booked rooms number displayed for every result is the one selected in the Search Page", isSelectRoomsNumberDisplayed, equalTo(true));

        boolean isSelectDuration = page.isTheSelectedDurationOfTheStay(stayDuration);
        assertThat("The stay duration displayed for every result is the one selected in the Search Page", isSelectDuration, equalTo(true));

        //TODO: pay attention because when one of these 3 checks fails, others check coming after are not executed: maybe is better to split the check step in 3 single steps in the Cucumber Scenario?
    }

}
