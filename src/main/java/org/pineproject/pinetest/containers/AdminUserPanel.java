package org.pineproject.pinetest.containers;

import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.core.elements.Element;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 26.03.13
 * Time: 17:59
 */
@Block(@FindBy(id = "user-panel"))
public class AdminUserPanel extends UserPanel {

    @FindBy(linkText = "Admin page")
    public Element adminSpn;

    @Override
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = super.getExpectedElements();
        list.add(adminSpn);
        return list;
    }
}
