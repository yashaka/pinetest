package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pineproject.pinetest.pages.*;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.pineproject.yaf.HaveExpectedElements;
import org.testng.annotations.*;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class StaticContentTest {

    @Test(dataProvider = "adminPageObjects")
    public void testAdminPageExpectedElements(final ExtendedLoadableComponent page) {
        assertPageExpectedElementsAreDisplayed(page);
    }

    @Test(dataProvider = "userPageObjects")
    public void testUserPageExpectedElements(final ExtendedLoadableComponent page) {
        assertPageExpectedElementsAreDisplayed(page);
    }

    @DataProvider
    private Object[][] adminPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, "http://localhost:8080/pine");
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, "admin", "nimda",
                Arrays.asList("ProductsList", "SuperProduct"));

        return new Object[][]{
                {loginPage},
                    {adminProductsPage}
        };
    }

    @DataProvider
    private Object[][] userPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, "http://localhost:8080/pine");
        ProductsPage userProductsPage = new UserProductsPage(driver, loginPage, "productuser", "user",
                Arrays.asList("ProductsList"));

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

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
}
