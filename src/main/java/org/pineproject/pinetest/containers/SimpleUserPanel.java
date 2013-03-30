package org.pineproject.pinetest.containers;

import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.containers.UserPanel;
import org.pineproject.yaf.elements.Element;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 30.03.13
 * Time: 01:34
 */
@Block(@FindBy(id = "user-panel"))
public class SimpleUserPanel extends UserPanel {

    @FindBy(xpath = "//div[@id='user-panel' and not(*[contains(text(),'Admin page')])]")
    public Element userPanelWithNoAdminLnk;

    @Override
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = super.getExpectedElements();
        list.add(userPanelWithNoAdminLnk);
        return list;
    }
}
