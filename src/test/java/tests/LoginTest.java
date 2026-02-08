package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider
    public static Object[][] loginData() {
        return new Object[][]{
                {"visual_user", "secret_sauce", true},
                {"visual_user", "admin", false},
                {"admin", "secret_sauce", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginWIthCorrectCredentials(String username, String password, boolean isLoginExpected) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        if (isLoginExpected) {
            Assert.assertTrue(loginPage.verifyPageLogo(), "Username and password are correct");
            loginPage.clickBurgerMenu();
            loginPage.clickLogout();
        } else {
            Assert.assertTrue(loginPage.verifyLoginErrorMessage(), "Username and password are incorrect");
        }
    }
}
