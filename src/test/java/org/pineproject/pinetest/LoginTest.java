package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pineproject.pinetest.pages.AdminProductsPage;
import org.pineproject.pinetest.pages.LoginPage;
import org.pineproject.pinetest.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers.hasText;

/*
 * This is a draft for functional LoginPage tests to be implemented soon...
 */
public class LoginTest extends PineTestBase {

    @Test(dataProvider = "parseAdminCredentials", groups = "functional")
    public void testValidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, pineUrl);
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, username, password);
        adminProductsPage.get();
        assertThat(adminProductsPage.getUserNameLabel(), hasText(username));
    }

    @DataProvider
    public Object[][] parseAdminCredentials() {
        return new Object[][]{
                {"admin", "nimda"}
        };
    }
}
