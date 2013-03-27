package org.pineproject.pinetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
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

    @FindBy(id = "btn-add-product")
    private WebElement addProductBtn;

    @Override
    public List<WebElement> getExpectedElements() {
        List<WebElement> list = super.getExpectedElements();
        list.add(addProductBtn);
        return list;
    }

    @Override
    public void isLoaded() throws Error {
        super.isLoaded();
        try {
            assertTrue(addProductBtn.getText().contains("Add product"));
        } catch (NoSuchElementException e) {
            fail("Can't locate correct 'Add product' button");
        }
    }

    public AdminProductsPage(WebDriver driver, LoginPage loginPage, String username, String password) {
        super(driver, loginPage, username, password);
    }

}
