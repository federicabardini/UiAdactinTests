package it.fedeb.uiadactintests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import it.fedeb.uiadactintests.pages.PagesFactory;
import it.fedeb.uiadactintests.pages.SelectHotelPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class SelectHotelSteps {

    @Then("^Select Hotel page is displayed$")
    public void select_hotel_page_displayed() {
        boolean isSelectHotelPage = getPage().isSelectHotelDisplayed();
        assertThat("I am arrived in Select Hotel Page", isSelectHotelPage, equalTo(true));
    }

    @And("^I check that there are more than one result displayed$")
    public void check_hotel_list_results() {
        int resultHotelCount = getPage().countHotelRowsListed();
        assertThat("There is more than one result displayed", resultHotelCount, greaterThan(1));
    }


    @And("^I check that all the results displayed have location \"([^\"]*)\", \"([^\"]*)\" booked, \"([^\"]*)\" stay$")
    public void check_location_rooms_stay_duration(String location, String bookedRooms, String stayDuration) {
        boolean isSelectedLocationDisplayed = getPage().isSelectedLocation(location);
        assertThat("The location displayed for every result is the one selected in the Search Page", isSelectedLocationDisplayed, equalTo(true));

        boolean isSelectRoomsNumberDisplayed = getPage().isTheSelectedBookedRoomsNumber(bookedRooms);
        assertThat("The booked rooms number displayed for every result is the one selected in the Search Page", isSelectRoomsNumberDisplayed, equalTo(true));

        boolean isSelectDuration = getPage().isTheSelectedDurationOfTheStay(stayDuration);
        assertThat("The stay duration displayed for every result is the one selected in the Search Page", isSelectDuration, equalTo(true));

    }

    @And("^I check that \"([^\"]*)\" is one of the results with \"([^\"]*)\" total price$")
    public void check_booking_total_price(String hotelName, String totalPrice) {
        String totalPriceFound = getPage().getBookingTotalPrice(hotelName);
        assertThat("The total price for " + hotelName + " is correct", totalPriceFound, equalTo(totalPrice));

    }


    private SelectHotelPage getPage() {
        return (SelectHotelPage) PagesFactory.getPage(SelectHotelPage.class);
    }

}
