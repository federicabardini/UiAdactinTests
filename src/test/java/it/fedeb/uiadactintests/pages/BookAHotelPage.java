package it.fedeb.uiadactintests.pages;

import it.fedeb.uiadactintests.helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookAHotelPage {

    private WebDriver driver;

    @FindBy(id = "first_name")
    WebElement firstNameBox;

    @FindBy(id = "last_name")
    WebElement lastNameBox;

    @FindBy(id = "address")
    WebElement addressBox;

    @FindBy(id = "cc_num")
    WebElement creditCardNumberBox;

    @FindBy(id = "cc_type")
    WebElement creditCardTypeList;

    @FindBy(id = "cc_exp_month")
    WebElement ccMonthExpiryList;

    @FindBy(id = "cc_exp_year")
    WebElement ccYearExpiryList;

    @FindBy(id = "cc_cvv")
    WebElement creditCardCvvBox;

    @FindBy(id = "book_now")
    WebElement bookNowButton;

    protected BookAHotelPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void fillBookingData() {
        firstNameBox.sendKeys("Mario");
        lastNameBox.sendKeys("Rossi");
        addressBox.sendKeys("Viale Ripamonti 64, Milano");
        creditCardNumberBox.sendKeys("1234567809876543");
        new Select(creditCardTypeList).selectByValue("VISA");
        new Select(ccMonthExpiryList).selectByValue("5");
        new Select(ccYearExpiryList).selectByValue("2021");
        creditCardCvvBox.sendKeys("777");
        bookNowButton.click();
    }


}
