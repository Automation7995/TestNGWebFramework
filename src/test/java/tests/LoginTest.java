package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JSONConfigReader;

public class LoginTest extends BaseTest {

    @DataProvider
    public static Object[][] loginData() {
        return new Object[][]{
                {JSONConfigReader.getString("validUser.username"), JSONConfigReader.getString("validUser.password"), true},
                {JSONConfigReader.getString("InvalidUsername.username"), JSONConfigReader.getString("InvalidUsername.password"), false},
                {JSONConfigReader.getString("InvalidPassword.username"), JSONConfigReader.getString("InvalidPassword.password"), false},
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
