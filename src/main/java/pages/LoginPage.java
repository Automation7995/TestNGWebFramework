package pages;

import org.openqa.selenium.*;
import commons.BasePage;
import utils.ConfigReader;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By userName = By.cssSelector("input[placeholder='Username']");
    private final By passWord = By.cssSelector("input[placeholder='Password']");
    private final By loginButton = By.cssSelector(".submit-button.btn_action");
    private final By pageLogo = By.cssSelector("div.app_logo");
    private final By loginErrorMessage = By.cssSelector("div.error-message-container.error");
    private final By burgerMenu = By.cssSelector("#react-burger-menu-btn");
    private final By logoutButton = By.cssSelector("#logout_sidebar_link");

    public void enterUsername(String username) {
        click(userName);
        type(userName, username);
    }

    public void enterPassword(String password) {
        click(passWord);
        type(passWord, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean verifyPageLogo() {
        return isDisplayed(pageLogo);
    }

    public boolean verifyLoginErrorMessage() {
        return isDisplayed(loginErrorMessage);
    }

    public void clickBurgerMenu() {
        click(burgerMenu);
    }

    public void clickLogout() {
        click(logoutButton);
    }
}
