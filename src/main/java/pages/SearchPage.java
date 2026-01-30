package pages;

import org.openqa.selenium.*;
import commons.BasePage;
import utils.ConfigReader;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By userName = By.xpath("//input[@id='username']");
    private final By password = By.xpath("//input[@id='password']");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By secureAreaText = By.xpath("//i[@class='icon-lock']/parent::*[contains(normalize-space(),'Secure Area')]");

    public void enterUsername() {
        click(userName);
        type(userName, ConfigReader.getProperty("username"));
    }

    public void enterPassword() {
        click(password);
        type(password, ConfigReader.getProperty("password"));
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean verifySecureAreaText() {
        return isDisplayed(secureAreaText);
    }
}
