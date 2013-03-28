package org.pineproject.pinetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.pineproject.yaf.elements.Element;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.AssertJUnit.fail;


public class ProductsPage extends ExtendedLoadableComponent<ProductsPage> {

    @FindBy(className = "table")
    private Element productsTbl;

    private BreadCrump breadcrump;

    private UserPanel userPanel;


    @Override
    public List<TypifiedElement> getExpectedElements() {
        List<TypifiedElement> list = new LinkedList<TypifiedElement>();
        list.add(productsTbl);
        list.addAll(breadcrump.getExpectedElements());
        list.addAll(userPanel.getExpectedElements());
        return list;
    }

    @Override
    protected void load() {
        loginPage.get();
        loginPage.login(username, password);
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            WebElement bc = driver.findElement(By.xpath("//div[@id='breadcrump' and not(span[@id='extends-symbol'])]"));
            WebElement user = driver.findElement(By.xpath("//*[@id='userName' and text()='"+username+"']"));
        } catch (NoSuchElementException e) {
            fail("Can't locate user label in userpanel or breadcrump with the only root node");
        }
    }

    public ProductsPage(WebDriver driver, LoginPage loginPage, String username, String password) {
        super(driver);
        this.loginPage = loginPage;
        this.username = username;
        this.password = password;
    }

    private LoginPage loginPage;
    private String username;
    private String password;

}

