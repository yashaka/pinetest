package org.pineproject.pinetest.containers;

import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.core.elements.Element;
import org.pineproject.pinetest.core.elements.ExtendedHtmlElement;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 27.03.13
 * Time: 16:57
 */

@Block(@FindBy(id = "breadcrump"))
public class BreadCrump extends ExtendedHtmlElement {

    @FindBy(id = "home")
    private Element pineHomeLnk;

    @Override
    public List<TypifiedElement> getExpectedElements() {
        return new LinkedList<TypifiedElement>(Arrays.asList(
                pineHomeLnk
        ));
    }
}
