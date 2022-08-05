package org.test.task.selenium.pages;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.test.task.selenium.driver.DriverManager;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.test.task.selenium.config.ConfigurationManager.configuration;

public class AbstractPageObject {

    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().timeout()), this);
    }
}
