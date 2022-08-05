package org.test.selenium.project.pages;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.test.selenium.project.config.ConfigurationManager;
import org.test.selenium.project.driver.DriverManager;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPageObject {

    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), ConfigurationManager.configuration().timeout()), this);
    }
}
