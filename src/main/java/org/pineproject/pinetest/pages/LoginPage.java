package org.pineproject.pinetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.pineproject.yaf.elements.Button;
import org.pineproject.yaf.elements.Element;
import org.pineproject.yaf.elements.TextField;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.fail;


public class LoginPage extends ExtendedLoadableComponent<LoginPage> {

    @FindBy(id = "login-logo")
    private Element logoImg;

    @FindBy(xpath = "//div[text()='Username:']")
    private Element usernameLbl;

    private TextField username;

    @FindBy(xpath = "//div[text()='Password:']")
    private Element passwordLbl;

    @FindBy(name = "pass")
    private TextField password;

    @FindBy(xpath = "//input[@value='Log in']")
    private Button loginBtn;

    @Override
    public List<Element> getExpectedElements() {
        return new LinkedList<Element>(Arrays.asList(
            logoImg,
            usernameLbl,
            username,
            passwordLbl,
            password,
            loginBtn
        ));
    }

    public void login(String username, String password) {
        //TODO: change to clearAndType when implemented
        this.username.clearAndType(username);
        this.password.clearAndType(password);
        loginBtn.click();
    }

    @Override
    protected void load() {
        driver.get(pineURL);
        driver.get(pineURL + "/logout");
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            WebElement btn = driver.findElement(By.xpath("//input[@value='Log in']"));
        } catch (NoSuchElementException e) {
            fail("Can't locate 'Log in' button");
        }
    }

    public LoginPage(WebDriver driver, String pineURL) {
        super(driver);
        this.pineURL = pineURL;
    }

    private String pineURL;

}
