package org.pineproject.pinetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.testng.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;


public class LoginPage extends ExtendedLoadableComponent<LoginPage> {

    @FindBy(id = "login-logo")
    private WebElement logoImg;

    @FindBy(xpath = "//div[text()='Username:']")
    private WebElement usernameLbl;

    private WebElement username;

    @FindBy(xpath = "//div[text()='Password:']")
    private WebElement passwordLbl;

    @FindBy(name = "pass")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginBtn;

    @Override
    public List<WebElement> getExpectedElements() {
        return new LinkedList<WebElement>(Arrays.asList(
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
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }

    @Override
    protected void load() {
        driver.get(pineURL);
        driver.get(pineURL + "/logout");
    }

    @Override
    public void isLoaded() throws Error {
        try {
            WebElement btn = driver.findElement(By.xpath("//input[@value='Log in']"));
        } catch (NoSuchElementException e) {
            fail("Can't locate 'Log in' button");
        }
//        assertTrue(loginBtn.isDisplayed(), "Can't locate 'Log in' button"); //TODO: why PageFactory locate doesn't work?
    }

    public LoginPage(WebDriver driver, String pineURL) {
        super(driver);
        this.pineURL = pineURL;
    }

    private String pineURL;

}
