package it.fedeb.uiadactintests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import it.fedeb.uiadactintests.pages.LoginPage;
import it.fedeb.uiadactintests.pages.PagesFactory;

public class LoginSteps {


    @Given("^I have done the login with Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void login_into_application(String username, String password) {
        launch_the_adactin_application();
        insert_username_password(username, password);
        click_login_button();
    }


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
        return (LoginPage) PagesFactory.getPage(LoginPage.class);
    }

}
