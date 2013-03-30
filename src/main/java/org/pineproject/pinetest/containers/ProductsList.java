package org.pineproject.pinetest.containers;

import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.elements.ExtendedHtmlElement;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Collection;
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

    @FindBy(css = "a[href^='?product=']")
    private List<Link> productLinks;

    @Override
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = new LinkedList<TypifiedElement>();
        list.addAll(productLinks);
        return list;
    }
}
