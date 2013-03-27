package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pineproject.pinetest.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.text.NavigationFilter;

public class LoginTest extends Assert {

    @Test
    public void testLoginPageHaveExpectedElements() {
//        LoginPage loginPage = new LoginPage(driver, "http:localhost:8080/pine");
//        loginPage.get();
//        for(WebElement element : loginPage.getExpectedElements()) {
//            assertTrue(element.isDisplayed());
//        }
    }

    @Test(dataProvider = "parseUserCredentials", groups = "functions")
    public void testValidLogin(String user, String password) throws InterruptedException {
//        goHelper.
//                goLoginPage();
//                login(user, password);
//                assertEquals(actual, expected);
        driver.get("http://localhost:8080/pine/");
        Thread.sleep(4000);
    }

    @DataProvider
    public Object[][] parseUserCredentials() {
        return new Object[][]{
                {"admin", "admin"},
        };
    }

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public LoginTest(){
//        goHelper = new GoHelper(driver);
    }

    private WebDriver driver;
//    private GoHelper goHelper;
}
