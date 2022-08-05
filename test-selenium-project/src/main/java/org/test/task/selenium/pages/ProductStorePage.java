package org.test.task.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.test.task.selenium.driver.DriverManager;

import java.util.List;

public class ProductStorePage extends AbstractPageObject {
    @FindBy(css = ".hrefch")
    List<WebElement> productCardList;

    public void clickOnProductCardByName(String name) {
        productCardList.stream()
                .filter(webElement -> webElement.getText().equals(name))
                .findFirst()
                .get()
                .click();


    }
}
