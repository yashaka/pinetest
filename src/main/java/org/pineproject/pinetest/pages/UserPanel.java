package org.pineproject.pinetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.AbstractContainer;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.pineproject.yaf.elements.Element;

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
public class UserPanel extends AbstractContainer {

    @FindBy(xpath = "//span[text()='User: ']")
    private Element userLbl;

    private Element userName;    // TODO: ? check statically "what the name?"

    @FindBy(id = "lnk-admin-page")
    public Element adminSpn;

    @FindBy(linkText = "Log out")
    private Element logoutLnk;

}
