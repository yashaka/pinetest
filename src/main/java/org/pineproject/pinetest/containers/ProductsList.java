package org.pineproject.pinetest.containers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.core.elements.ExtendedHtmlElement;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 30.03.13
 * Time: 20:37
 */
@Block(@FindBy(className = "table"))
public class ProductsList extends ExtendedHtmlElement {

//    @FindBy(css = "a[href^='?product='] > span")
    @FindBy(className = "product-item")
    private List<Link> productLinks;

    public List<Link> getProductLinks() {
        return productLinks;
    }

    @Override
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = new LinkedList<TypifiedElement>();
        list.addAll(productLinks);
        return list;
    }

    /*
     * Returns TypifiedElement once product with specified name was found
     * Returns null otherwise
     */
    public TypifiedElement getProductByName(String productName) throws NoSuchElementException {
        Link productFound = null;
        for(Link product : productLinks) {
            String productText = product.getText();
            if (productText.equals(productName)) {
                productFound = product;
            }
        }
        if (productFound == null) {
            throw new NoSuchElementException("Can't find product with specified name: " + productName);
        }
        else {
            return productFound;
        }
    }
}
