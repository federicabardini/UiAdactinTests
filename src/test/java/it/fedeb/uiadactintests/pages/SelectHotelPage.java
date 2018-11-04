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

    public boolean isSelectedLocation(String expectedLocation) {

        return isTheExpectedValueInTableResults(expectedLocation, "td input[name^=\"location\"]");

    }

    public boolean isTheRightBookedRoomsNumber(String expectedNumberOfRooms) {

        return isTheExpectedValueInTableResults(expectedNumberOfRooms, "td input[name^=\"rooms\"]");
    }

    public boolean isTheSelectedDurationOfTheStay(String expectedDuration) {
        return isTheExpectedValueInTableResults(expectedDuration, "td input[name^=\"no_days\"]");
    }


    private boolean isTheExpectedValueInTableResults(String expectedValue, String fieldSelector) {
        boolean isFoundValueEqualToExpectedValue = true;
        WebElement resultTable = driver.findElement(By.cssSelector("#select_form table.login table"));
        List<WebElement> resultTableRows = resultTable.findElements(By.tagName("tr"));
        for (int i = 1; i < resultTableRows.size(); i++) {
            WebElement expectedValueLocation = resultTableRows.get(i).findElement(By.cssSelector(fieldSelector));
            String foundValue = expectedValueLocation.getAttribute("value");
            if (!foundValue.equals(expectedValue)) {
                isFoundValueEqualToExpectedValue = false;
                break;
            }
        }

        return isFoundValueEqualToExpectedValue;

    }


}
