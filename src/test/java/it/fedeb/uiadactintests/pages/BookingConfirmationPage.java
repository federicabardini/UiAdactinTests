package it.fedeb.uiadactintests.pages;

import it.fedeb.uiadactintests.helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingConfirmationPage {

    private WebDriver driver;

    @FindBy(id = "first_name")
    WebElement firstNameBox;

    @FindBy(id = "last_name")
    WebElement lastNameBox;

    @FindBy(id = "address")
    WebElement addressBox;

    @FindBy(id = "order_no")
    WebElement orderNumberBox;


    protected BookingConfirmationPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void waitForBookingConfirmationPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleIs("AdactIn.com - Hotel Booking Confirmation"));
    }


    public String getOrderNumber() {

        return orderNumberBox.getAttribute("value");

        /*firstNameBox.sendKeys("Mario");
        lastNameBox.sendKeys("Rossi");
        addressBox.sendKeys("Viale Ripamonti 64, Milano");

*/
    }


}
