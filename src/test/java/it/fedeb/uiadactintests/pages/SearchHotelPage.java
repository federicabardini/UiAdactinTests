package it.fedeb.uiadactintests.pages;

import it.fedeb.uiadactintests.helpers.DateHelper;
import it.fedeb.uiadactintests.helpers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage {

    private WebDriver driver;

    protected SearchHotelPage() {
        this.driver = DriverFactory.getDriver();
    }


    public boolean isSearchHotelPage() {
        return driver.getTitle().contains("Adactin.com - Search Hotel");
    }

    public boolean isHelloUserMessageDisplayed(String username) {
        return driver.getPageSource().contains("Hello " + username + "!");

    }

    public void insertLocation(String location) {
        Select locationList = new Select(driver.findElement(By.id("location")));
        locationList.selectByValue(location);
    }

    public void insertRoomType() {
        Select roomType = new Select(driver.findElement(By.id("room_type")));
        roomType.selectByValue("Double");
    }

    public void insertRoomsNumber(String roomsNumber) {
        Select roomsNumberList = new Select(driver.findElement(By.id("room_nos")));
        roomsNumberList.selectByValue(roomsNumber);
    }

    public void insertAdultsRoom(String adultsNumber) {
        Select adultsNumberList = new Select(driver.findElement(By.id("adult_room")));
        adultsNumberList.selectByValue(adultsNumber);
    }

    public void insertCheckInDate(int daysToAdd) {
        this.insertDate(daysToAdd, "datepick_in");
    }

    public void insertCheckOutDate(int daysToAdd) {
        this.insertDate(daysToAdd, "datepick_out");
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("Submit"));
        searchButton.click();
    }

    private void insertDate(int daysToAdd, String id) {
        WebElement dateBox = driver.findElement(By.id(id));
        dateBox.clear();
        dateBox.sendKeys(DateHelper.getDateAddingDays(daysToAdd));
    }
}
