package com.fb.uiadactintests.Steps;

import com.fb.uiadactintests.DriverFactory;
import com.fb.uiadactintests.Pages.SearchHotelPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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
    public void hello_logged_user_message(String username){
        boolean isHelloUserMessageDisplayed = page.isHelloUserMessageDisplayed(username);
        assertThat("Logged username message is displayed", isHelloUserMessageDisplayed, equalTo(true));
    }


}
