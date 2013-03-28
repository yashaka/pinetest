package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pineproject.pinetest.pages.*;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.pineproject.yaf.elements.Element;
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
        List<Element> expectedElements = (List<Element>)page.getExpectedElements();
        for(Element element : expectedElements) {
            assertTrue(element.isDisplayed());
        }
    }

    @DataProvider
    private Object[][] adminPageObjects() {
        LoginPage            loginPage = new LoginPage(driver, "http://localhost:8080/pine");
        ProductsPage adminProductsPage = new ProductsPage(driver, loginPage, "admin", "nimda");

        return new Object[][]{
                {loginPage},
                  {adminProductsPage},
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
