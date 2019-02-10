package it.fedeb.uiadactintests.steps;

import cucumber.api.java.en.When;
import it.fedeb.uiadactintests.pages.BookAHotelPage;
import it.fedeb.uiadactintests.pages.PagesFactory;

public class BookAHotelSteps {


    @When("^I fill all the payment data for the reservation$")
    public void fill_data_for_booking() {
        getPage().fillBookingData();
    }


    private BookAHotelPage getPage() {
        return (BookAHotelPage) PagesFactory.getPage(BookAHotelPage.class);
    }

}
