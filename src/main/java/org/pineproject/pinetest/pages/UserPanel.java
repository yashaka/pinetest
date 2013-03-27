package org.pineproject.pinetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.ExtendedLoadableComponent;

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
public class UserPanel extends ExtendedLoadableComponent<UserPanel> {

    @FindBy(xpath = "//span[text()='User: ']")
    private WebElement userLbl;

    private WebElement userName;    // TODO: ? check statically "what the name?"

    @FindBy(id = "lnk-admin-page")
    public WebElement adminSpn;

    @FindBy(linkText = "Log out")
    private WebElement logoutLnk;

    @Override
    public List<WebElement> getExpectedElements() {
        return new LinkedList<WebElement>(Arrays.asList(
                userLbl,
                userName,
                adminSpn,
                logoutLnk
        ));
    }

    @Override
    protected void load() {
        adminProductsPage.get();
    }

    @Override
    public void isLoaded() throws Error {
        assertTrue(adminSpn.getText().isEmpty());
    }

    public UserPanel(WebDriver driver, ProductsPage adminProductsPage) {
        super(driver);
        this.adminProductsPage = adminProductsPage;
    }

    private ProductsPage adminProductsPage;
}
