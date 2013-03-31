package org.pineproject.pinetest.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.pineproject.pinetest.containers.BreadCrump;
import org.pineproject.pinetest.containers.ProductsList;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.pineproject.yaf.elements.Element;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.LinkedList;
import java.util.List;

import static org.testng.AssertJUnit.fail;


public abstract class ProductsPage extends ExtendedLoadableComponent<ProductsPage> {

    @FindBy(xpath = "//div[@id='breadcrump' and not(span[@id='extends-symbol'])]")
    private BreadCrump breadcrump;

    private ProductsList productsList;

    public abstract TypifiedElement getUserNameLabel();

    public List<Link> getProductLinks() {
        return productsList.getProductLinks();
    }

    public List<String> getProductLinkTexts() {
        return new LinkedList<String>() {{
           for(Link link : getProductLinks()) {
               add(link.getText());
           }
        }};
    }

    @Override
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = new LinkedList<TypifiedElement>();
        list.addAll(breadcrump.getExpectedElements());
        list.addAll(productsList.getExpectedElements());
        return list;
    }

    @Override
    protected void load() {
        loginPage.get();
        loginPage.login(username, password);
    }

    @Override
    protected void isLoaded() throws Error {
        if (breadcrump == null) {
            fail("Can't get breadcrump instance");
        }
        try {
            breadcrump.isDisplayed();
        } catch (NoSuchElementException e) {
            fail("Can't locate user label in userpanel or breadcrump with the only root node");
        }
    }

    public ProductsPage(WebDriver driver, LoginPage loginPage, String username, String password/*, List<String> products*/) {
        super(driver);
        this.loginPage = loginPage;
        this.username = username;
        this.password = password;
//        this.products = products;
    }

    private LoginPage loginPage;
    private String username;
    private String password;
//    private List<String> products;

}

