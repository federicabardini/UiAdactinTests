package it.fedeb.uiadactintests.steps;

import io.cucumber.java.en.Then;
import it.fedeb.uiadactintests.pages.BookingConfirmationPage;
import it.fedeb.uiadactintests.pages.PagesFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class BookingConfirmationSteps {


    @Then("^I see the booking reservation number$")
    public void verify_reservation_data() {
        BookingConfirmationPage page = getPage();

        page.waitForBookingConfirmationPageDisplayed();

        String finalPrice = page.getFinalPrice();
        assertThat("Final Price is the sum of total price and GST", finalPrice, equalTo("AUD $ 2200"));

        String roomType = page.getRoomType();
        assertThat("Type of room is the same selected in Search Hotel Page", roomType, equalTo("Double"));

        String orderNumber = page.getOrderNumber();
        assertThat("Order number is alphanumeric string", orderNumber, matchesPattern("\\w+"));
        //TODO - add verification point for every field in the page
    }


    private BookingConfirmationPage getPage() {
        return (BookingConfirmationPage) PagesFactory.getPage(BookingConfirmationPage.class);
    }

}
