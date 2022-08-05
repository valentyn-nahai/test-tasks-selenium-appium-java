package org.test.task.selenium;

import org.openqa.selenium.WebDriver;
import org.test.task.selenium.driver.DriverManager;
import org.test.task.selenium.driver.TargetFactory;
import org.testng.annotations.*;

import static org.test.task.selenium.config.ConfigurationManager.configuration;


public abstract class BaseWebTest {

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(configuration().url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
