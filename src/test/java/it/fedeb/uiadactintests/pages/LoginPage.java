package it.fedeb.uiadactintests.pages;

import it.fedeb.uiadactintests.DriverFactory;
import it.fedeb.uiadactintests.helpers.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private static LoginPage page;

    protected LoginPage() {
        this.driver = DriverFactory.getDriver();
        System.out.println("LoginPage constructor!");
    }


    public static void destroyPage() {
        page = null;
    }
    //TODO: delete duplicated code

    public void openPage(){
        String loginUrl = new PropertyReader().readProperty("url.login");
        driver.get(loginUrl);
    }

    public void insertUserPassword(String username, String password){
        WebElement userBox = driver.findElement(By.id("username"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        userBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }


}
