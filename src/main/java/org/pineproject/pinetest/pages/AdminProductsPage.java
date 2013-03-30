package org.pineproject.pinetest.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.containers.AdminUserPanel;
import org.pineproject.yaf.elements.Element;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 26.03.13
 * Time: 14:20
 */
public class AdminProductsPage extends ProductsPage {

    private AdminUserPanel adminUserPanel;

    @FindBy(xpath = "//*[contains(text(),'Add product')]")
    private Element addProductBtn;

    @Override
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = super.getExpectedElements();
        list.add(addProductBtn);
        list.addAll(adminUserPanel.getExpectedElements());
        return list;
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        if (addProductBtn == null) {
            fail("Can't get addProductBtn instance");
        }
        try {
            addProductBtn.getWrappedElement();
        } catch (NoSuchElementException e) {
            fail("Can't locate correct 'Add product' button");
        }
    }

    public AdminProductsPage(WebDriver driver, LoginPage loginPage, String username, String password, List<String> products) {
        super(driver, loginPage, username, password, products);
    }

}
