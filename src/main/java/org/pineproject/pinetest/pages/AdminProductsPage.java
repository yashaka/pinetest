package org.pineproject.pinetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.elements.Element;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 26.03.13
 * Time: 14:20
 */
public class AdminProductsPage extends ProductsPage {

    @FindBy(xpath = "//*[contains(text(),'Add product')]")
    private Element addProductBtn;

    @Override
    public List<Element> getExpectedElements() {
        List<Element> list = super.getExpectedElements();
        list.add(addProductBtn);
        return list;
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try {
            WebElement btn = driver.findElement(By.id("btn-add-product")); //TODO: a bit of code duplication, refactor!
        } catch (NoSuchElementException e) {
            fail("Can't locate correct 'Add product' button");
        }
    }

    public AdminProductsPage(WebDriver driver, LoginPage loginPage, String username, String password) {
        super(driver, loginPage, username, password);
    }

}
