package it.fedeb.uiadactintests.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = System.getenv("BROWSER_TYPE") != null ? System.getenv("BROWSER_TYPE") : "chrome";
            switch(browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException(browserType + " is not a supported browser type");
            }

        }
        return driver;
    }

    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}