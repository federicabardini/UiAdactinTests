package it.fedeb.uiadactintests.helpers;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShotHelper {


    public static void onFailure(Scenario scenario) {
        //TODO: change screenshot location&name

        String fileName = scenario.getName() + ".png";

        try {
            File destiny = new File(fileName);
            FileUtils.copyFile(((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE), destiny);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}