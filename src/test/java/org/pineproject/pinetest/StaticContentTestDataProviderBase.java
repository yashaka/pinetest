package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pineproject.pinetest.pages.AdminProductsPage;
import org.pineproject.pinetest.pages.LoginPage;
import org.pineproject.pinetest.pages.ProductsPage;
import org.pineproject.pinetest.pages.UserProductsPage;
import org.pineproject.pinetest.core.ExtendedLoadableComponent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 31.03.13
 * Time: 23:49
 */

/*
 * This is a base test for StaticContentTest.
 * It serves as container for DataProviders.
 * It's hard to keep the latter in a DataProviderClass because they need driver instance to create data objects.
 * TestNG does not support passing arguments to DataProviders. So far there is an extension that gives possibility
 * to pass only string arguments to the DataProvider.
 * TODO: Write own extension without limitation to pass only strings as DataProviders arguments.
 * These DataProviders are not DRY. But it's hard to fix this because though used data is similar, it go with different structure.
 * TODO: Think how to make DataProviders for StaticContent DRY.
 */
public class StaticContentTestDataProviderBase {

    @DataProvider(name = "adminPageObjects")
    protected Object[][] adminPageObjects() {
        LoginPage loginPage = new LoginPage(driver, pineUrl);
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, "admin", "nimda");

        return new Object[][]{
                {loginPage},
                {adminProductsPage}
        };
    }

    @DataProvider
    protected Object[][] userPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        UserProductsPage userProductsPage = new UserProductsPage(driver, loginPage, "productuser", "user");

        return new Object[][]{
                {userProductsPage}
        };
    }

    @DataProvider
    protected Object[][] pagesWithNamesAfterLogIn() {
        String userName = "productuser";
        String adminName = "admin";
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        ProductsPage  userProductsPage =  new UserProductsPage(driver, loginPage, userName,  "user");
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, adminName, "nimda");

        return new Object[][]{
                {userProductsPage, userName},
                {adminProductsPage, adminName}
        };
    }

    @DataProvider
    protected Object[][] pagesWithProductNamesList() {
        String userName = "productuser";
        String adminName = "admin";
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        ProductsPage  userProductsPage =  new UserProductsPage(driver, loginPage, userName, "user");
        ProductsPage  poorUserProductsPage =  new UserProductsPage(driver, loginPage, "poor", "user");
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, adminName, "nimda");

        return new Object[][]{
                {userProductsPage, Arrays.asList("Product")},
                {adminProductsPage, Arrays.asList("Product", "SuperProduct")},
                {poorUserProductsPage, Arrays.asList()}
        };
    }


    protected void assertPageExpectedElementsAreDisplayed(final ExtendedLoadableComponent page) {
        page.get();
        for(TypifiedElement element : page.getExpectedElements()) {
            assertTrue(element.isDisplayed());
        }
    }

    @Parameters("pine-url")
    @BeforeClass
    public void beforeClass(String pineUrl) {
        driver = new FirefoxDriver();
        this.pineUrl = pineUrl;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private String pineUrl;
}
