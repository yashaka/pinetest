package org.pineproject.pinetest.pages;

import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.AbstractContainer;
import org.pineproject.yaf.elements.Element;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 27.03.13
 * Time: 16:57
 */
public class BreadCrump extends AbstractContainer {

    @FindBy(id = "home")
    private Element pineHomeLnk;
}
