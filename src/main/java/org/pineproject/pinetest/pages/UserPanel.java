package org.pineproject.pinetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.ExtendedLoadableComponent;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 25.03.13
 * Time: 15:22
 */
public class UserPanel extends ExtendedLoadableComponent<UserPanel> {

    @FindBy(css = "#lbl-user:contains('User:')")
    public WebElement userLbl;

    public WebElement userName;    // TODO: check statically "what the name?"

    @FindBy(id = "lnk-admin")
    public WebElement adminLnk;

    @FindBy(linkText = "Log out")
    public WebElement logoutLnk;

    @Override
    public List<WebElement> getExpectedElements() {
        return Arrays.asList(
                userLbl,
                userName,
                adminLnk,
                logoutLnk
        );
    }

    @Override
    protected void load() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void isLoaded() throws Error {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public UserPanel init(WebDriver driver) {
        super.init(driver, this);
        return this;
    }
}
