package org.test.appium.project.test;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.test.appium.project.driver.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected AppiumDriver<?> driver = null;

    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "udid", "platformVersion"})
    @Step
    public void preCondition(String platform, String udid, String platformVersion) {
        driver = new DriverFactory().createInstance(platform, udid, platformVersion);
    }

    @AfterTest(alwaysRun = true)
    @Step
    public void tearDown() {
        driver.quit();
    }
}
