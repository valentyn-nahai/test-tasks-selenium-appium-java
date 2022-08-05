package org.test.selenium.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPageObject {
    @FindBy(id = "totalp")
    private WebElement totalPriceHeader;

    @FindBy(xpath = "//tr[@class='success']")
    private List<WebElement> deleteButtonList;

    public String getTotalPriceHeader() {
        return totalPriceHeader.getText();
    }

    public void deleteProductByName(String name) {
        deleteButtonList.stream()
                .filter(webElement -> webElement.getText().contains(name))
                .findFirst()
                .get()
                .findElement(By.cssSelector("a"))
                .click();
    }
}
