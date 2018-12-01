package it.fedeb.uiadactintests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import it.fedeb.uiadactintests.pages.PagesFactory;
import it.fedeb.uiadactintests.pages.SearchHotelPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchHotelSteps {


    @Then("^Search Hotel page appears$")
    public void search_hotel() {
        boolean isSearchHotelPage = getPage().isSearchHotelPage();
        assertThat("I am arrived in Search Hotel Page", isSearchHotelPage, equalTo(true));
    }

    @And("^in the page I find the message Hello \"([^\"]*)\"!$")
    public void hello_logged_user_message(String username) {
        boolean isHelloUserMessageDisplayed = getPage().isHelloUserMessageDisplayed(username);
        assertThat("Logged username message is displayed", isHelloUserMessageDisplayed, equalTo(true));
    }

    @Given("^I inserted Location: \"([^\"]*)\"$")
    public void insert_location(String location) {
        getPage().insertLocation(location);
    }

    @And("^I inserted Number of Rooms: \"([^\"]*)\"$")
    public void insert_rooms_number(String roomNumber) {
        getPage().insertRoomsNumber(roomNumber);
    }

    @And("^I inserted Adults per room: \"([^\"]*)\"$")
    public void insert_adults_room(String adultNumber) {
        getPage().insertAdultsRoom(adultNumber);
    }

    @And("^I inserted Check in within (\\d+) days$")
    public void set_checkin_date(int daysToAddCheckIn) {
        getPage().insertCheckInDate(daysToAddCheckIn);
    }

    @And("^I inserted Check out within (\\d+) days$")
    public void set_checkout_date(int daysToAddCheckOut) {
        getPage().insertCheckOutDate(daysToAddCheckOut);
    }

    @When("^I click the Search Button$")
    public void click_search_button() {
        getPage().clickSearchButton();
    }


    private SearchHotelPage getPage() {
        return (SearchHotelPage) PagesFactory.getPage(SearchHotelPage.class);
    }



}
