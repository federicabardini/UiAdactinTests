package it.fedeb.uiadactintests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectHotelPage {

    private WebDriver driver;

    public SelectHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSelectHotelDisplayed() {
        return driver.getTitle().contains("AdactIn.com - Select Hotel");
    }


    public int countHotelRowsListed() {
        List<WebElement> resultItems = driver.findElements(By.cssSelector("td input[id^=\"hotel_name_\"]"));
        return resultItems.size();

    }

}
