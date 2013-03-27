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
 * Time: 18:43
 */
public class ProductsBreadCrump extends ExtendedLoadableComponent<ProductsBreadCrump> {

    @FindBy(id = "logo-mini")
    public WebElement pineRootLogo;

    @Override
    public List<WebElement> getExpectedElements() {
        return Arrays.asList(
                pineRootLogo
        );
    }

    @Override
    protected void load() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void isLoaded() throws Error {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public ProductsBreadCrump init(WebDriver driver, ProductsPage productsPage) {
        return super.init(driver, this);
    }
}
