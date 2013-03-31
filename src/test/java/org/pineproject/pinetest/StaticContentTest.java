package org.pineproject.pinetest;

import org.pineproject.pinetest.pages.*;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.testng.annotations.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers.hasText;

/*
 * The name for this test sounds nice:) but actually the name should be: ContentStaticTest
 * The latter better describes what is covered here:
 * - static verification of all content on all pages passed from DataProviders:
 *  - i.e. assuring that all elements on the page (including dynamically generated) are displayed.
 *
 * So far only two pages are covered: LoginPage and ProductsPage. That's why all tests live here.
 * As soon as more pages will be covered, separate classes will be created
 * and combined in a "ContentStatic" testNG Test or Suite.
 */
@Test(groups = {"smoke"})
public class StaticContentTest extends StaticContentTestDataProviderBase {

    @Test(dataProvider = "adminPageObjects")
    public void testAdminPageExpectedElementsAreDisplayed(final ExtendedLoadableComponent page) {
        assertPageExpectedElementsAreDisplayed(page);
    }

    @Test(dataProvider = "userPageObjects")
    public void testUserPageExpectedElementsAreDisplayed(final ExtendedLoadableComponent page) {
        assertPageExpectedElementsAreDisplayed(page);
    }

    @Test(dataProvider = "pagesWithNamesAfterLogIn")
    public void testNameIsDisplayedAfterLogin(ProductsPage productsPage, String name) {
        productsPage.get();
        assertThat(productsPage.getUserNameLabel(), hasText(name));
    }

    @Test(dataProvider = "pagesWithProductNamesList")
    public void testAllProductsAreListedAfterLogin(ProductsPage productsPage, List<String> products) {
        productsPage.get();
        assertThat(productsPage.getProductLinkTexts(), equalTo(products));
    }
}
