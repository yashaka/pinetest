package org.pineproject.pinetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.ExtendedLoadableComponent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 25.03.13
 * Time: 18:43
 */
public class ProductsBreadCrump extends ExtendedLoadableComponent<ProductsBreadCrump> {

    @FindBy(id = "home")
    private WebElement pineHomeLnk;

    @Override
    public List<WebElement> getExpectedElements() {
        return new LinkedList<WebElement>(Arrays.asList(
                pineHomeLnk
        ));
    }

    @Override
    protected void load() {
       productsPage.get();
    }

    @Override
    public void isLoaded() throws Error {
        productsPage.isLoaded();
    }

    public ProductsBreadCrump(WebDriver driver, ProductsPage productsPage) {
        super(driver);
        this.productsPage = productsPage;
    }

    private ProductsPage productsPage;
}
