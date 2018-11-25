package it.fedeb.uiadactintests.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import it.fedeb.uiadactintests.pages.LoginPage;

public class LoginSteps {

    private LoginPage page;

    @Before
    public void setup() {
        page = new LoginPage();
    }


    @Given("^I launched the AdactIn application in the browser$")
    public void launch_the_adactin_application() {
        page.openPage();
    }

    @When("^I insert a valid Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void insert_username_password(String username, String password) {
        page.insertUserPassword(username, password);
    }

    @And("^I click the Login button$")
    public void click_login_button() {
        page.clickLoginButton();
    }


}
