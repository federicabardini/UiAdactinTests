package it.fedeb.uiadactintests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import it.fedeb.uiadactintests.pages.LoginPage;
import it.fedeb.uiadactintests.pages.PagesFactory;

public class LoginSteps {


    @Given("^I launched the AdactIn application in the browser$")
    public void launch_the_adactin_application() {
        getPage().openPage();
    }

    @When("^I insert a valid Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void insert_username_password(String username, String password) {
        getPage().insertUserPassword(username, password);
    }


    @And("^I click the Login button$")
    public void click_login_button() {
        getPage().clickLoginButton();
    }


    private LoginPage getPage() {
        String pageType = LoginPage.class.getName();
        return (LoginPage) PagesFactory.getPage(pageType);
    }

}
