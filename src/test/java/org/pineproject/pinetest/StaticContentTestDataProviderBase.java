package org.pineproject.pinetest;

import org.pineproject.pinetest.pages.*;
import org.pineproject.pinetest.core.ExtendedLoadableComponent;
import org.testng.annotations.DataProvider;
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
public class StaticContentTestDataProviderBase extends PineTestBase {

    @DataProvider(name = "adminPageObjects")
    protected Object[][] adminPageObjects() {
        LoginPage loginPage = new LoginPage(driver, pineUrl);
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, "admin", "nimda");
        ProductPopupMenuPage productPopupMenuPage = new ProductPopupMenuPage(driver, adminProductsPage, "SuperProduct");
        //TODO: consider to add test for popup menus on all listed products, think how to do this in a DRY way

        return new Object[][]{
                {loginPage},
                {adminProductsPage},
                {productPopupMenuPage}
        };
    }

    @DataProvider
    protected Object[][] userPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        UserProductsPage userProductsPage = new UserProductsPage(driver, loginPage, "productuser", "user");
        ProductPopupMenuPage productPopupMenuPage = new ProductPopupMenuPage(driver, userProductsPage, "Product");

        return new Object[][]{
                {userProductsPage},
                {productPopupMenuPage}
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


}
