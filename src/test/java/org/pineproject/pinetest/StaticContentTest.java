package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pineproject.pinetest.pages.*;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class StaticContentTest {

    @Test(dataProvider = "adminPageObjects")
    public void testAdminExpectedElements(final ExtendedLoadableComponent page) {
        page.get();
//        for(WebElement element : page.getExpectedElements()) {    TODO: why this does not work?
        List<WebElement> expectedElements = (List<WebElement>)page.getExpectedElements();
        for(WebElement element : expectedElements) {
            assertTrue(element.isDisplayed());
        }
    }

    @DataProvider
    private Object[][] adminPageObjects() {
        //testing admin user
        LoginPage loginPage = new LoginPage(driver, "http://localhost:8080/pine");
        ProductsPage adminProductsPage = new AdminProductsPage(driver, loginPage, "admin", "nimda");
        ProductsBreadCrump productsBreadCrump = new ProductsBreadCrump(driver, adminProductsPage);
        UserPanel adminPanel = new AdminUserPanel(driver, adminProductsPage);
            /* so far, there is no restriction/explicit-guideline to path the instance of AdminProductsPage
             *   to the AdminUserPanel#init method. TODO: add the restriction explicitly,
             *   e.g. change the type of the adminProductsPage parameter to AdminProductPage
             */

        //testing noadmin user
//        LoginPage loginPage = new LoginPage().init(driver, "http://localhost:8080/pine");
//        ProductsPage productsPage = new ProductsPage()
//                .init(driver, loginPage, "productuser", "user");
//        ProductsBreadCrump productsBreadCrump = new ProductsBreadCrump()
//                .init(driver, adminProductsPage);
//        UserPanel adminPanel = new AdminUserPanel().init(driver, adminProductsPage);

        return new Object[][]{
                {loginPage},
                  {adminProductsPage},
                    {productsBreadCrump},
                    {adminPanel}
        };
    }

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
