package com.fb.uiadactintests.Pages;

import org.openqa.selenium.WebDriver;

public class SearchHotelPage {

    private WebDriver driver;

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isSearchHotelPage() {
        boolean isSearchHotelPage = driver.getTitle().contains("AdactIn.com - Search Hotel");
        return isSearchHotelPage;
    }

    public boolean isHelloUserMessageDisplayed(String username) {
        boolean isHelloUserMessageDisplayed = driver.getPageSource().contains("Hello " + username + "!");
        return isHelloUserMessageDisplayed;

    }

}
