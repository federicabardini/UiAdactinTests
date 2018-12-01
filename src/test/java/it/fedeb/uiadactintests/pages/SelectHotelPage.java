package it.fedeb.uiadactintests.pages;

import it.fedeb.uiadactintests.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectHotelPage {

    private WebDriver driver;

    @FindBy(css = "#select_form table.login table")
    WebElement resultTable;

    protected SelectHotelPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
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

    public boolean isTheSelectedBookedRoomsNumber(String expectedNumberOfRooms) {
        return isTheExpectedValueInTableResults(expectedNumberOfRooms, "td input[name^=\"rooms\"]");
    }

    public boolean isTheSelectedDurationOfTheStay(String expectedDuration) {
        return isTheExpectedValueInTableResults(expectedDuration, "td input[name^=\"no_days\"]");
    }

    public String getBookingTotalPrice(String hotelName) {
        String rowNumber = getResultRowNumber(hotelName);
        return resultTable.findElement(By.cssSelector("td input[name=\"total_price_" + rowNumber + "\"]")).getAttribute("value");
    }

    private String getResultRowNumber(String hotelName) {
        String inputName = resultTable.findElement(By.cssSelector("td input[value=\"" + hotelName + "\"]")).getAttribute("name");
        return inputName.substring("hotel_name_".length());
    }


    private boolean isTheExpectedValueInTableResults(String expectedValue, String fieldSelector) {
        boolean isFoundValueEqualToExpectedValue = true;
        List<WebElement> resultTableRows = resultTable.findElements(By.tagName("tr"));
        for (int i = 1; i < resultTableRows.size(); i++) {
            WebElement expectedValueLocation = resultTableRows.get(i).findElement(By.cssSelector(fieldSelector));
            String foundValue = expectedValueLocation.getAttribute("value");
            if (!expectedValue.equals(foundValue)) {
                isFoundValueEqualToExpectedValue = false;
                break;
            }
        }

        return isFoundValueEqualToExpectedValue;

    }


}
