package org.test.selenium.project;

import org.openqa.selenium.WebDriver;
import org.test.selenium.project.config.ConfigurationManager;
import org.test.selenium.project.driver.DriverManager;
import org.test.selenium.project.driver.TargetFactory;
import org.testng.annotations.*;


public abstract class BaseWebTest {

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(ConfigurationManager.configuration().url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
