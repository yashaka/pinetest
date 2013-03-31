package org.pineproject.pinetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.containers.SimpleUserPanel;
import org.pineproject.pinetest.core.elements.Element;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.fail;
/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 30.03.13
 * Time: 01:18
 */
public class UserProductsPage extends ProductsPage {

    private SimpleUserPanel simpleUserPanel;

    @FindBy(xpath = "//body[not(*[contains(text(),'Add product')])]")
    private Element bodyWithNoAddProductBtn;

    @Override
    public TypifiedElement getUserNameLabel() {
        return simpleUserPanel.getUserName();
    }

    @Override
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = super.getExpectedElements();
        list.addAll(simpleUserPanel.getExpectedElements());
        list.add(bodyWithNoAddProductBtn);
        return list;
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        if (simpleUserPanel == null) {
            fail("Can't get simpleUserPanel instance");
        }
        try {
            simpleUserPanel.getExpectedElements().get(0).isDisplayed();
        } catch (NoSuchElementException e) {
            fail("Can't locate correct user panel");
        }
    }

    public UserProductsPage(WebDriver driver, LoginPage loginPage, String username, String password) {
        super(driver, loginPage, username, password);
    }
}
