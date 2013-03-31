package org.pineproject.pinetest.core.elements;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 28.03.13
 * Time: 05:56
 */
public class Element extends TypifiedElement {
    public Element(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
