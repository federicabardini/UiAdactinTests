package com.fb.uiadactintests.Pages;

import org.openqa.selenium.WebDriver;

public class SelectHotelPage {

    private WebDriver driver;

    public SelectHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSelectHotelDisplayed() {
        return driver.getTitle().contains("AdactIn.com - Select Hotel");
    }


}
