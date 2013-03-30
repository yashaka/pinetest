package org.pineproject.pinetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.containers.SimpleUserPanel;
import org.pineproject.yaf.elements.Element;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;

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
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = super.getExpectedElements();
        list.addAll(simpleUserPanel.getExpectedElements());
        list.add(bodyWithNoAddProductBtn);
        return list;
    }

    public UserProductsPage(WebDriver driver, LoginPage loginPage, String username, String password/*, List<String> products*/) {
        super(driver, loginPage, username, password/*, products*/);
    }
}
