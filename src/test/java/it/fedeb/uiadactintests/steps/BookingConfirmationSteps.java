package it.fedeb.uiadactintests.steps;

import cucumber.api.java.en.Then;
import it.fedeb.uiadactintests.pages.BookingConfirmationPage;
import it.fedeb.uiadactintests.pages.PagesFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

public class BookingConfirmationSteps {


    @Then("^I see the booking reservation number$")
    public void verify_reservation_data() {
        BookingConfirmationPage page = getPage();

        page.waitForBookingConfirmationPageDisplayed();

        String orderNumber = page.getOrderNumber();
        assertThat("Order number is alphanumeric string", orderNumber, matchesPattern("\\w+"));
        //TODO - add verification point for every field in the page
    }


    private BookingConfirmationPage getPage() {
        return (BookingConfirmationPage) PagesFactory.getPage(BookingConfirmationPage.class);
    }

}
