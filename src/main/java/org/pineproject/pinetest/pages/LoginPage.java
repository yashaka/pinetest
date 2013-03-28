package org.pineproject.pinetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pineproject.yaf.ExtendedLoadableComponent;
import org.pineproject.yaf.elements.Element;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.fail;


public class LoginPage extends ExtendedLoadableComponent<LoginPage> {

//    @FindBy(id = "login-logo")
//    private Element logoImg;
//
//    @FindBy(xpath = "//div[text()='Username:']")
//    private Element usernameLbl;

    private TextInput username;

//    @FindBy(xpath = "//div[text()='Password:']")
//    private Element passwordLbl;

    @FindBy(name = "pass")
    private TextInput password;

    @FindBy(xpath = "//input[@value='Log in']")
    private Button loginBtn;

    @Override
    public List<TypifiedElement> getExpectedElements() {
        return new LinkedList<TypifiedElement>(Arrays.asList(
//            logoImg,
//            usernameLbl,
            username,
//            passwordLbl,
            password,
            loginBtn
        ));
    }

    public void login(String username, String password) {
        //TODO: change to clearAndType(...)
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        loginBtn.click();
    }

    @Override
    protected void load() {
        driver.get(pineURL); //TODO: delete this line on pine fixed regarding this...
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
