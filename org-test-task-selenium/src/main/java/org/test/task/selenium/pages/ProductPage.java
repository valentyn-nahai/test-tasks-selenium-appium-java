package org.test.task.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPageObject {
    @FindBy(css = ".btn-success")
    private WebElement addToCartButton;

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }
}
