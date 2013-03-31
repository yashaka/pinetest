package org.pineproject.pinetest.containers;

import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.elements.Element;
import org.pineproject.yaf.elements.ExtendedHtmlElement;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 25.03.13
 * Time: 15:22
 */
@Block(@FindBy(id = "user-panel"))
public abstract class UserPanel extends ExtendedHtmlElement {

    @FindBy(xpath = "//span[text()='User: ']")
    private Element userLbl;

    @FindBy(id = "userName")
    private Element userName;    // TODO: ? check statically "what the name?"

    @FindBy(linkText = "Log out")
    private Element logoutLnk;

    public Element getUserName() {
        return userName;
    }

    @Override
    public List<TypifiedElement> getExpectedElements() {
        return new LinkedList<TypifiedElement>(Arrays.asList(
                userLbl,
                userName,
                logoutLnk
        ));
    }
}
