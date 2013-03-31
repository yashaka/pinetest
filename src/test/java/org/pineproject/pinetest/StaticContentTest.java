package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pineproject.pinetest.pages.*;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.testng.annotations.*;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;
import static ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers.hasText;

@Test(groups = {"smoke"})
public class StaticContentTest {

    @Test(dataProvider = "adminPageObjects")
    public void testAdminPageExpectedElementsAreDisplayed(final ExtendedLoadableComponent page) {
        assertPageExpectedElementsAreDisplayed(page);
    }

    @Test(dataProvider = "userPageObjects")
    public void testUserPageExpectedElementsAreDisplayed(final ExtendedLoadableComponent page) {
        assertPageExpectedElementsAreDisplayed(page);
    }

    @DataProvider
    private Object[][] pagesWithNamesAfterLogIn() {
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        ProductsPage  userProductsPage =  new UserProductsPage(driver, loginPage, "productuser", "user");
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, "admin",      "nimda");

        return new Object[][]{
                {loginPage, userProductsPage, "productuser"},
                {loginPage, adminProductsPage, "admin"}
        };
    }

    @Test(dataProvider = "pagesWithNamesAfterLogIn")
    public void testNameIsDisplayedAfterLogin(LoginPage loginPage, ProductsPage producsPage, String name) {
        producsPage.get();
        assertThat(producsPage.getUserNameLabel(), hasText(name));
    }

    @DataProvider
    private Object[][] adminPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, "admin", "nimda");

        return new Object[][]{
                {loginPage},
                    {adminProductsPage}
        };
    }

    @DataProvider
    private Object[][] userPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, pineUrl);
        UserProductsPage userProductsPage = new UserProductsPage(driver, loginPage, "productuser", "user");

        return new Object[][]{
                    {userProductsPage}
        };
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
