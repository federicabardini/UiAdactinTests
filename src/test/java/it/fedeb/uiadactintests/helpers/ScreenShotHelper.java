package it.fedeb.uiadactintests.helpers;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static it.fedeb.uiadactintests.helpers.DateHelper.formatLocalDateTimeToString;


public class ScreenShotHelper {


    public static void getScreenshot(Scenario scenario) {

        String fileName = formatLocalDateTimeToString() + "_" + scenario.getName() + ".png";

        try {
            File destination = new File(".//errorscreenshot//" + fileName);
            FileUtils.copyFile(((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE), destination);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}