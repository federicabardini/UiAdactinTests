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


    @FindBy(id = "room_type")
    WebElement roomTypeBox;

    @FindBy(id = "final_price")
    WebElement finalPriceBox;

    @FindBy(id = "order_no")
    WebElement orderNumberBox;


    protected BookingConfirmationPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void waitForBookingConfirmationPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleIs("Adactin.com - Hotel Booking Confirmation"));
    }


    public String getOrderNumber() {
        return orderNumberBox.getAttribute("value");
    }

    public String getRoomType() {
        return roomTypeBox.getAttribute("value");
    }

    public String getFinalPrice() {
        return finalPriceBox.getAttribute("value");
    }


}
