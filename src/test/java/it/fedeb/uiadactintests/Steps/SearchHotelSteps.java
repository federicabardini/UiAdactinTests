package it.fedeb.uiadactintests.Steps;

import it.fedeb.uiadactintests.DriverFactory;
import it.fedeb.uiadactintests.Pages.SearchHotelPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchHotelSteps {

    private WebDriver driver;
    private SearchHotelPage page;


    @Before
    public void setup() {
        this.driver = DriverFactory.getDriver();
        page = new SearchHotelPage(driver);
    }

    @After
    public void teardown() {
        DriverFactory.destroyDriver();
    }


    @Then("^Search Hotel page appears$")
    public void search_hotel() {
        boolean isSearchHotelPage = page.isSearchHotelPage();
        assertThat("I am arrived in Search Hotel Page", isSearchHotelPage, equalTo(true));
    }

    @And("^in the page I find the message Hello \"([^\"]*)\"!$")
    public void hello_logged_user_message(String username) {
        boolean isHelloUserMessageDisplayed = page.isHelloUserMessageDisplayed(username);
        assertThat("Logged username message is displayed", isHelloUserMessageDisplayed, equalTo(true));
    }

    @Given("^I inserted Location: \"([^\"]*)\"$")
    public void insert_location(String location) {
        page.insertLocation(location);
    }

    @And("^I inserted Number of Rooms: \"([^\"]*)\"$")
    public void insert_rooms_number(String roomNumber) {
        page.insertRoomsNumber(roomNumber);
    }

    @And("^I inserted Adults per room: \"([^\"]*)\"$")
    public void insert_adults_room(String adultNumber) {
        page.insertAdultsRoom(adultNumber);
    }

    @And("^I inserted Check in date: \"([^\"]*)\"$")
    public void set_checkin_date(String checkInDate) {
        page.insertCheckInDate(checkInDate);
    }

    @And("^I inserted Check out date: \"([^\"]*)\"$")
    public void set_checkout_date(String checkOutDate) {
        page.insertCheckOutDate(checkOutDate);
    }

    @When("^I click the Search Button$")
    public void click_search_button() {
        page.clickSearchButton();
    }

}
