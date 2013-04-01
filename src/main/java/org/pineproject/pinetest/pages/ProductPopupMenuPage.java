package org.pineproject.pinetest.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.core.ExtendedLoadableComponent;
import org.pineproject.pinetest.core.elements.Element;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.AssertJUnit.fail;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 01.04.13
 * Time: 09:06
 */
public class ProductPopupMenuPage extends ExtendedLoadableComponent{

    @FindBy(linkText = "Edit product")
    private Link editProductLnk;

    @FindBy(linkText = "Delete product")
    private Link deleteProductLnk;

    @Override
    public List<TypifiedElement> getExpectedElements() {
        return new LinkedList<TypifiedElement>(){{
            add(editProductLnk);
            add(deleteProductLnk);
        }};
    }

    @Override
    protected void load() {
        productsPage.get();
        productsPage.popupProductMenu(productName);
    }

    @Override
    protected void isLoaded() throws Error {
        if (editProductLnk == null) {
            fail("Can't get editProductLnk instance");
        }
        try {
            editProductLnk.isDisplayed();
        } catch (NoSuchElementException e) {
            fail("Can't locate 'Edit product' item");
        }
    }

    public ProductPopupMenuPage(WebDriver driver, ProductsPage productsPage, String productName) {
        super(driver);
        this.productsPage = productsPage;
        this.productName = productName;
    }

    private ProductsPage productsPage;
    private String productName;
}
