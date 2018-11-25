package it.fedeb.uiadactintests.helpers;

import it.fedeb.uiadactintests.DriverFactory;
import org.openqa.selenium.WebDriver;

abstract public class BaseSteps {

    protected WebDriver driver;


    public void setup() {
        this.driver = DriverFactory.getDriver();
    }

    public void teardown() {
        DriverFactory.destroyDriver();
    }

}
