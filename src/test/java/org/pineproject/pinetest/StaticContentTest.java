package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pineproject.pinetest.pages.*;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.testng.annotations.*;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;
import static ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers.hasText;

@Test(groups = {"smoke"})
public class StaticContentTest {

    @DataProvider
    private Object[][] adminPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, "admin", "nimda");

        return new Object[][]{
                {loginPage},
                {adminProductsPage}
        };
    }

    @Test(dataProvider = "adminPageObjects")
    public void testAdminPageExpectedElementsAreDisplayed(final ExtendedLoadableComponent page) {
        assertPageExpectedElementsAreDisplayed(page);
    }


    @DataProvider
    private Object[][] userPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        UserProductsPage userProductsPage = new UserProductsPage(driver, loginPage, "productuser", "user");

        return new Object[][]{
                {userProductsPage}
        };
    }

    @Test(dataProvider = "userPageObjects")
    public void testUserPageExpectedElementsAreDisplayed(final ExtendedLoadableComponent page) {
        assertPageExpectedElementsAreDisplayed(page);
    }


    @DataProvider
    private Object[][] pagesWithNamesAfterLogIn() {
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

    @Test(dataProvider = "pagesWithNamesAfterLogIn")
    public void testNameIsDisplayedAfterLogin(ProductsPage productsPage, String name) {
        productsPage.get();
        assertThat(productsPage.getUserNameLabel(), hasText(name));
    }


    @DataProvider
    private Object[][] pagesWithProductNamesList() {
        String userName = "productuser";
        String adminName = "admin";
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        ProductsPage  userProductsPage =  new UserProductsPage(driver, loginPage, userName, "user");
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, adminName, "nimda");

        return new Object[][]{
                {userProductsPage, Arrays.asList("Product")},
                {adminProductsPage, Arrays.asList("Product", "SuperProduct")}
        };
    }

    @Test(dataProvider = "pagesWithProductNamesList")
    public void testAllProductsAreListedAfterLogin(ProductsPage productsPage, List<String> products) {
        productsPage.get();
        assertThat(productsPage.getProductLinkTexts(), equalTo(products));
    }

    private void assertPageExpectedElementsAreDisplayed(final ExtendedLoadableComponent page) {
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
