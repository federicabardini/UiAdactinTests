package it.fedeb.uiadactintests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import it.fedeb.uiadactintests.pages.SearchHotelPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchHotelSteps {


    @Then("^Search Hotel page appears$")
    public void search_hotel() {
        boolean isSearchHotelPage = SearchHotelPage.get().isSearchHotelPage();
        assertThat("I am arrived in Search Hotel Page", isSearchHotelPage, equalTo(true));
    }

    @And("^in the page I find the message Hello \"([^\"]*)\"!$")
    public void hello_logged_user_message(String username) {
        boolean isHelloUserMessageDisplayed = SearchHotelPage.get().isHelloUserMessageDisplayed(username);
        assertThat("Logged username message is displayed", isHelloUserMessageDisplayed, equalTo(true));
    }

    @Given("^I inserted Location: \"([^\"]*)\"$")
    public void insert_location(String location) {
        SearchHotelPage.get().insertLocation(location);
    }

    @And("^I inserted Number of Rooms: \"([^\"]*)\"$")
    public void insert_rooms_number(String roomNumber) {
        SearchHotelPage.get().insertRoomsNumber(roomNumber);
    }

    @And("^I inserted Adults per room: \"([^\"]*)\"$")
    public void insert_adults_room(String adultNumber) {
        SearchHotelPage.get().insertAdultsRoom(adultNumber);
    }

    @And("^I inserted Check in within (\\d+) days$")
    public void set_checkin_date(int daysToAddCheckIn) {
        SearchHotelPage.get().insertCheckInDate(daysToAddCheckIn);
    }

    @And("^I inserted Check out within (\\d+) days$")
    public void set_checkout_date(int daysToAddCheckOut) {
        SearchHotelPage.get().insertCheckOutDate(daysToAddCheckOut);
    }

    @When("^I click the Search Button$")
    public void click_search_button() {
        SearchHotelPage.get().clickSearchButton();
    }

}
