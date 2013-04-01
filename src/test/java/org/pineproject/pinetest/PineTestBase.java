package org.pineproject.pinetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 01.04.13
 * Time: 06:42
 */
public class PineTestBase {

    protected WebDriver driver;
    protected String pineUrl;

    @Parameters("pine-url")
    @BeforeClass
    public void beforeClass(String pineUrl) {
        driver = new FirefoxDriver();
        this.pineUrl = pineUrl;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
