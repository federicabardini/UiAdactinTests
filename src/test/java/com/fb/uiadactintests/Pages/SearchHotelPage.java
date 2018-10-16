package com.fb.uiadactintests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage {

    private WebDriver driver;

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isSearchHotelPage() {
        return driver.getTitle().contains("AdactIn.com - Search Hotel");
    }

    public boolean isHelloUserMessageDisplayed(String username) {
        return driver.getPageSource().contains("Hello " + username + "!");

    }

    public void insertLocation(String location) {
        Select locationList = new Select(driver.findElement(By.id("location")));
        locationList.selectByValue(location);
    }

    public void insertRoomsNumber(String roomsNumber) {
        Select roomsNumberList = new Select(driver.findElement(By.id("room_nos")));
        roomsNumberList.selectByValue(roomsNumber);
    }

    public void insertAdultsRoom(String adultsNumber) {
        Select adultsNumberList = new Select(driver.findElement(By.id("adult_room")));
        adultsNumberList.selectByValue(adultsNumber);
    }

    public void insertCheckInDate(String checkInDate) {
        WebElement checkInBox = driver.findElement(By.id("datepick_in"));
        checkInBox.clear();
        checkInBox.sendKeys(checkInDate);
        //TODO generate automatic sysdate+n date
    }

    public void insertCheckOutDate(String checkOutDate) {
        WebElement checkOutBox = driver.findElement(By.id("datepick_out"));
        checkOutBox.clear();
        checkOutBox.sendKeys(checkOutDate);
        //TODO generate automatic sysdate+n date
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("Submit"));
        searchButton.click();
    }
}
