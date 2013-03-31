package org.pineproject.pinetest.core.elements;

import org.pineproject.pinetest.core.HaveExpectedElements;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 28.03.13
 * Time: 14:44
 */
public abstract class ExtendedHtmlElement extends HtmlElement implements HaveExpectedElements {
    public abstract List<TypifiedElement> getExpectedElements();
}
